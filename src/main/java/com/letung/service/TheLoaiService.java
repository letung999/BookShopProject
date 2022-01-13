package com.letung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.TheLoaiDAO;
import com.letung.daoimp.TheLoaiImp;
import com.letung.entity.TheLoai;
@Service
public class TheLoaiService implements TheLoaiImp{
	@Autowired 
	TheLoaiDAO theLoaiDAO;

	@Override
	public List<TheLoai> getListCategory() {
		return theLoaiDAO.getListCategory();
	}

}
