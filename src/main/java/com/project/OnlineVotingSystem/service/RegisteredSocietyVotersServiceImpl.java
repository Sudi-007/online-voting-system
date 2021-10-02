package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineVotingSystem.dao.RegisteredSocietyVotersDao;
import com.project.OnlineVotingSystem.model.RegisteredSocietyVoters;

@Service
public class RegisteredSocietyVotersServiceImpl implements RegisteredSocietyVotersService {

	@Autowired
	RegisteredSocietyVotersDao registeredSocietyVotersDao;

	@Override
	public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
		return registeredSocietyVotersDao.save(voter);
	}

	@Override
	public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
		int registeredSocietyVotersId = voter.getId();
		Optional<RegisteredSocietyVoters> exisitingRegisteredSocietyVotersContainer = registeredSocietyVotersDao.findById(registeredSocietyVotersId);
		RegisteredSocietyVoters existingRegisteredSocietyVoters = null;
		if(exisitingRegisteredSocietyVotersContainer.isPresent()) {
			existingRegisteredSocietyVoters = exisitingRegisteredSocietyVotersContainer.get();
			existingRegisteredSocietyVoters.setAddress1(voter.getAddress1());
			existingRegisteredSocietyVoters.setAddress2(voter.getAddress2());
			existingRegisteredSocietyVoters.setCastedVote(voter.isCastedVote());
			existingRegisteredSocietyVoters.setDistrict(voter.getDistrict());
			existingRegisteredSocietyVoters.setEmailId(voter.getEmailId());
			existingRegisteredSocietyVoters.setFirstName(voter.getFirstName());
			existingRegisteredSocietyVoters.setGender(voter.getGender());
			existingRegisteredSocietyVoters.setLastName(voter.getLastName());
			existingRegisteredSocietyVoters.setMandal(voter.getMandal());
			existingRegisteredSocietyVoters.setMobileno(voter.getMobileno());
			existingRegisteredSocietyVoters.setPassword(voter.getPassword());
			existingRegisteredSocietyVoters.setPincode(voter.getPincode());
			existingRegisteredSocietyVoters.setReservationCategory(voter.getReservationCategory());
			existingRegisteredSocietyVoters.setSociety(voter.getSociety());
			existingRegisteredSocietyVoters.setVoterIdCardNo(voter.getVoterIdCardNo());
			
			registeredSocietyVotersDao.saveAndFlush(existingRegisteredSocietyVoters);
		}
		return existingRegisteredSocietyVoters;
	}

	@Override
	public RegisteredSocietyVoters deleteRegisteredVoter(int voterId) {

		Optional<RegisteredSocietyVoters> exisitingRegisteredSocietyVotersContainer =  registeredSocietyVotersDao.findById(voterId);;
		RegisteredSocietyVoters existingRegisteredSocietyVoters = null;
		if(exisitingRegisteredSocietyVotersContainer.isPresent()) {
			existingRegisteredSocietyVoters = exisitingRegisteredSocietyVotersContainer.get();
			registeredSocietyVotersDao.deleteById(voterId);
		}
		return existingRegisteredSocietyVoters;
	}

	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
		
		return registeredSocietyVotersDao.findAll();
	}

	@Override
	public Optional<RegisteredSocietyVoters> searchByVoterID(int voterid) {
		
		return registeredSocietyVotersDao.findById(voterid);
	}

	@Override
	public RegisteredSocietyVoters loginValidate(String voterIdCardNo, String password) {
	
		return registeredSocietyVotersDao.findUserByUserNamePassword(voterIdCardNo,password);
	}

}