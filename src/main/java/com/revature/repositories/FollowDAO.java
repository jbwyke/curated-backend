package com.revature.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Follow;

public interface FollowDAO extends JpaRepository<Follow, Integer>{
	public Optional<Set<Follow>> findByFollowerId(int id);
	
	public Optional<Set<Follow>> findByFollowingId(int id);
	
	public Optional<Follow> findByFollowerIdAndFollowingId(int follower, int following);
}
