package com.letung.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letung.daoimp.SanPhamimp;
import com.letung.entity.ChiTietSanPham;
import com.letung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamimp {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> getListProductLimit(int startProduct) {
		List<SanPham> listProduct = new ArrayList<SanPham>();
		Session session = sessionFactory.getCurrentSession();
		if(startProduct < 0) {
			listProduct = (List<SanPham>) session.createQuery("from sanpham").getResultList();	
		}else {
			listProduct = (List<SanPham>) session.createQuery("from sanpham limit ").setFirstResult(startProduct).setMaxResults(5).getResultList();	
		}
		
		return listProduct;
	}

	@Override
	@Transactional
	public SanPham getListProductDetailById(int idProduct) {
		
		String query = "from sanpham as sp where sp.masanpham =" + idProduct;
		Session session = sessionFactory.getCurrentSession();
		SanPham productById = (SanPham) session.createQuery(query).getSingleResult();

		return productById;
	}

	@Override
	@Transactional
	public List<SanPham> getListProductByIdCategory(int idCategory) {
		String query = "from sanpham as sp where sp.danhmucsanpham.madanhmuc =" + idCategory;
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> productByIdCategory =  session.createQuery(query).getResultList();
		return productByIdCategory;
	}

	@Override
	@Transactional
	public boolean deleteProductById(int idProduct) {
		
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, idProduct);
		
		Set<ChiTietSanPham> listProductDetail = sanPham.getListChiTietSanPham();
		for (ChiTietSanPham productDetail : listProductDetail) {
			session.createQuery("delete chitiethoadon where machitietsanpham =" + productDetail.getMachitietsanpham()).executeUpdate();
			

		}
		session.createQuery("delete chitietsanpham where masanpham =" +idProduct).executeUpdate();
		
		session.createQuery("delete sanpham where masanpham =" + idProduct).executeUpdate();

		return false;
	}

	@Override
	@Transactional
	public boolean addProduct(SanPham product) {
		Session session = sessionFactory.getCurrentSession();
		int id =  (int) session.save(product);
		return false;
	}

	@Override
	@Transactional
	public boolean upDateProduct(SanPham product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		return false;
	}

	
	
}
