package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.DetailsRepository;

@Service
public class DetailsServiceImpl implements DetailsService{

	@Autowired
	private DetailsRepository detailsRepository;
	@Override
	public List<UserDetails> getAllUserDetailss() {
		return detailsRepository.findAll();
	}
	@Override
	public void saveUserDetails(UserDetails userDetails) {
		this.detailsRepository.save(userDetails);
		
	}

}
