package com.example.instalogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RigesterActivity extends AppCompatActivity {
    EditText register_emial, rigester_password, rigester_re_password;
    Button btn_signup1, btn_login1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigester);

        register_emial = (EditText) findViewById(R.id.emial);
        rigester_password = (EditText) findViewById(R.id.password);
        rigester_re_password = (EditText) findViewById(R.id.re_password);
        btn_login1 = (Button) findViewById(R.id.btn_login1);
        btn_signup1 = (Button) findViewById(R.id.btn_signup1);

        btn_signup1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String emial = register_emial.getText().toString();
                String password = rigester_password.getText().toString();
                String re_password = rigester_re_password.getText().toString();

                //if both passwor are same then only it should register
                if (password.equals(re_password)) {
                    SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("EMAIL", emial);
                    editor.putString("PASSWORD", password);
                    editor.putString("RE_PASSWORD", re_password);
                    editor.commit();

                    Toast.makeText(RigesterActivity.this, "Registration Sucessful", Toast.LENGTH_SHORT).show();
                    if (!password.equals(re_password)) {
                        Intent intent = new Intent(RigesterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }else {
                    Toast.makeText(RigesterActivity.this, "Password not matched", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btn_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RigesterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
