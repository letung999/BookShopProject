package com.letung.daoimp;

import java.util.List;

import com.letung.entity.SanPham;

public interface SanPhamimp {
	List<SanPham> getListProductLimit(int startProduct);
	SanPham getListProductDetailById(int idProduct);
	List<SanPham> getListProductByIdCategory(int idCategory);
	boolean deleteProductById(int idProduct);
	boolean addProduct(SanPham product);
	boolean upDateProduct(SanPham product);
}
