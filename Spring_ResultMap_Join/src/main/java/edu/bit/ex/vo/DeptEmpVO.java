package edu.bit.ex.vo;

import java.util.List;

public class DeptEmpVO {
	private int deptNo;
	private String dName;
	private String loc;
	private List<EmpVO> empList;

	public DeptEmpVO() {
	}

	public DeptEmpVO(int deptNo, String dName, String loc, List<EmpVO> empList) {
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
		this.empList = empList;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<EmpVO> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmpVO> empList) {
		this.empList = empList;
	}

}
