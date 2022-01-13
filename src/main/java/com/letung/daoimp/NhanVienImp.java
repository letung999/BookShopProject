package com.letung.daoimp;

import com.letung.entity.NhanVien;

public interface NhanVienImp {
	boolean checkInformationLogin(String email, String password);
	boolean addEmployee(NhanVien nhanVien);
	boolean selectUserExit(String email);
}
