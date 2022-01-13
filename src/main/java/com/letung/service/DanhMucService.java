package com.letung.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.DanhMucDAO;
import com.letung.daoimp.DanhMucImp;
import com.letung.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp{
	
	@Autowired 
	DanhMucDAO danhMucDAO;
	@Override
	public List<DanhMucSanPham> getListCategory() {
		
		return danhMucDAO .getListCategory();
	}

}
