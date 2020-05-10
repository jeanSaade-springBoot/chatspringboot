package com.tozaicevas.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tozaicevas.chat.dto.UserReqDTO;
import com.tozaicevas.chat.dto.UserResDTO;
import com.tozaicevas.chat.model.User;
import com.tozaicevas.chat.service.ChatService;

@RestController
@RequestMapping(value = "chat")
public class ChatController {
	 @Autowired
	 private final ChatService chatService;
	 private final Gson gson;
	 public ChatController(ChatService chatService, Gson gson) {
	        this.chatService      = chatService;
	        this.gson             =gson;
	    }
	    
	    @GetMapping(value = "finduserbytoken", produces = MediaType.APPLICATION_JSON_VALUE)
	    public  UserResDTO findUserByToken(@RequestParam(name = "token")  String token){
	    	UserResDTO userResDTO =  chatService.findUserByToken(token);
			   return userResDTO;
	    }
	    
	    @PostMapping(value = "saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	    public UserResDTO saveUser(@RequestBody UserReqDTO uerReqDTO){
	    	   UserResDTO userResDTO =  chatService.saveUser(uerReqDTO);
			   return userResDTO;
	    }
}
