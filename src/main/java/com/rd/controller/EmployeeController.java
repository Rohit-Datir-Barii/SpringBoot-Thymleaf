package com.rd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rd.entity.Employee;
import com.rd.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/")
	public  String showHome() {
		return "home";
	}

	@GetMapping("/report")
	public  String  showEmployeeReport(Map<String,Object> map) {
		List<Employee> list=empService.getAllEmployees();
		map.put("empsData",list);
		return "employee_report";
	}

	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setJob("CLERK");  //intial value to display in form comp as initial value
		return "employee_register";
	}

	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		String result=empService.registerEmployee(emp);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:report";
	}


	@GetMapping("/edit")
	public String  showEditEmployeeForm(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		Employee emp1=empService.getEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit";
	}

	@PostMapping("/edit")
	public String  EditEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs) {
		String msg=empService.editEmployee(emp);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String  deleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		String msg=empService.deleteEmployee(no);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

}
