package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.EmpMapper;
import edu.bit.ex.vo.DeptEmpVO;
import edu.bit.ex.vo.EmpVO;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empMapper;

	public List<EmpVO> selectAll() {
		return empMapper.selectAll();
	}

	public DeptEmpVO selectResult(int deptno) {
		return empMapper.selectResult(deptno);
	}

}
