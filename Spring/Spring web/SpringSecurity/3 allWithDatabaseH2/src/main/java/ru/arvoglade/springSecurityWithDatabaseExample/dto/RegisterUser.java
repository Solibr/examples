package ru.arvoglade.springSecurityWithDatabaseExample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUser {
    private String username;
    private String password;
}
