package com.example.demo;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Alien;

@Controller
public class HomeController 
{
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name", "Coders");
	}
	

	
	@RequestMapping("/")
	public String message()
	{
		return "index";
	}
	
	/*@RequestMapping("add")
	public ModelAndView result(@RequestParam("num1") int i, @RequestParam("num2") int j)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int k=i+j;
		mv.addObject("k",k);
		return mv;
	}
	*/
	
	/*@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j, Model l)
	{
		int k=i+j;
		l.addAttribute("k",k);
		return "result";
	}*/
	
	@RequestMapping
	public String add(@RequestParam("num1")  int i,@RequestParam("num2") int j, ModelMap l)
	{
		int k=i+j;
		l.addAttribute("k", k);
		return "result";
		
	}
	
	/*@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid") int aid,@RequestParam("aname") String aname, Model l)
	{
		Alien obj=new Alien();
		obj.setAid(aid);
		obj.setAname(aname);
		l.addAttribute("alien", obj);
		return "result";
	}*/
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alien") Alien a)
	{
		
		repo.save(a);
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(ModelMap m)
	{
		//List<Alien> list=Arrays.asList(new Alien(01,"Raman"),(new Alien(02,"Batra")));
		m.addAttribute("result",repo.findAll());
			return "showAliens";
	}
	@GetMapping("getAlienById")
	public String getAlienById(@RequestParam int aid, ModelMap m)
	{
		m.addAttribute("result", repo.findById(aid));
		return "showAliens";
	}
	@GetMapping("getAlienByAname")
	public String getAlienByAname(@RequestParam String aname, Model m)
	{
		
		m.addAttribute("result",repo.getAlienByAnameOrderByAidDesc(aname));
		return "showAliens";
	}
	
	@GetMapping("getAlienByUsingQuery")
	public String getAlienByUsingQuery(@RequestParam String aname, Model m)
	{
		m.addAttribute("result",repo.find(aname));
		return "showAliens";
	}
	
	
}
