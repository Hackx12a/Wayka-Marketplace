package com.ecommerce.wyka.Controller;


import com.ecommerce.wyka.Model.AccountStatus;
import com.ecommerce.wyka.Model.Users;
import com.ecommerce.wyka.Services.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private DbUserDetailsService dbUserDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<Users> createAccount(@RequestBody  Users users){

        try{
            Users user = dbUserDetailsService.createAccount(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @GetMapping("/home")
    public String geItems(){
        return "hello world";
    }


}
