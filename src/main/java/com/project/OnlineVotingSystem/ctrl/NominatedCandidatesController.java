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
import com.project.OnlineVotingSystem.model.NominatedCandidates;
import com.project.OnlineVotingSystem.service.NominatedCandidateService;

@RestController
@RequestMapping("/api/nominatedCandidate")
public class NominatedCandidatesController {
	@Autowired
	NominatedCandidateService nominatedCandidateService;
	@PostMapping("/candidate")
	public NominatedCandidates createCandidates(@RequestBody NominatedCandidates candidate) 
	{
		return nominatedCandidateService.addNominatedCandidate(candidate);
	
	}
	
	@PutMapping("/updatecandidate")
	public NominatedCandidates updateCandidates(@RequestBody NominatedCandidates candidate) 
	{
		return nominatedCandidateService.updateNominatedCandidateDetails(candidate);
	
	}
	@DeleteMapping("/deletecandidate/{candidate}")
	public NominatedCandidates deleteCandidates(@PathVariable int candidate) 
	{
		return nominatedCandidateService.deleteNominatedCandidate(candidate);
	
	}
	@GetMapping("/candidatedetails")
	public List<NominatedCandidates> viewNominatedCandidatesList()
	{
		return nominatedCandidateService.viewNominatedCandidatesList();
	
	}
	
	@GetMapping("/candidateid/{id}")
	public Optional<NominatedCandidates> ByCandidateId(@PathVariable int id) 
	{
		return nominatedCandidateService.searchByCandidateId(id);
	
	}
	

}
