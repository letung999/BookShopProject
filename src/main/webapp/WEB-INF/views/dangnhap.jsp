<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
<jsp:include page="header.jsp" />
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
	
				<div id="header-top-left" class="header-login">
					<span id = "text-logo">Welcome</span><br/> 
					<span id = "hint-text-logo">Nơi Mang Đến Tri Thức Và Nuôi Dưỡng Tâm Hồn Cho Mọi Người</span>
						
				</div>

				<div class ="header-bottom-left" style="z-index: 1">
					<p>
						<img alt="icons8-oval-16" src='<c:url value = "/resources/Image/circle.png"/>' class="color-icon-oval">
						<span>Mang Đến Những Trang Sách Chất Lượng Nhất</span>
					</p>
					<p>
						<img alt="icons8-oval-16" src='<c:url value = "/resources/Image/circle.png"/>' class="color-icon-oval">
						<span>Nội Dung Chất Lượng Nhất</span>
					</p>
					<p>
						<img alt="icons8-oval-16" src='<c:url value = "/resources/Image/circle.png"/>' class="color-icon-oval">
						<span>Luôn Mong Muốn Bạn Có Một Tâm Hồn Bình Yên</span>
					</p>

				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span style="cursor: pointer;"  id="login">Đăng Nhập</span> / <span style="cursor: pointer;"id="signUp">Đăng Ký</span>
				
				</div>
				
				<div id="container-center-login-right">
					
					<div class="container-login-form" id="container-center-login-right">
						<input id="email" name="email"  class="meterial-text-input input-icon-email" type = "text" placeholder="Email"><br>
						<input id="password" name="matkhau"  class="meterial-text-input input-icon-password" type = "text" placeholder="Password"/> <br>
						<input id="btnDangNhap" class="meterial-button-primary" type="submit" value="Đăng Nhập">
					</div>
					
					<div class="container-signup" id ="container-center-login-right">
						<form action="" method="post">
							<input id="email" name="email"  class="meterial-text-input input-icon-email" type = "text" placeholder="Email"><br><p></p>
							<input id="password" name="password"  class="meterial-text-input input-icon-password" type = "password" placeholder="Password"/> <br><p></p>
							<input id="password" name="repplyPassword"  class="meterial-text-input input-icon-password" type = "password" placeholder="Repply Password"/> <br>
							<input id="btnDangNhap" class="meterial-button-primary" type="submit" value="Đăng Ký">
						</form>
					</div>	
					<span>${checkInformationLogin}</span>
					
					
					<span id="ketqua"></span>

						
				</div>
				
				<div id="social-icon">
					<img alt="" src='<c:url value = "/resources/Image/ic_facebook.png"/>' class="color-iconl">
					<img alt="" src='<c:url value = "/resources/Image/ic_google.png"/>' class="color-icon">
				
				</div>
				
				
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>