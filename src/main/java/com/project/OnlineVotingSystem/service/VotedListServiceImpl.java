package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.VotedListDao;
import com.project.OnlineVotingSystem.model.VotedList;

@Service
public class VotedListServiceImpl implements VotedListService {
	
	@Autowired
	VotedListDao votedListDao;
	@Override
	public VotedList castVotedList(VotedList votedList) {
		// TODO Auto-generated method stub
		return votedListDao.save(votedList);
	}

	@Override
	public VotedList updateVotedListDetails(VotedList votedList) {
		int id = votedList.getId();
		Optional<VotedList> existingVotedListContainer = votedListDao.findById(id);
		VotedList existingVotedList = null;
		if(existingVotedListContainer.isPresent()) {
			existingVotedList = existingVotedListContainer.get();
			existingVotedList.setPollingDateTime(votedList.getPollingDateTime());
			existingVotedList.setSociety(votedList.getSociety());
			existingVotedList.setVoter(votedList.getVoter());
			existingVotedList.setCandidate(votedList.getCandidate());
			votedListDao.saveAndFlush(existingVotedList);
		}
		return existingVotedList;
	}

	@Override
	public VotedList deletedVotedListDetails(int id) {
		Optional<VotedList> existingvotedlistContainer = votedListDao.findById(id);
		VotedList existingvotedlist = null;
		if(existingvotedlistContainer.isPresent()) {
			existingvotedlist  = existingvotedlistContainer.get();
			votedListDao.deleteById(id);
		}
		return existingvotedlist;
	}

	@Override
	public List<VotedList> viewVotedList() {
		// TODO Auto-generated method stub
		return votedListDao.findAll();
	}

	@Override
	public Optional<VotedList> searchByVoterId(int voterId) {
		// TODO Auto-generated method stub
		return votedListDao.findById(voterId);
	}

	@Override
	public Optional<VotedList> searchByNominatedCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return votedListDao.findById(candidateId);
	}

}
