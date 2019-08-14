package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alien;

@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;

	@GetMapping(path="aliens")
	//@ResponseBody
	public List<Alien> aliens()
	{
		System.out.println("Aliens are fetching");
		
		return repo.findAll();
	}

	@GetMapping("aliens/{aid}")
	//@ResponseBody
	public Alien alien(@PathVariable("aid") int aid)
	{
		Alien alien=repo.findById(aid).orElse(new Alien(aid,""));
		return alien;
	}
	
	@PostMapping(path="aliens")
	public Alien addAlien(@RequestBody Alien a)
	{
		repo.save(a);
		return a;
	}
	
	@DeleteMapping("aliens/{aid}")
	public void deleteAlien(@PathVariable("aid") int aid)
	{
		repo.deleteById(aid);
		
	}
	
	
}
