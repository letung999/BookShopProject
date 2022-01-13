package com.letung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letung.entity.DanhMucSanPham;
import com.letung.entity.SanPham;
import com.letung.service.DanhMucService;
import com.letung.service.SanPhamService;

@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;

	@GetMapping
	@Transactional
	public String Default(/* @SessionAttribute("user") String user, */ ModelMap modelMap, HttpSession httpSession) {
		List<DanhMucSanPham> listCategory = danhMucService.getListCategory();

		if (httpSession.getAttribute("user") != null) {
			String email = (String) httpSession.getAttribute("user");
			String firstWord = email.substring(0, 2).toUpperCase();
			modelMap.addAttribute("firstWord", firstWord);
		}
		
		
		List<SanPham>listProduct = sanPhamService.getListProductLimit(-1);
		modelMap.addAttribute("listProduct",listProduct);
		modelMap.addAttribute("listCategory",listCategory);
		return "trangchu";

	}
}
