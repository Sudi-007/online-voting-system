package com.project.OnlineVotingSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Nominated_Candidates")
public class NominatedCandidates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidateId;
	private String nominatonFormNo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private List<RegisteredSocietyVoters> society_Voter;
	
	
	
	public NominatedCandidates(int candidateId, String nominatonFormNo, List<RegisteredSocietyVoters> society_Voter) {
		super();
		this.candidateId = candidateId;
		this.nominatonFormNo = nominatonFormNo;
		this.society_Voter = society_Voter;
	}
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getNominatonFormNo() {
		return nominatonFormNo;
	}
	public void setNominatonFormNo(String nominatonFormNo) {
		this.nominatonFormNo = nominatonFormNo;
	}
	public List<RegisteredSocietyVoters> getSociety_Voter() {
		return society_Voter;
	}
	public void setSociety_Voter(List<RegisteredSocietyVoters> society_Voter) {
		this.society_Voter = society_Voter;
	}
}
