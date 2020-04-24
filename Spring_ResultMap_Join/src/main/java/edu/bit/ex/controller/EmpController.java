package edu.bit.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.service.EmpService;
import edu.bit.ex.vo.DeptEmpVO;
import edu.bit.ex.vo.EmpVO;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;

	@RequestMapping("/empList")
	public String empList(Model model) {
		System.out.println("EMP 테이블 리스트");
		List<EmpVO> empList = empService.selectAll();
		model.addAttribute("empList", empList);
		return "empList";
	}

	@RequestMapping("/deptEmpJoin")
	public String deptEmpList(Model model) {
		System.out.println("EMP 테이블 - DEPT 테이블 조인");

		DeptEmpVO deptEmpJoin = empService.selectResult(30);
		model.addAttribute("deptEmpJoin", deptEmpJoin);

		return "deptEmpJoin";
	}

}
