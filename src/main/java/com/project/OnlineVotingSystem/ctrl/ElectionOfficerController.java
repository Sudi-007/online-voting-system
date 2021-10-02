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

import com.project.OnlineVotingSystem.model.ElectionOfficer;
import com.project.OnlineVotingSystem.service.ElectionOfficeService;


@RestController
@RequestMapping("/api/electionoffice")
public class ElectionOfficerController {
	
	@Autowired
	ElectionOfficeService electionOfficeService;
	
	
    @PostMapping("/office")
	public ElectionOfficer createOffice(@RequestBody ElectionOfficer office) 
	{
		return electionOfficeService.addElectionOfficerDetails(office);
	
	}
	
	
	@PutMapping("/updateoffice")
	public ElectionOfficer updateOffice(@RequestBody ElectionOfficer office) 
	{
		return electionOfficeService.updateElectionOfficerDetails(office);
	
	}
	
	
	@DeleteMapping("/deleteoffice/{office}")
	public ElectionOfficer deleteOffice(@PathVariable int office) 
	{
		return electionOfficeService.deleteElectionOffice(office);
	
	}
	
	@PostMapping("/officeid/{officeId}")
	public Optional<ElectionOfficer> officeById(@PathVariable int officeId) 
	{
		return electionOfficeService.viewElectionOfficeById(officeId);
	
	}
	@GetMapping("/officedetails")
	public List<ElectionOfficer> viewElectionOfficeList()
	{
		return electionOfficeService.viewElectionOfficeList();
	
	}
}
