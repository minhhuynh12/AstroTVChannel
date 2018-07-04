package com.example.astro.astrotechnology;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Model.LoginItems;

/**
 * Created by vitinhHienAnh on 08-05-18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSubmitLogin;
    EditText edUsername;
    EditText edPassword;
    String username;
    String password;
    ArrayList<LoginItems> list;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefsLogin";
    public static final String Pin = "PIN_";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        btnSubmitLogin = findViewById(R.id.btnSubmitLogin);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnSubmitLogin.setOnClickListener(this);

        list = new ArrayList<>();
        list.add(new LoginItems("minhhc", "123456"));
        list.add(new LoginItems("minhhc2", "123456"));
        list.add(new LoginItems("minhhc3", "123456"));
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(Pin, Context.MODE_PRIVATE);
        String usernameSp = sharedpreferences.getString("username", "");
        String pin = sharedpreferences.getString("pin_code" , "");
        if (!usernameSp.isEmpty() && !pin.isEmpty()) {
            Intent intent = new Intent(this, PinActivity.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmitLogin:
                if (edUsername.getText().equals("")) {
                    Toast.makeText(this, "Please input username", Toast.LENGTH_SHORT).show();
                } else if (edPassword.getText().equals("")) {
                    Toast.makeText(this, "Please input password", Toast.LENGTH_SHORT).show();
                } else {
                    username = edUsername.getText().toString();
                    password = edPassword.getText().toString();
                    checkLogin(username, password);
                }
//                Toast.makeText(this, "Please input username" , Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void checkLogin(String username, String password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username) && list.get(i).getPassword().equals(password)) {
                Toast.makeText(this, "Exactly", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("username", username);
                editor.commit();
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
