package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import edu.bit.ex.vo.DeptEmpVO;
import edu.bit.ex.vo.EmpVO;

@Repository
public interface EmpMapper {
	public abstract List<EmpVO> selectAll();
	
	public abstract DeptEmpVO selectResult(@Param("deptno") int deptno);
}
