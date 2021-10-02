package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.NominatedCandidateDao;
import com.project.OnlineVotingSystem.model.NominatedCandidates;

@Service
public class NominatedCandidateServiceImpl implements NominatedCandidateService {

	@Autowired
	NominatedCandidateDao nominatedCandidateDao;

	@Override
	public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate) {
		// TODO Auto-generated method stub
		return nominatedCandidateDao.save(candidate);
	}

	@Override
	public NominatedCandidates updateNominatedCandidateDetails(NominatedCandidates candidate) {
		// TODO Auto-generated method stub
		
		int nominatedCandidatesId = candidate.getCandidateId();
		Optional<NominatedCandidates> existingNominatedCandidatesContainer =nominatedCandidateDao.findById(nominatedCandidatesId);
		NominatedCandidates existingNominatedCandidates=null;
		if(existingNominatedCandidatesContainer.isPresent())
		{
			existingNominatedCandidates=existingNominatedCandidatesContainer.get();
			existingNominatedCandidates.setNominatonFormNo(candidate.getNominatonFormNo());
			existingNominatedCandidates.setSociety_Voter(candidate.getSociety_Voter());
			nominatedCandidateDao.saveAndFlush(existingNominatedCandidates);
		}
		return existingNominatedCandidates;
	}

	@Override
	public NominatedCandidates deleteNominatedCandidate(int candidateId) {
		// TODO Auto-generated method stub
		Optional<NominatedCandidates> existingNominatedCandidatesContainer = nominatedCandidateDao.findById(candidateId);
		NominatedCandidates existingNominatedCandidates=null;
		if(existingNominatedCandidatesContainer.isPresent())
		{
			existingNominatedCandidates=existingNominatedCandidatesContainer.get();
			nominatedCandidateDao.deleteById(candidateId);
		}
		return existingNominatedCandidates;
	}

	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		return nominatedCandidateDao.findAll();
	}

	@Override
	public Optional<NominatedCandidates> searchByCandidateId(int id) {
		// TODO Auto-generated method stub
		return nominatedCandidateDao.findById(id);
	}

}