package com.codewithmosh.store.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    //    @JsonIgnore
    //    @JsonProperty("user_id")
    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
    //    @JsonInclude(JsonInclude.Include.NON_NULL)
    //    private String phoneNumber;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //    private LocalDateTime createdAt;
}
