package com.example.vehicleportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vehicleportal.Loginclass;
import com.example.vehicleportal.R;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Loginclass login = new Loginclass(email.getText().toString(), password.getText().toString());
                if (login.email.equals("admin") && login.password.equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    SaveUsernamePassword();

                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
        private void SaveUsernamePassword(){
            SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            editor.putString("username",email.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.commit();
            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show();
        }
    }

