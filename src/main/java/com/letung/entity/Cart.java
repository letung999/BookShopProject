package com.letung.entity;

public class Cart {
	int idDetailProduct;
	int idProduct;
	int idCategory;
	int idColor;
	String nameProduct;
	String price;
	String nameColor;
	String nameCategory;
	int quantity;
	
	

	

	public Cart(int idDetailProduct, int idProduct, int idCategory, int idColor, String nameProduct, String price,
			String nameColor, String nameCategory, int quantity) {
		super();
		this.idDetailProduct = idDetailProduct;
		this.idProduct = idProduct;
		this.idCategory = idCategory;
		this.idColor = idColor;
		this.nameProduct = nameProduct;
		this.price = price;
		this.nameColor = nameColor;
		this.nameCategory = nameCategory;
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Cart [idProduct=" + idProduct + ", idCategory=" + idCategory + ", idColor=" + idColor + ", nameProduct="
				+ nameProduct + ", price=" + price + ", nameColor=" + nameColor + ", nameCategory=" + nameCategory
				+ ", quantity=" + quantity + ", getIdProduct()=" + getIdProduct() + ", getIdCategory()="
				+ getIdCategory() + ", getIdColor()=" + getIdColor() + ", getNameProduct()=" + getNameProduct()
				+ ", getPrice()=" + getPrice() + ", getNameCategory()=" + getNameCategory() + ", getQuantity()="
				+ getQuantity() + ", getNameColor()=" + getNameColor() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

	public int getIdDetailProduct() {
		return idDetailProduct;
	}

	public void setIdDetailProduct(int idDetailProduct) {
		this.idDetailProduct = idDetailProduct;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNameColor() {
		return nameColor;
	}

	public void setNameColor(String nameColor) {
		this.nameColor = nameColor;
	}

}
