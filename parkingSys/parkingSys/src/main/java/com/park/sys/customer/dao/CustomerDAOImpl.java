package com.park.sys.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.park.sys.customer.vo.CustomerVO;


@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertCustomer(CustomerVO customerVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.customer.insertCustomer", customerVO);
		return result;
	}

	@Override
	public int deleteCustomer(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.customer.deleteCustomer", id);
		return result;
	}
	
//	@Override
//	public int selectCustomer(String carNum) throws DataAccessException {
//		int result = sqlSession.selectOne("mapper.customer.selectCustomer", carNum);
//		return result;
//	}

	
	@Override
	public CustomerVO checkinByCarNum(CustomerVO customerVO) throws DataAccessException{
		CustomerVO vo = sqlSession.selectOne("mapper.customer.checkinByCarNum",customerVO);
		return vo;
	}

}
