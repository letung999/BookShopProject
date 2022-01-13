package com.letung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letung.entity.DanhMucSanPham;
import com.letung.entity.SanPham;
import com.letung.service.DanhMucService;
import com.letung.service.SanPhamService;

@Controller
@RequestMapping("/danhmuc")
public class DanhMucController {

	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/{id}/{nameCategory}")
	public String Default(ModelMap modelMap, @PathVariable int id, @PathVariable String nameCategory) {
		List<SanPham> listProduct = sanPhamService.getListProductByIdCategory(id);
		List<DanhMucSanPham> listCategory = danhMucService.getListCategory();
		modelMap.addAttribute("listCategory",listCategory);
		
		modelMap.addAttribute("nameCategory",nameCategory);
		modelMap.addAttribute("listProduct",listProduct);
		
		return "danhmuc";
	}
}
