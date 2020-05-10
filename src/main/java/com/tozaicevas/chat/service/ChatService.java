package com.tozaicevas.chat.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tozaicevas.chat.dto.UserReqDTO;
import com.tozaicevas.chat.dto.UserResDTO;
import com.tozaicevas.chat.model.User;
import com.tozaicevas.chat.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatService {
	
	private static final String USER_DOES_NOT_EXIST           = "user with id %s does not exist.";
	@Autowired
	UserRepository userRepository;
	
	
	public UserResDTO findUserByToken(String token) 
	{
		Optional<User> userOpt = userRepository.findByToken(token);
		User user = null;
		if(userOpt.isPresent())
		user  = userOpt.get();
		// TODO Auto-generated method stub
		UserResDTO userResDTO;
		
		if(user != null)
			userResDTO = UserResDTO.builder()
				                .id(user.getId())
				                .avatar(user.getAvatar())
				                .name(user.getName())
				                .token(user.getToken())
				                .status("exist")
				                .build();
		else
		{
			userResDTO = UserResDTO.builder()
	                .token(token)
	                .status("new")
	                .build();
		}
		return userResDTO; 
	}


	public UserResDTO saveUser(UserReqDTO userReqDTO)
	{
		// TODO Auto-generated method stub
		User user = User.builder()
				        .name(userReqDTO.getName()+"_"+generateRandomToken())
				        .token(userReqDTO.getToken())
				        .build();
		user = userRepository.save(user);
		UserResDTO userResDTO = UserResDTO.builder()
				    .name(user.getName())
				    .id(user.getId())
				    .token(user.getToken())
				    .status("saved")
				    .build();
				 
        return userResDTO;
	}
	
	public User updateUser(UserReqDTO userReqDTO)
	{
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findById(userReqDTO.getId());
		User user = userOpt.get();
		user.setName(userReqDTO.getName()+"_"+generateRandomToken());
		user.setToken(userReqDTO.getToken());		
        return userRepository.save(user);
	}
	
	
	public String generateRandomToken() {
	    return UUID.randomUUID().toString().split("-")[1];
	}
}
