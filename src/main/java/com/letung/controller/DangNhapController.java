package com.letung.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.letung.entity.NhanVien;
import com.letung.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {

	@Autowired
	NhanVienService nhanVienService;

	@GetMapping
	public String Default( /* @SessionAttribute("user") String user */) {
		return "dangnhap";
	}

	@PostMapping
	public String Register(@RequestParam String email, @RequestParam String password,
			@RequestParam String repplyPassword, ModelMap modelMap) {
		boolean userExit = nhanVienService.selectUserExit(email);

		if (!userExit) {
			boolean checkEmail = validate(email);
			if (checkEmail) {
				if (password.equals(repplyPassword)) {
					NhanVien nhanVien = new NhanVien();
					nhanVien.setEmail(email);
					nhanVien.setTendangnhap(email);
					nhanVien.setMatkhau(password);

					boolean checkAddEmployee = nhanVienService.addEmployee(nhanVien);
					if (checkAddEmployee) {
						modelMap.addAttribute("checkInformationLogin", "Tạo Tài Khoản Thành Công");
					} else {
						modelMap.addAttribute("checkInformationLogin", "Tạo Tài Khoản Thất Bại!");

					}
				} else {
					modelMap.addAttribute("checkInformationLogin", "Mật Khẩu Không Trùng Khớp!");
				}
			}

			else {
				modelMap.addAttribute("checkInformationLogin", "Vui Lòng Nhập Đúng Định Dạng Email!");

			}
		} else {
			modelMap.addAttribute("checkInformationLogin", "Người Dùng Đã Tồn Tại!");
		}

		return "dangnhap";
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
