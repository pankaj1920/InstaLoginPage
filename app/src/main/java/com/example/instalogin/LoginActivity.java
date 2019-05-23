package com.example.instalogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText login, password;
    Button btn_login;
    TextView singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        singup = findViewById(R.id.singup);

        final SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);

        final String requried_email = preferences.getString("EMAIL", "Default_email");
        final String requried_password = preferences.getString("PASSWORD", "Default_password");


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_emal = login.getText().toString();
                String login_password = password.getText().toString();

                if (requried_email.equals(login_emal) && requried_password.equals(login_password)) {
                    Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "user or password incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RigesterActivity.class);
                startActivity(intent);
            }
        });
    }

}
