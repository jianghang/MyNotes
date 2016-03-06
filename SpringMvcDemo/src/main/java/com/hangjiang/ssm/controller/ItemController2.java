package com.hangjiang.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hangjiang.ssm.po.Items;

public class ItemController2 implements HttpRequestHandler {

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Items> itemslist = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("lenovo");
		items_1.setPrice(12311.1f);
		items_1.setDetail("Thinkpad X1");

		Items items_2 = new Items();
		items_2.setName("iphone");
		items_2.setPrice(6000.99f);
		items_2.setDetail("Iphone 6s");

		itemslist.add(items_1);
		itemslist.add(items_2);
		
		request.setAttribute("itemslist", itemslist);
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
	}

	/*
	 * public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception { List<Items> itemslist =
	 * new ArrayList<Items>();
	 * 
	 * Items items_1 = new Items(); items_1.setName("lenovo");
	 * items_1.setPrice(12311.1f); items_1.setDetail("Thinkpad X1");
	 * 
	 * Items items_2 = new Items(); items_2.setName("iphone");
	 * items_2.setPrice(6000.99f); items_2.setDetail("Iphone 6s");
	 * 
	 * itemslist.add(items_1); itemslist.add(items_2);
	 * 
	 * ModelAndView modelandview = new ModelAndView();
	 * modelandview.addObject("itemslist", itemslist);
	 * modelandview.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
	 * 
	 * return modelandview; }
	 */

}
