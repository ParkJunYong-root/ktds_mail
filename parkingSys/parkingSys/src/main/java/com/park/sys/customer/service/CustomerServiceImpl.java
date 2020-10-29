package com.park.sys.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.park.sys.customer.dao.CustomerDAO;
import com.park.sys.customer.vo.CustomerVO;


@Service("customerService")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

//	@Override
//	public List selectCustomer() throws DataAccessException {
//		List customerList = null;
//		customerList = customerDAO.selectCustomerList();
//		return customerList;
//	}
	
	
	@Override
	public int removeCustomer(String carNum) throws DataAccessException {
		return customerDAO.deleteCustomer(carNum);
	}
	
//	@Override
//	public int selectCustomer(String carNum) throws DataAccessException {
//		return customerDAO.selectCustomer(carNum);
//	}
	
	@Override
	public CustomerVO checkin(CustomerVO customerVO) throws Exception{
		return customerDAO.checkinByCarNum(customerVO);
	}

	@Override
	public int addCustomer(CustomerVO customer) throws DataAccessException {
		return customerDAO.insertCustomer(customer);
	}

}
