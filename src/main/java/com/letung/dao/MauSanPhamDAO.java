package com.letung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letung.daoimp.MauSanPhamImp;
import com.letung.entity.MauSanPham;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<MauSanPham> getColorProduct() {
		String query = "from mausanpham";
		Session session = sessionFactory.getCurrentSession();
		List<MauSanPham> listColorProduct = session.createQuery(query).getResultList();
		return listColorProduct;
	}

}
