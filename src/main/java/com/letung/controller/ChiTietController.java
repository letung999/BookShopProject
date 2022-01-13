package com.letung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.letung.entity.Cart;
import com.letung.entity.DanhMucSanPham;
import com.letung.entity.SanPham;
import com.letung.service.DanhMucService;
import com.letung.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("cart")
public class ChiTietController {

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	

	@GetMapping("/{idProduct}")
	public String Default(@PathVariable int idProduct, ModelMap modelMap, HttpSession httpSession) {
		SanPham productById = sanPhamService.getListProductDetailById(idProduct);
		List<DanhMucSanPham> listCategory = danhMucService.getListCategory();
		if(httpSession.getAttribute("cart") != null) {
			List<Cart> listCart = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("quantityProduct",listCart.size());
			modelMap.addAttribute("listCart",listCart);
		}
		

		modelMap.addAttribute("productById",productById);
		modelMap.addAttribute("listCategory",listCategory);
		
		return "chitiet";
	}
}
