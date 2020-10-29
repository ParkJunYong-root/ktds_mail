package com.park.sys.customer.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("customerVO")
public class CustomerVO {
	private Integer bookNum;
	private String park;
	private String entryDate;
	private String exitDate;
	private String carType;
	private String carNum;
	private String cellNum;
	private String email;
	private String pwd;
	private Date joinDate;

	public CustomerVO() {
		System.out.println("MemberVO 생성자 호출");
	}

	public CustomerVO(Integer bookNum, String park, String entryDate, String exitDate, String carType,
			String carNum, String cellNum, String email,String pwd) {
		super();
		this.bookNum = bookNum;
		this.park = park;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.carType = carType;
		this.carNum = carNum;
		this.cellNum = cellNum;
		this.email = email;
		this.pwd = pwd;

	}

	public CustomerVO(Integer bookNum, String park, String entryDate, String exitDate, String carType,
			String carNum, String cellNum, String email,String pwd,Date joinDate) {
		super();
		this.bookNum = bookNum;
		this.park = park;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.carType = carType;
		this.carNum = carNum;
		this.cellNum = cellNum;
		this.email = email;
		this.pwd = pwd;
		this.joinDate = joinDate;

	}

	public Integer getBookNum() {
		return bookNum;
	}

	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}

	public String getPark() {
		return park;
	}

	public void setPark(String park) {
		this.park = park;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getExitDate() {
		return exitDate;
	}

	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getCellNum() {
		return cellNum;
	}

	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
