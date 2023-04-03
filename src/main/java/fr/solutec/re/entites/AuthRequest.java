package fr.solutec.re.entites;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;

public class AuthRequest {
    @NotNull @Email
    private String email;

    @NotNull
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
