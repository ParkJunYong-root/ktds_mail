package com.park.sys.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.park.sys.customer.vo.CustomerVO;

public interface CustomerController {
	//public ModelAndView addCustomer(@ModelAttribute("info") CustomerVO customerVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeCustomer(@RequestParam("bookNum") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView checkin(@ModelAttribute("customer") CustomerVO customer,
                              RedirectAttributes rAttr,
                              HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addNewCustomer(@ModelAttribute("info") CustomerVO customerVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
