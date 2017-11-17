package com.example.penny.AndroidLoginApp;

/**
 * Created by Penny on 15/11/2017.
 */

public class Register {

    public void createUser(String username, String password, String name, String email, String telephone){
        MainActivity.users.add(new User(username,password,name,email,telephone));
    }
}
