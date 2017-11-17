package com.example.penny.AndroidLoginApp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static Context context;
    public static List<User> users = new ArrayList<>();
    EditText username;
    EditText password;
    User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = this;
        setContentView(R.layout.activity_main);


        Register registration = new Register();
        registration.createUser("PennyNeko", "123456", "Penny", "pennyneko@email.com", "6912345678");

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    @Override
    public void onClick(View view) {
        username = findViewById(R.id.usernameText);
        password = findViewById(R.id.passwordText);
        System.out.println(username.getText().toString());
        Login login = new Login();
        loggedUser = login.checkCreds(username.getText().toString(),password.getText().toString());

        if (loggedUser != null){

                Intent intent = new Intent(this, EditUserActivity.class);
                intent.putExtra("loggedUserParcel", loggedUser);
                startActivity(intent);
            }
        }
        public static int findUserIndexByEmail(User user){
            for (User u: users
                 ) {
                if (u.getEmail().equals(user.getEmail())){
                    return users.indexOf(u);
                }
            }
            return -1;
        }
    }

