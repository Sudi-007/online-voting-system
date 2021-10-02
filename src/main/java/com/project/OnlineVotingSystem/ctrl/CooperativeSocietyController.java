package com.project.OnlineVotingSystem.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineVotingSystem.model.CooperativeSociety;
import com.project.OnlineVotingSystem.service.CooperativeSocietyService;

@RestController
@RequestMapping("/api/cooperativesociety")
public class CooperativeSocietyController 
{
	
	@Autowired
	CooperativeSocietyService cooperativeSocietyService;
	@PostMapping("/society")
	public CooperativeSociety createSociety(@RequestBody CooperativeSociety society) 
	{
		return cooperativeSocietyService.addSocietyDetails(society);
	
	}
	
	
	@PutMapping("/updatesociety")
	public CooperativeSociety updateSociety(@RequestBody CooperativeSociety society) 
	{
		return cooperativeSocietyService.updateSocietyDetails(society);
	
	}
	
	
	@DeleteMapping("/deletesociety/{society}")
	public CooperativeSociety deleteSociety(@PathVariable int society) 
	{
		return cooperativeSocietyService.deleteSociety(society);
	
	}
	
	@GetMapping("/societydetails")
	public List<CooperativeSociety> viewSocietiesList()
	{
		return cooperativeSocietyService.viewSocietiesList();
	
	}
	@PostMapping("/societyid/{societyid}")
	public Optional<CooperativeSociety> societyById(@RequestBody int societyid) 
	{
		return cooperativeSocietyService.viewSocietyById(societyid);
	
	}
	

}
