package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.ElectionResultDao;
import com.project.OnlineVotingSystem.model.ElectionResult;

@Service
public class ElectionResultServiceImpl implements ElectionResultService{
	
	@Autowired
	ElectionResultDao electionresultDao;

	@Override
	public ElectionResult addElectionResult(ElectionResult result) {
		return electionresultDao.save(result);
	}

	@Override
	public List<ElectionResult> viewElectionResultList() {
		return electionresultDao.findAll();
	}

	@Override
	public Optional<ElectionResult> viewCandidatewiseResult(int candidateId) {
		return electionresultDao.findById(candidateId);
	}

}
