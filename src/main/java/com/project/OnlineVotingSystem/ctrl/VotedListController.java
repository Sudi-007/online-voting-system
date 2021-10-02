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

import com.project.OnlineVotingSystem.model.VotedList;
import com.project.OnlineVotingSystem.service.VotedListService;

@RestController
@RequestMapping("/api/votedlist")
public class VotedListController {

	@Autowired
	VotedListService votedListService;
	
	@PostMapping("/votedlist")
	public VotedList createVotedList(@RequestBody VotedList votedList) 
	{
		return votedListService.castVotedList(votedList);
	
	}
	
	@PutMapping("/updatevotedlist")
	public VotedList updateVotedList(@RequestBody VotedList votedList) 
	{
		return votedListService.updateVotedListDetails(votedList);
	
	}
	

	@DeleteMapping("/deletevotedlist/{id}")
	public VotedList deletedVotedList(@PathVariable int id) 
	{
		return votedListService.deletedVotedListDetails(id);
	
	}

	@GetMapping("/votedlistdetails")
	public List<VotedList> viewVotedList()
	{
		return votedListService.viewVotedList();
	
	}


	@PostMapping("/voterid/{voterId}")
	public Optional<VotedList> searchByVoterId(@PathVariable int voterId) 
	{
		return votedListService.searchByVoterId(voterId);
	
	}
	
	@PostMapping("/nominatedcandidateid/{candidateid}")
	public Optional<VotedList> searchByNominatedCandidateId(@PathVariable int candidateId)
	{
		return votedListService.searchByNominatedCandidateId(candidateId);
	
	}
	
}
