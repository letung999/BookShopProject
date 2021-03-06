package com.letung.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int machitietsanpham;

	@OneToOne()
	@JoinColumn(name = "masanpham")
	SanPham sanpham;

	@OneToOne()
	@JoinColumn(name = "matheloai")
	TheLoai theloai;

	@OneToOne()
	@JoinColumn(name = "mamau")
	MauSanPham mausanpham;

	int soluong;
	String ngaynhap;

	public int getMachitietsanpham() {
		return machitietsanpham;
	}

	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public TheLoai getTheloai() {
		return theloai;
	}

	public void setTheloai(TheLoai theloai) {
		this.theloai = theloai;
	}

	public MauSanPham getMausanpham() {
		return mausanpham;
	}

	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

}
