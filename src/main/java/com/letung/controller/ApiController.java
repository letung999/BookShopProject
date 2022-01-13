package com.letung.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letung.entity.Cart;
import com.letung.entity.ChiTietSanPham;
import com.letung.entity.DanhMucSanPham;
import com.letung.entity.JsonSanPham;
import com.letung.entity.MauSanPham;
import com.letung.entity.SanPham;
import com.letung.entity.TheLoai;
import com.letung.service.NhanVienService;
import com.letung.service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "user", "cart" })
public class ApiController {

	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	SanPhamService sanPhamService;

	List<Cart> carts = new ArrayList<Cart>();

	@GetMapping("checkInformationLogin")
	@ResponseBody
	public String checkInformationLogin(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {

		boolean check = nhanVienService.checkInformationLogin(email, password);
		modelMap.addAttribute("user", email);

		return "" + check;

	}

	@GetMapping("addCart")
	@ResponseBody
	public String addCart(@RequestParam int idDetailProduct, @RequestParam int idProduct, @RequestParam int idCategory,
			@RequestParam int idColor, @RequestParam String nameProduct, @RequestParam String price,
			@RequestParam String nameColor, @RequestParam String nameCategory, @RequestParam int quantity,
			HttpSession httpSession) {

		if (httpSession.getAttribute("cart") == null) {
			List<Cart> carts = new ArrayList<Cart>();
			Cart cart = new Cart(idDetailProduct, idProduct, idCategory, idColor, nameProduct, price, nameColor,
					nameCategory, 1);
			carts.add(cart);
			httpSession.setAttribute("cart", carts);
			return carts.size() + "";

		} else {

			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = checkExitProductInCart(idProduct, idCategory, idColor, httpSession);

			if (index == -1) {
				Cart cart = new Cart(idDetailProduct, idProduct, idCategory, idColor, nameProduct, price, nameColor,
						nameCategory, 1);
				carts.add(cart);

			} else {
				int quantityUpdate = carts.get(index).getQuantity() + 1;
				carts.get(index).setQuantity(quantityUpdate);
			}
			return carts.size() + "";
		}

	}

	private int checkExitProductInCart(int idProduct, int idCategory, int idColor, HttpSession httpSession) {

		List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
		for (int i = 0; i < carts.size(); ++i) {
			if (carts.get(i).getIdCategory() == idCategory && carts.get(i).getIdProduct() == idProduct
					&& carts.get(i).getIdColor() == idColor) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * @GetMapping("getQuantityCart")
	 * 
	 * @ResponseBody public String getQuantityCart(HttpSession httpSession) {
	 * if(httpSession.getAttribute("cart") != null) { List<Cart> listCart =
	 * (List<Cart>) httpSession.getAttribute("cart"); return listCart.size() +"";
	 * 
	 * } return ""; }
	 */
	@GetMapping("updateCart")
	@ResponseBody
	public void updateCart(HttpSession httpSession, @RequestParam int quantity, @RequestParam int idProduct,
			@RequestParam int idCategory, @RequestParam int idColor) {
		if (httpSession.getAttribute("cart") != null) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = checkExitProductInCart(idProduct, idCategory, idColor, httpSession);
			// int quantityUpdate = carts.get(index).getQuantity() + 1;
			carts.get(index).setQuantity(quantity);
		}

	}

	@GetMapping("deleteCart")
	@ResponseBody
	public void deleteCart(HttpSession httpSession, @RequestParam int idProduct, @RequestParam int idCategory,
			@RequestParam int idColor) {
		if (httpSession.getAttribute("cart") != null) {
			List<Cart> carts = (List<Cart>) httpSession.getAttribute("cart");
			int index = checkExitProductInCart(idProduct, idCategory, idColor, httpSession);
			carts.remove(index);

		}

	}

	@GetMapping(path = "getListProductLimit", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String getListProductLimit(@RequestParam int startProduct) {

		String html = "";
		List<SanPham> listProduct = sanPhamService.getListProductLimit(startProduct);
		for (SanPham product : listProduct) {
			html += "<tr class='bg-success' style='color: white;'>";
			html += "<td ><div class='checkbox'> <label><input class='checkbox-product' style='width: 25px; height: 25px;' type='checkbox' value='"
					+ product.getMasanpham() + "'></label></div></td>";
			html += "<td class='idProduct' data-idProduct =" + product.getMasanpham() + "'>" + product.getTensanpham()
					+ "</td>";
			html += "<td class='price' data-value =" + product.getGiatien() + "'>" + product.getGiatien() + "</td>";
			html += "<td class='updateProduct btn btn-warning' data-id =" + product.getMasanpham() + ">Sửa</td>";
			html += "</tr>";
		}

		return html;

	}

	@GetMapping("deleteProduct")
	@ResponseBody
	public String deleteProductById(@RequestParam int idProduct) {
		sanPhamService.deleteProductById(idProduct);
		return "";
	}

	@Autowired
	ServletContext context;

	@PostMapping("uploadFile")
	@ResponseBody
	public String upLoadFile(MultipartHttpServletRequest request) {
		String pathSaveFile = context.getRealPath("/resources/Image/namebook/");
		Iterator<String> listFileName = request.getFileNames();
		MultipartFile multipartFile = request.getFile(listFileName.next());
		File file = new File(pathSaveFile + multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.print(pathSaveFile);
		return "";
	}

	@PostMapping("addProduct")
	@ResponseBody
	public void addProduct(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			SanPham product = new SanPham();
			
			String nameProduct = jsonObject.get("name-product").asText();
			
			String quantity = jsonObject.get("price").asText();
			
			String description = jsonObject.get("description").asText();
			
			String pictureProduct = jsonObject.get("pictureProduct").asText();
			
			
			
			DanhMucSanPham category = new DanhMucSanPham();
			category.setMadanhmuc(jsonObject.get("category").asInt());
			
			
			JsonNode jsonDetail = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listDetailProduct = new HashSet<ChiTietSanPham>();
			
			for (JsonNode objectDetail : jsonDetail) {
				ChiTietSanPham detailProduct = new ChiTietSanPham();
				
				MauSanPham colorProduct = new MauSanPham();
				colorProduct.setMamau(objectDetail.get("colorProduct").asInt());
				
				TheLoai categorys = new TheLoai();
				categorys.setMatheloai(objectDetail.get("category").asInt());
				
				
				
				detailProduct.setMausanpham(colorProduct);
				detailProduct.setTheloai(categorys);
				detailProduct.setSoluong(objectDetail.get("quantity").asInt());
				
				listDetailProduct.add(detailProduct);
			}
			
			product.setTensanpham(nameProduct);
			product.setGiatien(quantity);
			product.setDanhmucsanpham(category);
			product.setMota(description);
			product.setHinhsanpham(pictureProduct);
			product.setListChiTietSanPham(listDetailProduct);
			
			
			sanPhamService.addProduct(product);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 
		System.out.print(dataJson);
	}
	
	@PostMapping( path = "getListProduct", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public JsonSanPham getListProductByID(@RequestParam int idProduct){
		JsonSanPham jsonSanPham = new JsonSanPham();
		SanPham product = sanPhamService.getListProductDetailById(idProduct);
		
		jsonSanPham.setMasanpham(product.getMasanpham());
		jsonSanPham.setTensanpham(product.getTensanpham());
		jsonSanPham.setHinhsanpham(product.getHinhsanpham());
		jsonSanPham.setMota(product.getMota());
		jsonSanPham.setGiatien(product.getGiatien());
		
		DanhMucSanPham danhMucSanPham = new DanhMucSanPham();// không lấy list danh mục sản phẩm vì nó sẽ mắc proxy
		danhMucSanPham.setMadanhmuc(product.getDanhmucsanpham().getMadanhmuc());
		danhMucSanPham.setTendanhmuc(product.getDanhmucsanpham().getTendanhmuc());
		jsonSanPham.setDanhmucsanpham(danhMucSanPham);
		
		Set<ChiTietSanPham> listDetailProduct = new HashSet<ChiTietSanPham>();
		
		for (ChiTietSanPham value  : product.getListChiTietSanPham()) {
			
			ChiTietSanPham detailProduct = new ChiTietSanPham();
			detailProduct.setMachitietsanpham(value.getMachitietsanpham());
			
			MauSanPham colorProduct = new MauSanPham();
			colorProduct.setMamau(value.getMausanpham().getMamau());
			colorProduct.setTenmau(value.getMausanpham().getTenmau());
			detailProduct.setMausanpham(colorProduct);
			
			
			TheLoai category = new TheLoai();
			category.setMatheloai(value.getTheloai().getMatheloai());
			category.setTheloai(value.getTheloai().getTheloai());
			detailProduct.setTheloai(category);
			
			
			detailProduct.setSoluong(value.getSoluong());
			
			listDetailProduct.add(detailProduct);
			
		}
		jsonSanPham.setListChiTietSanPham(listDetailProduct);
		return jsonSanPham;
	}
	
	
	@PostMapping("updateProduct")
	@ResponseBody
	public void updateProduct(@RequestParam String dataJson) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonObject;
		try {
			jsonObject = objectMapper.readTree(dataJson);
			SanPham product = new SanPham();
			
			String nameProduct = jsonObject.get("name-product").asText();
			
			String quantity = jsonObject.get("price").asText();
			
			String description = jsonObject.get("description").asText();
			
			String pictureProduct = jsonObject.get("pictureProduct").asText();
			
			int idProduct = jsonObject.get("idProduct").asInt();
			
			
			
			DanhMucSanPham category = new DanhMucSanPham();
			category.setMadanhmuc(jsonObject.get("category").asInt());
			
			
			JsonNode jsonDetail = jsonObject.get("chitietsanpham");
			Set<ChiTietSanPham> listDetailProduct = new HashSet<ChiTietSanPham>();
			
			for (JsonNode objectDetail : jsonDetail) {
				ChiTietSanPham detailProduct = new ChiTietSanPham();
				
				MauSanPham colorProduct = new MauSanPham();
				colorProduct.setMamau(objectDetail.get("colorProduct").asInt());
				
				TheLoai categorys = new TheLoai();
				categorys.setMatheloai(objectDetail.get("category").asInt());
				
				
				
				detailProduct.setMausanpham(colorProduct);
				detailProduct.setTheloai(categorys);
				detailProduct.setSoluong(objectDetail.get("quantity").asInt());
				
				listDetailProduct.add(detailProduct);
			}
			
			product.setTensanpham(nameProduct);
			product.setGiatien(quantity);
			product.setDanhmucsanpham(category);
			product.setMota(description);
			product.setHinhsanpham(pictureProduct);
			product.setListChiTietSanPham(listDetailProduct);
			product.setMasanpham(idProduct);
			
			
			sanPhamService.upDateProduct(product);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 
		System.out.print(dataJson);
	}
	

}
