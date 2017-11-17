package com.example.penny.AndroidLoginApp;

import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by Penny on 15/11/2017.
 */

public class Login {

    String username;
    String password;

    public User checkCreds(String username, String password)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.getAppContext());
        builder.setPositiveButton(
                "Okay",
                new  DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        for (User u: MainActivity.users) {
            if (u.getUsername().equals(username)){
                if(u.getPassword().equals(password)){
                    return u;
                }else {
                    builder.setMessage("Wrong Password, please try again.");
                    AlertDialog alert = builder.create();
                    alert.show();
                    return null;
                }
            }
        }
        builder.setMessage("Wrong Username, please try again.");
        AlertDialog alert = builder.create();
        alert.show();
        return null;
    }

    public boolean logIn(){
        if (checkCreds(username,password) != null){
            return true;
        }else {
            return false;
        }
    }

}
