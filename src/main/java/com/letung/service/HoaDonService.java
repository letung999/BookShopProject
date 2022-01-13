package com.letung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.HoaDonDAO;
import com.letung.daoimp.HoaDonImp;
import com.letung.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {

	@Autowired
	HoaDonDAO hoaDonDAO;
	@Override
	public int addOrder(HoaDon hoadon) {
		
		return hoaDonDAO.addOrder(hoadon);
	}

}
