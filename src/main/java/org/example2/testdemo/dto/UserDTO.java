package org.example2.testdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String uid;
    private String email;
    private String given_name;
    private String middle_name;
    private String phone_number;
}
