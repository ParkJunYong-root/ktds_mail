package com.park.sys.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.park.sys.customer.service.CustomerService;
import com.park.sys.customer.vo.CustomerVO;
import com.park.sys.customer.vo.CustomerVO;

@Controller("customerController")
public class CustomerControllerImpl implements CustomerController{
	@Autowired
	private CustomerService customerService;
	@Autowired
	CustomerVO customerVO;
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = { "/","/main.do"}, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value="/customer/addCustomer.do" ,method = RequestMethod.POST)
	public ModelAndView addNewCustomer(@ModelAttribute("customer") CustomerVO customer,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(customer);
		int result = 0;
		result = customerService.addCustomer(customer);
		ModelAndView mav = new ModelAndView("redirect:/customer/reservationFinishForm.do"); //예약 확인되었습니다. 페이지로 이동
		return mav;
	}
	/*
	@Override
	@RequestMapping(value="/customer/addCustomer.do" ,method = RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer") CustomerVO customer,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = customerService.addCustomer(customer);
		ModelAndView mav = new ModelAndView("redirect:/customer/예약확인.do"); //예약 확인되었습니다. 페이지로 이동
		return mav;
	}
	*/
	
	@Override
	@RequestMapping(value="/customer/removeCustomer.do" ,method = RequestMethod.GET)
	public ModelAndView removeCustomer(@RequestParam("id") String carNum, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		customerService.removeCustomer(carNum);
		ModelAndView mav = new ModelAndView("redirect:/customer/예약취소안내.do"); //예약취소안내로 이동
		return mav;
	}
	
//	@Override
//	@RequestMapping(value="/customer/selectCustomer.do" ,method = RequestMethod.POST)
//	public ModelAndView selectCustomer(@RequestParam("carNum") String carNum, 
//			           HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		customerService.selectCustomer(carNum);
//		System.out.println(customerService.selectCustomer(carNum));
//		ModelAndView mav = new ModelAndView("redirect:/customer/reservationResultForm.do"); //예약취소안내로 이동
//		return mav;
//	}
	
	@Override
	@RequestMapping(value = "/customer/checkin.do", method = RequestMethod.POST)
	public ModelAndView checkin(@ModelAttribute("customer") CustomerVO customer,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {
	ModelAndView mav = new ModelAndView();
	customerVO = customerService.checkin(customer);
	if(customerVO != null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("customer", customerVO);
	    session.setAttribute("isLogOn", true);
	    //mav.setViewName("redirect:/member/listMembers.do");
	    String action = (String)session.getAttribute("action");
	    session.removeAttribute("action");
	    if(action!= null) {
	       mav.setViewName("redirect:"+action);
	    }else {
	       mav.setViewName("redirect:/customer/reservationResultForm.do");	
	    }

	}else {
	   rAttr.addAttribute("result","loginFailed");
	   mav.setViewName("redirect:/customer/reservationCheckForm.do");
	}
	return mav;
	}

	@Override
	@RequestMapping(value = "/customer/checkout.do", method =  RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/예약취소내역페이지.do");
		return mav;
	}	
	
	/*
	@RequestMapping(value = { "/customer/reservationForm.do" }, method =  RequestMethod.GET)
//	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/

	@RequestMapping(value = "/customer/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
							  @RequestParam(value= "action", required=false) String action,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(viewName);
		HttpSession session = request.getSession();
		session.setAttribute("action", action);  
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

}
