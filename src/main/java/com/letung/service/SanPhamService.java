package com.letung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.SanPhamDAO;
import com.letung.daoimp.SanPhamimp;
import com.letung.entity.SanPham;

@Service
public class SanPhamService implements SanPhamimp{
	
	@Autowired 
	SanPhamDAO sanPhamDAO;

	@Override
	public List<SanPham> getListProductLimit(int startProduct) {
		
		return sanPhamDAO.getListProductLimit(startProduct);
	}

	@Override
	public SanPham getListProductDetailById(int idProduct) {
		return sanPhamDAO.getListProductDetailById(idProduct);
	}

	@Override
	public List<SanPham> getListProductByIdCategory(int idCategory) {
		// TODO Auto-generated method stub
		return sanPhamDAO.getListProductByIdCategory(idCategory);
	}

	@Override
	public boolean deleteProductById(int idProduct) {
		// TODO Auto-generated method stub
		return sanPhamDAO.deleteProductById(idProduct);
	}

	@Override
	public boolean addProduct(SanPham product) {
		return sanPhamDAO.addProduct(product);
	}

	@Override
	public boolean upDateProduct(SanPham product) {
		// TODO Auto-generated method stub
		return sanPhamDAO.upDateProduct(product);
	}

}
