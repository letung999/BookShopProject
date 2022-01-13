$(document).ready(
	function() {
		$("#cot1").click(function() {
			var line = $("#cot1").attr("data-test");
			alert(line);
		});
		
		var idProduct = 0;


		$("#btnDangNhap").click(function() {
			var email = $("#email").val();
			var password = $("#password").val();
			$.ajax({

				url: "/book-shop/api/checkInformationLogin",
				type: "GET",
				data: {
					email: email,
					password: password
				},
				success: function(value) {
					if (value == "true") {
						linkWebNow = window.location.href
						linkWeb = linkWebNow.replace("dangnhap/", "")
						window.location = linkWeb;
					}
					else {
						$("#ketqua").text("Login Fail!");
					}

				}
			})

		});

		$("#login").click(function() {
			$(this).addClass("actived");
			$("#signUp").removeClass("actived");
			$(".container-login-form").show();
			$(".container-signup").css("display", "none");
		});

		$("#signUp").click(function() {
			$(this).addClass("actived");
			$("#login").removeClass("actived");
			$(".container-login-form").css("display", "none");
			$(".container-signup").show();
		});

		$(".btn-cart").click(function() {
			var idDetailProduct = $(this).attr("data-idDetail")
			var idCategory = $(this).closest("tr").find(".category").attr("data-idCategory");
			var nameCategory = $(this).closest("tr").find(".category").text();
			var idColor = $(this).closest("tr").find(".color").attr("data-idColor");
			var nameColor = $(this).closest("tr").find(".color").text();
			var idProduct = $("#name-book").attr("data-idProduct");
			var nameProduct = $("#name-book").text();
			var priceProduct = $("#price-book").attr("data-price");
			var quantity = $(this).closest("tr").find(".quantity").text();
			//alert(idProduct + nameProduct + "-" + priceProduct + "-" + nameColor + "-" + quantity);
			alert("Đã Thêm Vào Giỏ Hàng");
			$.ajax({

				url: "/book-shop/api/addCart",
				type: "GET",
				data: {
					idCategory: idCategory,
					idProduct: idProduct,
					idColor: idColor,
					nameProduct: nameProduct,
					price: priceProduct,
					nameColor: nameColor,
					nameCategory: nameCategory,
					quantity: quantity,
					idDetailProduct: idDetailProduct

				},
				success: function(value) {
					$("#cart-choose").find("span").addClass("cart-quantity");
					$("#cart-choose").find("span").html("<span>" + value + "</span>");
				}
			})/*.done(function() {
				$.ajax({

					url: "/book-shop/api/getQuantityCart",
					type: "GET",
					success: function(value) {
						$("#cart-choose").find("span").addClass("cart-quantity");
						$("#cart-choose").find("span").html("<span>" + value +"</span>");
					}
				})
			});*/
		});


		parseFloatPrice();
		setTotalPrice();

		function parseFloatPrice() {

			$(".price").each(function() {
				var price = $(this).text();
				var totalPrice = parseFloat(price) * 1000;
				$(this).html(totalPrice);
			});

		}

		function setTotalPrice() {
			var totalPriceProduct = 0;
			$(".price").each(function() {
				var price = $(this).attr("data-value");
				var quantity = $(this).closest("tr").find(".numberOfProduct").val();
				var tmp = parseFloat(price) * quantity * 1000;
				totalPriceProduct = totalPriceProduct + tmp;

				$(this).closest("tr").find(".price").html(tmp);

				$("#total").html(totalPriceProduct + "VND");
			});
		}




		$(".numberOfProduct").change(function() {
			var quantity = $(this).val();
			/*var price = $(this).closest("tr").find(".price").attr("data-value");*/
			/*var totalPrice = quantity * parseFloat(price) * 1000;
			$(this).closest("tr").find(".price").html(totalPrice);*/
			setTotalPrice();

			var idCategory = $(this).closest("tr").find(".category").attr("data-idCategory");
			var idColor = $(this).closest("tr").find(".color").attr("data-idColor");
			var idProduct = $(this).closest("tr").find(".idProduct").attr("data-idProduct");

			$.ajax({

				url: "/book-shop/api/updateCart",
				type: "GET",
				data: {
					idCategory: idCategory,
					idProduct: idProduct,
					idColor: idColor,
					quantity: quantity
				},
				success: function(value) {
				}
			})
		});

		$(".btn-delete-cart").click(function() {
			var occur = $(this);
			var idCategory = $(this).closest("tr").find(".category").attr("data-idCategory");
			var idColor = $(this).closest("tr").find(".color").attr("data-idColor");
			var idProduct = $(this).closest("tr").find(".idProduct").attr("data-idProduct");

			$.ajax({

				url: "/book-shop/api/deleteCart",
				type: "GET",
				data: {
					idCategory: idCategory,
					idProduct: idProduct,
					idColor: idColor
				},
				success: function(value) {
					occur.closest("tr").remove();
					setTotalPrice();
				}
			})
		});

		$("body").on("click", ".paging-item", function() {
			$(".paging-item").removeClass("active");
			$(this).addClass("active");
			var numberPage = $(this).text();
			var startProduct = (numberPage - 1) * 5;

			$.ajax({

				url: "/book-shop/api/getListProductLimit",
				type: "GET",
				data: {
					startProduct: startProduct
				},
				success: function(value) {
					var tbodyProduct = $("#table-product").find("tbody")
					tbodyProduct.empty();
					tbodyProduct.append(value)
				}
			})
		});


		$("#check-all").change(function() {
			if (this.checked) {
				$("#table-product input").each(function() {
					$(this).attr("checked", true);
				})

			}
			else {
				$("#table-product input").each(function() {
					$(this).attr("checked", false);
				})
			}
		});

		$("#delete-product").click(function() {
			$("#table-product > tbody input:checked").each(function() {
				var idProduct = ($(this).val());
				var This = $(this);
				This.closest("tr").remove();
				$.ajax({

					url: "/book-shop/api/deleteProduct",
					type: "GET",
					data: {
						idProduct: idProduct
					},
					success: function(value) {
						This.closest("tr").remove();
					}
				})
			})
		});
		var files = [];
		var nameFilePhoto = "";
		$("#picture").change(function() {
			files = event.target.files;
			nameFilePhoto = files[0].name;
			forms = new FormData();
			forms.append("file", files[0]);

			$.ajax({

				url: "/book-shop/api/uploadFile",
				type: "POST",
				data: forms,
				contentType: false,
				processData: false,
				enctype: "multipart/form-data",
				success: function(value) {

				}
			})
		});

		$("body").on("click", ".btn-detail", function() {
			$(this).remove();// xoa nút đi
			var detailClone = $("#detail-product").clone();
			$("#container-detail-product").append(detailClone);
			detailClone.removeAttr("id");
		});

		$("#btnAddProduct").click(function(event) {
			event.preventDefault();
			var formData = $("#form-product").serializeArray();
			json = {};
			arrayDetailProduct = [];


			$.each(formData, function(i, field) {
				json[field.name] = field.value;
			});

			$("#container-detail-product >.detail-product").each(function() {

				objectDetail = {};
				/*var category = $(this).find('select[name="categoryOption"]').val();*/
				var category = $(this).find("#categoryOption").val();
				var colorProduct = $(this).find("#colorPicture").val();
				var quantity = $(this).find("#quantity").val()
				/*console.log(category + "-" + colorProduct + "-" + quantity);*/
				objectDetail["category"] = category;
				objectDetail["colorProduct"] = colorProduct;
				objectDetail["quantity"] = quantity;

				arrayDetailProduct.push(objectDetail);


			})
			json["chitietsanpham"] = arrayDetailProduct;
			json["pictureProduct"] = nameFilePhoto;

			console.log(json);
			$.ajax({

				url: "/book-shop/api/addProduct",
				type: "POST",
				data: {
					dataJson: JSON.stringify(json)
				},
				success: function(value) {

				}
			})
		});

		$("#btnUpdateProduct").click(function(event) {
			event.preventDefault();
			var formData = $("#form-product").serializeArray();
			json = {};
			arrayDetailProduct = [];


			$.each(formData, function(i, field) {
				json[field.name] = field.value;
			});

			$("#container-detail-product >.detail-product").each(function() {

				objectDetail = {};
				/*var category = $(this).find('select[name="categoryOption"]').val();*/
				var category = $(this).find("#categoryOption").val();
				var colorProduct = $(this).find("#colorPicture").val();
				var quantity = $(this).find("#quantity").val()
				/*console.log(category + "-" + colorProduct + "-" + quantity);*/
				objectDetail["category"] = category;
				objectDetail["colorProduct"] = colorProduct;
				objectDetail["quantity"] = quantity;

				arrayDetailProduct.push(objectDetail);


			})
			json["idProduct"] = idProduct;
			json["chitietsanpham"] = arrayDetailProduct;
			json["pictureProduct"] = nameFilePhoto;

			console.log(json);
			$.ajax({

				url: "/book-shop/api/updateProduct",
				type: "POST",
				data: {
					dataJson: JSON.stringify(json)
				},
				success: function(value) {

				}
			})
		});

		$("body").on("click", ".updateProduct", function() {
			idProduct = $(this).attr("data-id");
			$("#btnUpdateProduct").removeClass("hiden");
			$("#btnExit").removeClass("hiden");
			$("#btnAddProduct").addClass("hiden");

			$.ajax({

				url: "/book-shop/api/getListProduct",
				type: "POST",
				data: {
					idProduct: idProduct,
				},
				success: function(value) {
					//console.log(value);
					$("#name-product").val(value.tensanpham);
					$("#price").val(value.giatien);
					$("#comment").val(value.mota);
					$("#category").val(value.danhmucsanpham.madanhmuc);
					$("#container-detail-product").empty();

					var count = value.listChiTietSanPham.length;
					for (i = 0; i < count; ++i) {
						var detailClone = $("#detail-product").clone().removeAttr("id");

						if (i < count - 1) {
							detailClone.find(".btn-detail").remove();
						}

						detailClone.find("#colorPicture").val(value.listChiTietSanPham[i].mausanpham.mamau);
						detailClone.find("#categoryOption").val(value.listChiTietSanPham[i].theloai.matheloai);
						detailClone.find("#quantity").val(value.listChiTietSanPham[i].soluong);
						$("#container-detail-product").append(detailClone);
					}


				}
			})
		})


	}

)