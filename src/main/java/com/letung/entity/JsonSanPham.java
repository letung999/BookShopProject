package com.letung.entity;

import java.util.Set;

public class JsonSanPham {
	int masanpham;
	DanhMucSanPham danhmucsanpham;

	String tensanpham;
	String giatien;
	String mota;
	String hinhsanpham;
	Set<ChiTietSanPham> listChiTietSanPham;
	Set<KhuyenMai> listKhuyenMai;

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public Set<ChiTietSanPham> getListChiTietSanPham() {
		return listChiTietSanPham;
	}

	public void setListChiTietSanPham(Set<ChiTietSanPham> listChiTietSanPham) {
		this.listChiTietSanPham = listChiTietSanPham;
	}

	public Set<KhuyenMai> getListKhuyenMai() {
		return listKhuyenMai;
	}

	public void setListKhuyenMai(Set<KhuyenMai> listKhuyenMai) {
		this.listKhuyenMai = listKhuyenMai;
	}

}
