package com.hangjiang.ssm.po;

import java.io.Serializable;

public class Items implements Serializable{
	private String Name;
	private float Price;
	private String Detail;
	
	public Items(){
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}
	
}
