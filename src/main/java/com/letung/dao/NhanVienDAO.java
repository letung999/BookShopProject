package com.letung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letung.daoimp.NhanVienImp;
import com.letung.entity.NhanVien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImp {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean checkInformationLogin(String email, String password) {

		Session session = sessionFactory.getCurrentSession();
		List<NhanVien> listNhanVien = session
				.createQuery("from nhanvien where email='" + email + "' and matkhau='" + password + "'")
				.getResultList();

		if (listNhanVien.size() != 0) {

			return true;

		} else {

			return false;
		}
	}

	@Override
	@Transactional
	public boolean addEmployee(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int idEmployee = (int) session.save(nhanVien);
		if (idEmployee > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean selectUserExit(String email) {
		try {

			String sql = "from nhanvien where email='" + email + "'";
			Session session = sessionFactory.getCurrentSession();
			NhanVien nhanVien = (NhanVien) session.createQuery(sql).getSingleResult();
			if (nhanVien.getEmail().equals(email)) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;

	}

}
