package com.example.penny.AndroidLoginApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Penny on 16/11/2017.
 */

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener{

    User loggedUser;
    EditText username;
    EditText password;
    EditText name;
    EditText email;
    EditText telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_activity);
        loggedUser = getIntent().getParcelableExtra("loggedUserParcel");
        assignFields();
        Button saveChangesButton = findViewById(R.id.saveChangesButton);
        saveChangesButton.setOnClickListener(this);

    }

    protected void assignFields(){
        username = findViewById(R.id.usernameText);
        password = findViewById(R.id.passwordText);
        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        telephone = findViewById(R.id.telephoneText);
        username.setText(loggedUser.getUsername());
        password.setText(loggedUser.getPassword());
        name.setText(loggedUser.getName());
        email.setText(loggedUser.getEmail());
        telephone.setText(loggedUser.getTelephone());
    }

    @Override
    public void onClick(View view) {
        int index = MainActivity.findUserIndexByEmail(loggedUser);
        username = findViewById(R.id.usernameText);
        password = findViewById(R.id.passwordText);
        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        telephone = findViewById(R.id.telephoneText);
        MainActivity.users.get(index).setUsername(username.getText().toString());
        MainActivity.users.get(index).setPassword(password.getText().toString());
        MainActivity.users.get(index).setName(name.getText().toString());
        MainActivity.users.get(index).setEmail(email.getText().toString());
        MainActivity.users.get(index).setTelephone(telephone.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(EditUserActivity.this);
        builder.setMessage("Changes saved successfully!");
        builder.setPositiveButton(
                "Okay",
                new  DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

