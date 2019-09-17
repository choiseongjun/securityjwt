package com.test.sp.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String usernEmail;

    @NotBlank
    private String password;

   public String getUsernEmail() {
	return usernEmail;
   }
   public void setUsernEmail(String usernEmail) {
	this.usernEmail = usernEmail;
   }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}