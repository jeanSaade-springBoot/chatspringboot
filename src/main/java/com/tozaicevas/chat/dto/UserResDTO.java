package com.tozaicevas.chat.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResDTO {
	@Expose
	@SerializedName(value = "_id", alternate = "id")
    private Long id;
	@Expose
    private String name;
	@Expose
    private String avatar;
	@Expose
    private String token;
	@Expose
    private String status;
}

