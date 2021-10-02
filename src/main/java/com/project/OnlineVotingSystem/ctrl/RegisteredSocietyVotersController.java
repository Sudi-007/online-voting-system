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


import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;
import com.project.OnlineVotingSystem.service.RegisteredSocietyVotersService;

@RestController
@RequestMapping("/api/regsocietyvoters")
public class RegisteredSocietyVotersController {
	@Autowired
	RegisteredSocietyVotersService registeredSocietyVotersService;
	@PostMapping("/voter")
	public RegisteredSocietyVoters voterRegistration(@RequestBody RegisteredSocietyVoters voter)
	{
		return registeredSocietyVotersService.voterRegistration(voter);
		
	}
	
	@PutMapping("/updatevoter")
	public RegisteredSocietyVoters updateRegisteredVoterDetails(@RequestBody RegisteredSocietyVoters voter)
	{
		return registeredSocietyVotersService.updateRegisteredVoterDetails(voter);
		
	}
	
	@DeleteMapping("/deletevoter/{voterId}")
	public RegisteredSocietyVoters deleteRegisteredVoter(@PathVariable int voterId)
	{
		return registeredSocietyVotersService.deleteRegisteredVoter(voterId);
		
	}
	
	@GetMapping("/viewreguser")
	public List<RegisteredSocietyVoters> viewRegisteredVoterList()
	{
		return registeredSocietyVotersService.viewRegisteredVoterList();
	
	}
	
	@GetMapping("/voter/{voterId}")
	public Optional<RegisteredSocietyVoters> searchByVoterID(@PathVariable int voterId) 
	{
		return registeredSocietyVotersService.searchByVoterID(voterId);
	
	}
	
	@GetMapping("/validateid/{voterIdCardNo}/{password}")
	public RegisteredSocietyVoters loginValidate(@PathVariable String voterIdCardNo, @PathVariable String password) 
	{
		return registeredSocietyVotersService.loginValidate(voterIdCardNo,password);
	
	}
	
	
}
