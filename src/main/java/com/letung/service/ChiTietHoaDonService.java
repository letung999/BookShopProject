package com.letung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.ChiTietHoaDonDAO;
import com.letung.daoimp.ChiTietHoaDonImp;
import com.letung.entity.ChiTietHoaDon;


@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp{

	@Autowired 
	ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	
	@Override
	public boolean addDetailOrder(ChiTietHoaDon chiTietHoaDon) {
		
		return chiTietHoaDonDAO.addDetailOrder(chiTietHoaDon);
	}

}
