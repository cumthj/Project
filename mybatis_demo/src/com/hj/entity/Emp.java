package com.hj.entity;

public class Emp {
	private int empNo;
	private String empName;
	private String job;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	public Emp(int empNo, String empName, String job) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
	}

	public Emp(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", job=" + job
				+ "]";
	}

	
}
