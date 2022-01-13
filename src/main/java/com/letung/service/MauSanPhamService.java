package com.letung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.MauSanPhamDAO;
import com.letung.daoimp.MauSanPhamImp;
import com.letung.entity.MauSanPham;
@Service
public class MauSanPhamService implements MauSanPhamImp{

	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	@Override
	public List<MauSanPham> getColorProduct() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.getColorProduct();
	}

}
