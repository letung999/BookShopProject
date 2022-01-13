package com.letung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letung.dao.NhanVienDAO;
import com.letung.daoimp.NhanVienImp;
import com.letung.entity.NhanVien;


@Service
public class NhanVienService implements NhanVienImp{
	
	@Autowired
	NhanVienDAO nhanVienDAO;

	@Override
	public boolean checkInformationLogin(String email, String password) {
		boolean check = nhanVienDAO.checkInformationLogin(email, password);
		return check;
	}

	@Override
	public boolean addEmployee(NhanVien nhanVien) {
		boolean checkAddEmployee = nhanVienDAO.addEmployee(nhanVien);
		return checkAddEmployee;
	}

	@Override
	public boolean selectUserExit(String email) {
		// TODO Auto-generated method stub
		boolean employeeExit = nhanVienDAO.selectUserExit(email);
		return employeeExit;
	}
	
}
