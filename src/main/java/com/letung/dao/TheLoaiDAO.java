package com.letung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letung.daoimp.TheLoaiImp;
import com.letung.entity.TheLoai;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TheLoaiDAO implements TheLoaiImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<TheLoai> getListCategory() {
		// TODO Auto-generated method stub
		String query = "from theloai";
		Session session = sessionFactory.getCurrentSession();
		List<TheLoai> listCategory = session.createQuery(query).getResultList();
		return listCategory;
	}
	
	
}
