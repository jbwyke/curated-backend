package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.FollowNotFoundException;
import com.revature.model.Follow;
import com.revature.repositories.FollowDAO;

@Service
public class FollowService {

	@Autowired
	private FollowDAO followDao;
	
	public Set<Follow> findAll() {
		return followDao.findAll().stream().collect(Collectors.toSet());
	}
	
	public Follow findById(int follower, int following) {
		return followDao.findByFollowerIdAndFollowingId(follower, following).orElseThrow(() -> new FollowNotFoundException("No follow found"));
	}
	
	public Set<Follow> findByFollower(int follower) {
		return followDao.findByFollowerId(follower).orElseThrow(() -> new FollowNotFoundException("No follow found from user: " + follower));
	}
	
	public Set<Follow> findByFollowing(int following) {
		return followDao.findByFollowingId(following).orElseThrow(() -> new FollowNotFoundException("No follow found to user: " + following));
	}
	
	public Follow addFollow(Follow follow) {
		return followDao.save(follow);
	}
}
