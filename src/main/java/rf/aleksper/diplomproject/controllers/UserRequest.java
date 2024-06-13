package rf.aleksper.diplomproject.controllers;

import lombok.Data;

@Data
public class UserRequest {
    private final String username;
    private final String password;
    private final String role;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
}



