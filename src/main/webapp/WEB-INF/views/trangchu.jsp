<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>BookShop</title>
<link rel="stylesheet" href="resources/Styles/styles.css">
</head>
<body>
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-expand-lg  none_nav">
			<a class="navbar-brand" href="bookshop/">
				<h2>BookShop</h2>
			</a>
				
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto navbar-center">
					<li class="nav-item active"><a class="nav-link" href='<c:url value ="/"/>'>TRANG CHỦ <span class="sr-only">(current)</span></a></li>
					
					<li class="nav-item dropdown ">
						<a
							class="nav-link dropdown-toggle" href="" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							 SẢN PHẨM 
						</a>
						
						<div class="dropdown-menu open" aria-labelledby="navbarDropdown">
							<c:forEach var="category" items="${listCategory }">
								<a class="dropdown-item" href='<c:url value ="/danhmuc/${category.getMadanhmuc() }/${category.getTendanhmuc()}"/>'>${category.getTendanhmuc()}</a>
								<div class="dropdown-divider"></div>
							</c:forEach>
				
						<!-- 	<a class="dropdown-item" href="#">Action</a>
							
							<div class="dropdown-divider"></div>
							
							<a class="dropdown-item" href="#">Another action</a>
							
							<div class="dropdown-divider"></div>
							
							<a class="dropdown-item" href="#">Something else here</a> -->
						</div>
					</li>
					
					<li class="nav-item"><a class="nav-link" href="#">DỊCH VỤ</a></li>
					
					<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
					

				</ul>
				<ul class="nav navbar-nav navbar-ringht">
					<li>
						<c:choose>
							<c:when test="${firstWord != null }">
								<a class="circle_avatar" href="dangnhap/"><span>${firstWord}</span></a>
							</c:when>
	
							<c:otherwise>
								<a class="nav-link" href="dangnhap/">ĐĂNG NHẬP</a>
							</c:otherwise>
						</c:choose>
					</li>
				
					<li><a href='<c:url value ="/giohang/"/>'><img id="giohang"src='<c:url value="/resources/Image/shopping-cart.png" />' /></a></li>
							
				</ul>
			</div>
		</nav>
		
		
		
		
		<div class ="event-header containner wow bounceInUp">
		
			<div id="animation-event">
				<section>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		            <span></span>
		        </section>
			</div>
		
			<span>Ngày 18/12 20/12/2021</span><br>
			<span style="font-size: 50px;">Mua Một Tặng 1</span><br>
			<button>Xem Ngay</button>
		</div>
	</div>

	<div id="info" class="container">
		<div class="row">
		
			<div class="col-12 col-sm-4 col-md-4 wow fadeInLeft" data-wow-duration="0.5s">
				<img src='<c:url value = "/resources/Image/medal.png"/>'/><br>
				<span style="font-size: 32px; font-family: Roboto;">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết sẽ đem đến cho bạn những trang sách chất lượng nhất</span>
		
		 	</div>
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown"data-wow-duration="0.5s" data-wow-delay="1s">
				<img src='<c:url value = "/resources/Image/saving-money.png"/>'/><br>
				<span style="font-size: 32px; font-family: Roboto;">TIẾT KIỆM</span><br>
				<span>Chúng tôi cam kết bán giá hợp lý nhất giúp bạn tiết kiệm được một khoản lớn mà không nơi nào có được</span>
		
		 	</div>
			<div class="col-12 col-sm-4 col-md-4 wow fadeInUp"data-wow-duration="0.5s" data-wow-delay="1.5s">
				<img src='<c:url value = "/resources/Image/express-delivery.png"/>'/><br>
				<span style="font-size: 32px; font-family: Roboto;">GIAO HÀNG</span><br>
				<span>Chúng tôi cam kết sẽ giao đến bạn những cuốn sách với thời gian nhanh chất và an toàn nhất</span>
			</div>
		</div>
	</div>
	
	<div id="title-product" class="container-fluid">
		<span>NHỮNG CUỐN SÁCH HAY MỚI CẬP NHẬP</span>
		<div class="row product">
			<c:forEach var="product" items="${ listProduct}">
				<div class="col-12 col-sm-6 col-md-3 card "data-wow-duration="2s" style="width: 18rem;">
					<a href="chitiet/${product.getMasanpham()}" class="product-img">
						<img class="card-img-top" src='<c:url value = "/resources/Image/namebook/${product.getHinhsanpham()}"/>' alt="Card image cap">
					</a>
					  <div class="card-body">
						    <h5 class="card-title">${product.getTensanpham()}</h5>
						    <p class="card-text">${product.getGiatien()}</p>
						    
					  </div>
				</div>
			</c:forEach>
		</div>
			
	</div>
	
	<div id ="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<div class="description-footer">
					<span>
						BookShop là một của hàng sách cổ điển, luôn cam kết những trang sách chất lượng với giá
						cả hợp lý, đặc biệt là cửa hàng luôn có những cuốn sách gắn liền với dòng thời gian của tuổi thơ
					</span>
				</div>
				
			
			</div>
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer" >LIÊN HỆ</span></p>
				<div class="description-footer">
					<span>80/9A Lã Xuân Oai Phường Tăng Nhơn Phú A Tp Thủ Đức</span>
					<span>bookshop@gmail.com</span><br>
					<span>0338257409</span>
				</div>
				
			</div>
			<div class="col-sm-4  col-md-4 wow tada">
				<p><span class="title-footer">GÓP Ý</span><p>
				<div class="description-footer">
					<form action="" method="post">
						<input name="tenNhanVien" class="meterial-text-input" style="margin-bottom: 5px;" type ="text" placeholder="Email"/>
						<textarea name="tuoi" rows="4" cols="50" placeholder="Nội Dung"></textarea>
						<button class="meterial-button-primary">ĐỒNG Ý</button>
					</form>
				</div>
				

			</div>
		</div>
		
	</div>
	<jsp:include page="footer.jsp" />
</body>

</html>