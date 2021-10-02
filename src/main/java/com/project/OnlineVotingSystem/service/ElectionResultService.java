package com.project.OnlineVotingSystem.service;

import java.util.List;
import java.util.Optional;

import com.project.OnlineVotingSystem.model.ElectionResult;

public interface ElectionResultService {
    ElectionResult addElectionResult(ElectionResult result);
    List<ElectionResult> viewElectionResultList();
    Optional<ElectionResult> viewCandidatewiseResult(int candidateId);

}
