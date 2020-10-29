package com.park.sys.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.park.sys.customer.vo.CustomerVO;

public interface CustomerDAO {
	 public int insertCustomer(CustomerVO customerVO) throws DataAccessException ;
	 public int deleteCustomer(String id) throws DataAccessException;
//	 public int selectCustomer(String carNum) throws DataAccessException;
	 public CustomerVO checkinByCarNum(CustomerVO customerVO) throws DataAccessException;
}
