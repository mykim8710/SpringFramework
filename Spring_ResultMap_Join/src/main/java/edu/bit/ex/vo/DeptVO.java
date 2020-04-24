package edu.bit.ex.vo;

public class DeptVO {
	private int deptNo;
	private String dName;
	private String loc;
	
	public DeptVO() {}
	
	public DeptVO(int deptNo, String dName, String loc) {
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
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

}
