package com.letung.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.letung.entity.Cart;
import com.letung.entity.ChiTietHoaDon;
import com.letung.entity.ChiTietHoaDonId;
import com.letung.entity.DanhMucSanPham;
import com.letung.entity.HoaDon;
import com.letung.service.ChiTietHoaDonService;
import com.letung.service.DanhMucService;
import com.letung.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
public class GioHangController {

	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	DanhMucService danhMucService;

	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		List<DanhMucSanPham> listCategory = danhMucService.getListCategory();
		modelMap.addAttribute("listCategory",listCategory);
		if (httpSession.getAttribute("cart") != null) {
			List<Cart> listCart = (List<Cart>) httpSession.getAttribute("cart");
			modelMap.addAttribute("quantityProduct", listCart.size());
			modelMap.addAttribute("listCart", listCart);
		}
		return "giohang";
	}

	@PostMapping(produces = "text/plain; charset=UTF-8")
	public String acceptOrder(@RequestParam String tenkhachhang, @RequestParam String sodt,
			@RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu,
			HttpSession httpSession) {

		
		  if (httpSession.getAttribute("cart") != null) { 
			  
			  List<Cart> listCart =(List<Cart>) httpSession.getAttribute("cart");
		  
			  HoaDon hoaDon = new HoaDon();
			  hoaDon.setTenkhachhang(tenkhachhang);
			  hoaDon.setSodt(sodt); hoaDon.setDiachigiaohang(diachigiaohang);
			  hoaDon.setHinhthucgiaohang(hinhthucgiaohang); hoaDon.setGhichu(ghichu);
			  
			  int idOrder = hoaDonService.addOrder(hoaDon);
			  if (idOrder > 0) { 
				  
				  Set<ChiTietHoaDon> listDetailOrder = new HashSet<ChiTietHoaDon>();
				  
				  for (Cart cart : listCart) {
				  
					  ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					  chiTietHoaDonId.setMachitietsanpham(cart.getIdDetailProduct());
					  chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());
					  
					  ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					  chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					  chiTietHoaDon.setGiatien(cart.getPrice());
					  chiTietHoaDon.setSoluong(cart.getQuantity());
					  chiTietHoaDonService.addDetailOrder(chiTietHoaDon);
				  
				  }
				  return "accept";
			  
			  } else { 
				  System.out.println("Thêm Thất Bại"); 
			  }
		  
		  
		  }
		 

		return "giohang";
	}
}
