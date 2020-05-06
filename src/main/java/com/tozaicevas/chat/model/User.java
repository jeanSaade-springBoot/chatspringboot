package com.tozaicevas.chat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SerializedName(value = "_id", alternate = "id")
    @Expose
    private Long id;

    @Expose
    private String name;

    @Expose
    private String avatar;
    
    @Expose
    private String token;
}
