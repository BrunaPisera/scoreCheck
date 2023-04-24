package com.bruna.scorecheckerapi.controllers;

import com.bruna.scorecheckerapi.form.LoginFom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    //@Autowired
    //AuthenticationManager authenticationManager;
    @PostMapping
    public String login(@RequestBody LoginFom form) {
        String login = form.getLogin();
        String pwd = form.getPassword();

        UsernamePasswordAuthenticationToken loginData = new UsernamePasswordAuthenticationToken(login, pwd);
        try{
            //Authentication authentication = this.authenticationManager.authenticate(loginData);
            return "Success";
        }catch(Exception e){
            return "Failed";
        }
    }

}
