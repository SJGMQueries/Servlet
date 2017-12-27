package com.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_BOOK")
public class Order {
	@Id
	private int id;
	@Column(name = "Item")
	private String itemName;
	@Column(name = "type")
	private String itemCatagory;
	private double price;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCatagory() {
		return itemCatagory;
	}

	public void setItemCatagory(String itemCatagory) {
		this.itemCatagory = itemCatagory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "id=" + id + ", itemName=" + itemName + ", itemCatagory="
				+ itemCatagory + ", price=" + price + ", status=" + status
				+ "";
	}

}
