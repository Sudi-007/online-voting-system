package com.project.OnlineVotingSystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineVotingSystem.model.ElectionResult;

public interface ElectionResultDao extends JpaRepository<ElectionResult, Integer>{


}
