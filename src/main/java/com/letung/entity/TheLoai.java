package com.letung.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "theloai")
public class TheLoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int matheloai;
	String theloai;

	public int getMatheloai() {
		return matheloai;
	}

	public void setMatheloai(int matheloai) {
		this.matheloai = matheloai;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

}
