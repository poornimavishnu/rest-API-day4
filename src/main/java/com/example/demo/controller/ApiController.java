package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class ApiController {
	
	@Autowired
	StudentService sser;
	
	@PostMapping("add")
	public Student add(@RequestBody Student ss)
	{
		return sser.saveinfo(ss);
	}
	@PostMapping("/")
	public boolean addDet(@RequestBody List<Student> ss)
	{
		return sser.savedetails(ss)!=null;
	}
	@GetMapping("/")
	public List<Student> show()
	{
		return sser.showinfo();
	}
	@GetMapping("{id}")
	public Optional<Student> showid(@PathVariable int id) {
		return sser.getid(id);
	}
	
	@PutMapping("/{id}")
	public Student modify(@RequestBody Student ss) {
		return sser.changeinfo(ss);
	}
	@DeleteMapping("/{id}")
	public void delid(@PathVariable int id) {
		sser.deleteid(id);
	}

}