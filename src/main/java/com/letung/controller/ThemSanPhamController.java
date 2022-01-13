package com.letung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letung.dao.SanPhamDAO;
import com.letung.entity.DanhMucSanPham;
import com.letung.entity.MauSanPham;
import com.letung.entity.SanPham;
import com.letung.entity.TheLoai;
import com.letung.service.DanhMucService;
import com.letung.service.MauSanPhamService;
import com.letung.service.SanPhamService;
import com.letung.service.TheLoaiService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	
	
	@Autowired 
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired 
	TheLoaiService theLoaiService;
	
	@Autowired 
	MauSanPhamService mauSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<MauSanPham> listColorProductOption = mauSanPhamService.getColorProduct(); 
		List<TheLoai> listCategoryOption = theLoaiService.getListCategory();
		List<DanhMucSanPham> listCategory = danhMucService.getListCategory();
		List<SanPham> listProduct = sanPhamService.getListProductLimit(0);
		List<SanPham> allProduct = sanPhamService.getListProductLimit(-1);
		float totalPage = (float) ( 1.0 * allProduct.size() / 5);
		
		if(totalPage % 2 != 0) { totalPage = totalPage + 1; }
		 
		modelMap.addAttribute("listProduct",listProduct);
		modelMap.addAttribute("allProduct",allProduct);
		modelMap.addAttribute("totalPage",totalPage);
		modelMap.addAttribute("listCategory",listCategory);
		modelMap.addAttribute("listColorProductOption",listColorProductOption);
		modelMap.addAttribute("listCategoryOption",listCategoryOption);
		return "themsanpham";
	}

}
