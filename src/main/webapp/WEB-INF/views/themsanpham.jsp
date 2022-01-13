
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Shoppy an Admin Panel Category Flat Bootstrap Responsive
	Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link rel="stylesheet" href='<c:url value ="/resources/boostrap/css/bootstrap.min.css"/>'/>
<!-- Custom Theme files -->
<link rel="stylesheet" href='<c:url value ="/resources/css/style.css"/>' />
<!--js-->

<script src='<c:url value ="/resources/JS/jquery-3.3.1.min.js"/>'></script>
<script src='<c:url value ="/resources/JS/custom.js"/>'></script>

<!--icons-css-->
<link rel="stylesheet"
	href='<c:url value ="/resources/css/font-awesome.css"/>' />
<link rel="stylesheet" href="resources/Styles/styles.css">
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css'>
<!--static chart-->
<script src='<c:url value ="/resources/JS/Chart.min.js"/>'></script>
<!--//charts-->
<!-- geo chart -->
<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
			|| document
					.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script src='<c:url value ="/resources/JS/chartinator.js"/>'></script>
<script type="text/javascript">
	jQuery(function($) {

		var chart3 = $('#geoChart').chartinator(
				{
					tableSel : '.geoChart',

					columns : [ {
						role : 'tooltip',
						type : 'string'
					} ],

					colIndexes : [ 2 ],

					rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
							[ 'France - 2015' ], [ 'Italy - 2015' ],
							[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
							[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
							[ 'Russia - 2015' ], [ 'Spain - 2015' ],
							[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],

					ignoreCol : [ 2 ],

					chartType : 'GeoChart',

					chartAspectRatio : 1.5,

					chartZoom : 1.75,

					chartOffset : [ -12, 0 ],

					chartOptions : {

						width : null,

						backgroundColor : '#fff',

						datalessRegionColor : '#F5F5F5',

						region : 'world',

						resolution : 'countries',

						legend : 'none',

						colorAxis : {

							colors : [ '#679CCA', '#337AB7' ]
						},
						tooltip : {

							trigger : 'focus',

							isHtml : true
						}
					}

				});
	});
</script>
<!--geo chart-->

<!--skycons-icons-->
<script src='<c:url value ="/resources/JS/skycons.js"/>'></script>
<!--//skycons-icons-->
</head>
<body>
	<div class="page-container">
		<div class="left-content container">
			<div class="row">
				
				<div class="col-md-5 col-sm-12 form-group">
					<form id="form-product" action="">
						<label for="name-product">Tên Sản Phẩm</label><br>
						<input type="text" id="name-product" name="name-product" placeholder="Nhập Vào Tên Sản Phẩm" class="form-control"><br>
						
						<label for="price">Giá Tiền</label><br>
						<input type="text" id="price" name="price" placeholder="Giá Tiền" class="form-control"><br>
						
						<label for="category">Danh Mục Sản Phẩm:</label>
						<select class="form-control" id="category" name="category">
						  	<c:forEach var="category" items="${listCategory }">
						  		<option value="${category.getMadanhmuc()}">${category.getTendanhmuc()}</option>
							</c:forEach>
		
						</select><br>
						
						<label for="comment">Mô Tả</label>
	  					<textarea class="form-control" name="description" rows="5" id="comment" placeholder="Nhập Vào Mô Tả"></textarea><br>
	  					
	  					<label for="picture">Hình Ảnh</label><br>
						<input type="file" name="picture" id="picture" placeholder="Nhập Vào Tên Sản Phẩm" class="form-control"><br>
					
					</form>	
  					
  					<div id="container-detail-product">
  						<div  class="detail-product">
	  						<h3>Chi Tiết Sản Phẩm</h3><br>
	  					
		  					<label for="categoryOption">Thể Loại</label>
		  					<select class="form-control" id="categoryOption" name="categoryOption">
							  	<c:forEach var="category" items="${listCategoryOption }">
							  		<option value="${category.getMatheloai()}">${category.getTheloai()}</option>
								</c:forEach>
			
							</select><br>
							
							<label for="colorPicture">Màu Sản Phẩm</label>
							<select class="form-control" id="colorPicture" name="colorPicture">
							  	<c:forEach var="color" items="${listColorProductOption }">
							  		<option value="${color.getMamau()}">${color.getTenmau()}</option>
								</c:forEach>
			
							</select><br>
							
							<label for="quantity">Số Lượng</label><br>
							<input min="1" value="1" type="number" name="quantity" id="quantity" placeholder="Nhập Vào Số Lượng" class="form-control"><br>
							<button type="button" class="btn btn-info btn-detail" style="float: right;">Thêm Chi Tiết</button><br>
							
  					
  						</div>
  						
  					</div>
  					
  					<button id="btnAddProduct" type="button" class="btn btn-info">Thêm Sản Phẩm</button><br>
  					<button style="margin-bottom: 10px;" id="btnUpdateProduct" type="button" class="btn btn-success hiden">Cập Nhập</button><br>
  					<button id="btnExit" type="button" class="btn btn-danger hiden">Thoát</button><br>
  					
  					<div id="detail-product" class="detail-product">
  						<h3>Chi Tiết Sản Phẩm</h3><br>
  					
	  					<label for="categoryOption">Thể Loại</label>
	  					<select class="form-control" id="categoryOption" name="categoryOption">
						  	<c:forEach var="category" items="${listCategoryOption }">
						  		<option value="${category.getMatheloai()}">${category.getTheloai()}</option>
							</c:forEach>
		
						</select><br>
						
						<label for="colorPicture">Màu Sản Phẩm</label>
						<select class="form-control" id="colorPicture" name="colorPicture">
						  	<c:forEach var="color" items="${listColorProductOption }">
						  		<option value="${color.getMamau()}">${color.getTenmau()}</option>
							</c:forEach>
		
						</select><br>
						
						<label for="quantity">Số Lượng</label><br>
						<input min="1" value="1" type="number" name="quantity" id="quantity" placeholder="Nhập Vào Số Lượng" class="form-control"><br>
						<button type="button" class="btn btn-info btn-detail" style="float: right;">Thêm Chi Tiết</button><br>
  					
  					</div>
  					
  					
				</div>
				<div class="col-md-7 col-sm-12">
						<div style="margin-bottom: 30px">
						<h3 style="padding-bottom: 10px;">Sản Phẩm</h3>
						<button id="delete-product" type="button" class="btn btn-danger">Xóa</button>
					
					</div>
					<table id="table-product" class="table table-sm">
					  <thead>
					    <tr class="bg-warning">
					      <th scope="col">
					      	<div class="checkbox">
							  <label><input id="check-all" style="width: 25px; height: 25px;" type="checkbox" value=""></label>
							</div>
					      </th>
					      <th scope="col">Tên Sản Phẩm</th>
					      <th scope="col">Giá Tiền</th>
					       <th scope="col">Cập Nhập</th>
					
					    </tr>
					  </thead>
					  <tbody>
						   <c:forEach var="product" items="${listProduct}">
							<tr class="bg-success" style="color: white;">
								<td >
									<div class="checkbox">
									  <label><input class="checkbox-product" style="width: 25px; height: 25px;" type="checkbox" value="${product.getMasanpham()}"></label>
									</div>
								</td>
								<td class="idProduct" data-idProduct ="${product.getMasanpham()}">${product.getTensanpham()}</td>
								<td class="price" data-value ="${product.getGiatien()}">${product.getGiatien()}</td>
								<td class="btn btn-warning updateProduct" data-id ="${product.getMasanpham()}">Sửa</td>
								
							</tr>
							</c:forEach>
					  </tbody>
					</table>
					<ul class="pagination">
						<c:forEach var = "i" begin = "1" end = "${totalPage }">
							     <c:choose>
	         
							         <c:when test = "${i == 1 }">
							         	<li class="paging-item page-item active"><a class="page-link" href="#">${i }</a></li>
							       
							         </c:when>
							         
							         <c:otherwise>
							           <li class="paging-item page-item"><a class="page-link" href="#">${i }</a></li>
							         </c:otherwise>
							         
							     </c:choose>
				     	</c:forEach>
					</ul>
					
				</div>
				
					
			</div>
		</div>
		<!--slider menu-->
		<div class="sidebar-menu">
			<div class="logo">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</div>
			<div class="menu" style="background:#202121;">
				<ul id="menu">
					<li id="menu-home"><a href='<c:url value ="/dashboard"/>'><i
							class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
					<li><a href='<c:url value ="/themsanpham"/>'><i
							class="fa fa-product-hunt"></i><span>Product</span><span
							class="fa fa-angle-right" style="float: right"></span>
						</a>
						<ul>
							<li><a href="grids.html">Grids</a></li>
							<li><a href="portlet.html">Portlets</a></li>
					
						</ul>
					</li>
					<li id="menu-comunicacao"><a href="#"><i
							class="fa fa-book nav_icon"></i><span>Element</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-comunicacao-sub">
							<li id="menu-mensagens" style="width: 120px"><a
								href="buttons.html">Buttons</a></li>
							<li id="menu-arquivos"><a href="typography.html">Typography</a></li>
							<li id="menu-arquivos"><a href="icons.html">Icons</a></li>
						</ul>
					</li>
					<li><a href="maps.html"><i class="fa fa-map-marker"></i><span>Maps</span></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text"></i><span>Pages</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="login.html">Login</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>
						</ul></li>

					<li><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span></a></li>
					<li><a href="#"><i class="fa fa-envelope"></i><span>Mailbox</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="inbox.html">Inbox</a></li>
							<li id="menu-academico-boletim"><a
								href="inbox-details.html">Compose email</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-cog"></i><span>System</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="404.html">404</a></li>
							<li id="menu-academico-boletim"><a href="blank.html">Blank</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-shopping-cart"></i><span>E-Commerce</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="product.html">Product</a></li>
							<li id="menu-academico-boletim"><a href="price.html">Price</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<!--slide bar menu end here-->
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>
	<!--scrolling js-->
	<script src='<c:url value ="/resources/JS/jquery.nicescroll.js"/>'></script>
	<script src='<c:url value ="/resources/JS/scripts.js"/>'></script>
	<!--//scrolling js-->
	<script src='<c:url value ="/resources/JS/bootstrap.js"/>'></script>
	<!-- mother grid end here-->
</body>
</html>
