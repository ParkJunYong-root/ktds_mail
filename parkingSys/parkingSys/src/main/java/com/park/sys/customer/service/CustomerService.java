package com.park.sys.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.park.sys.customer.vo.CustomerVO;

public interface CustomerService {
	 public int addCustomer(CustomerVO customerVO) throws DataAccessException;
	 public int removeCustomer(String id) throws DataAccessException;
//	 public int selectCustomer(String carNum) throws DataAccessException;
	 public CustomerVO checkin(CustomerVO customerVO) throws Exception;
}
