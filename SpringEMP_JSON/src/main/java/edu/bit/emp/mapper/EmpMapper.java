package edu.bit.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import edu.bit.emp.vo.EmpVO;

@Repository
public interface EmpMapper {
	@Select("SELECT * FROM EMP")
	List<EmpVO> selectAll();
	
	@Select("SELECT * FROM EMP WHERE EMPNO = #{empNo}")
	EmpVO selectOne(@Param("empNo") int empNo);
}
