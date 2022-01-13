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
	<div  class="container-fluid">
		<nav class="navbar navbar-expand-lg  none_nav">
			<a class="navbar-brand" href="#">
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
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							 SẢN PHẨM 
						</a>
							
						<div class="dropdown-menu open" aria-labelledby="navbarDropdown">
							<c:forEach var="category" items="${listCategory }">
								<a class="dropdown-item" href='<c:url value ="/danhmuc/${category.getMadanhmuc() }/${category.getTendanhmuc()}"/>'>${category.getTendanhmuc()}</a>
								<div class="dropdown-divider"></div>
							</c:forEach>
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
								<a class="nav-link" href='<c:url value ="/dangnhap/"/>'>ĐĂNG NHẬP</a>
							</c:otherwise>
						</c:choose>
					</li>
				
					<li id="cart-choose"><a href="#"><img id="giohang"src='<c:url value="/resources/Image/shopping-cart.png" />' />
						<%-- <span id="cart-quantity">+${quantityProduct }</span></a> --%>
							 <c:if test="${quantityProduct > 0 }">
							 
							 	<span class="cart-quantity">${quantityProduct }</span>
					 			
					 		</c:if>
					 
							 <c:if test="${quantityProduct <= 0 || quantityProduct == null}">
							 	<span>${quantityProduct }</span>
							 </c:if>
						</a>
					</li>
							
				</ul>
			</div>
		</nav>
	</div>
	
	
	<div class="container-fluid" style="margin-top: 20px;">
	
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h3>Danh Sách Sản Phẩm Trong Giỏ Hàng</h3>
				<table class="table table-sm">
				  <thead>
				    <tr class="bg-warning">
				    	<th scope="col">Tên Sản Phẩm</th>
				      <th scope="col">Màu Trang Sách</th>
				      <th scope="col">Thể Loại</th>
				      <th scope="col">Số Lượng</th>
				      <th scope="col">Giá Tiền</th>
				      <th scope="col">Xóa Sản Phẩm</th>
				    </tr>
				  </thead>
				  <tbody>
					   <c:forEach var="cart" items="${listCart}">
						<tr data-value = "${cart.getIdDetailProduct() }" class="bg-success" style="color: white;">
							<td class="idProduct" data-idProduct ="${cart.getIdProduct()}">${cart.getNameProduct()}</td>
							<td class="color" data-idColor = "${cart.getIdColor()}">${cart.getNameColor()}</td>
							<td class="category" data-idCategory ="${cart.getIdCategory()}">${cart.getNameCategory()}</td>
							<td class="quantity"><input class="numberOfProduct" min = 1   style="width: 50px;" type="number" value="${cart.getQuantity()}"/></td>
							<td class="price" data-value ="${cart.getPrice()}">${cart.getPrice()}</td>
							<td><button class="btn-delete-cart btn btn-danger">Xóa Sản Phẩm</button></td>
							
						</tr>
						</c:forEach>
				  </tbody>
				</table>
				<h3>Tổng Tiền: <span id="total" style="color: red";></span></h3>
			</div>
			
			<div class="col-md-6 col-sm-12">
				<h3>Thông Tin Nhận Hàng</h3>
				
				<div class="form-group">
					<form action="" method="post">
						<label for="namePerson">Tên Người Mua</label>
						<input class="form-control" id="namePerson" name = "tenkhachhang"><br>
						
						<label for="phone">Điện Thoại Liên Lạc</label>
						<input class="form-control" id="phone" name="sodt"><br>
						
						<div class="radio">
						  	<label><input type="radio" name="hinhthucgiaohang" checked value="Giao Hàng Tận Nơi">Giao Hàng Tận Nơi</label>
						</div>
					
						<div class="radio">
						  	<label><input type="radio" name="hinhthucgiaohang" value="Nhận Trực Tiếp Tại Của Hàng">Nhận Trực Tiếp Tại Của Hàng</label>
						</div>
					
											
						<label for="address">Địa Chỉ Nhận Hàng</label>
						<input class="form-control" id="address" name="diachigiaohang"><br>
						
						<label for="note">Ghi Chú</label>
	    				<textarea class="form-control" id="note" rows="3" name="ghichu"></textarea><br>
	    				
	    				<input type="submit" class="btn btn-success" value="Mua Hàng"/>
					</form>
				</div>
			
			</div>
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