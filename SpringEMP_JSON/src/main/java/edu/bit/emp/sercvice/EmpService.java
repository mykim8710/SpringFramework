package edu.bit.emp.sercvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.emp.mapper.EmpMapper;
import edu.bit.emp.vo.EmpVO;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empMapper;

	public List<EmpVO> selectAll() {
		return empMapper.selectAll();
	}

	public EmpVO selectOne(int empNo) {
		return empMapper.selectOne(empNo);
	}	
}
