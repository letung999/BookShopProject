package com.letung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "sanpham")
public class SanPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int masanpham;

	@OneToOne
	@JoinColumn(name = "madanhmuc")
	DanhMucSanPham danhmucsanpham;

	String tensanpham;
	String giatien;
	String mota;
	String hinhsanpham;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "masanpham")
	Set<ChiTietSanPham> listChiTietSanPham;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "chitietkhuyenmai",
	joinColumns = {@JoinColumn(name = "masanpham", referencedColumnName = "masanpham") },
	inverseJoinColumns = {@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai") })
	Set<KhuyenMai> listKhuyenMai;

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
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

	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
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
