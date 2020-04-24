package edu.bit.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.emp.sercvice.EmpService;
import edu.bit.emp.vo.EmpVO;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;

	@RequestMapping("/empList")
	public List<EmpVO> getList() {
		return empService.selectAll();
	}
}