package com.tozaicevas.chat.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class UserReqDTO {
	public Long id;
	@Expose
    public String name;
	@Expose
    public String avatar;
	@Expose
    public String token;
	@Expose
    public String maxKey;
}

