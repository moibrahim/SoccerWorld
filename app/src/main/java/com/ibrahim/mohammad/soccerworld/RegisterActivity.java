package com.ibrahim.mohammad.soccerworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements OnClickListener {


    private EditText etName;
    private  EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btJoinNow;
    private String username;
    private String password;
    private String email;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btJoinNow = (Button) findViewById(R.id.btRegister);

        btJoinNow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        email = etEmail.getText().toString();
        name = etName.getText().toString();


        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || name.isEmpty()){
            Toast.makeText(RegisterActivity.this,
                    "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent prefIntent = new Intent(RegisterActivity.this, PreferenceActivity.class);
            prefIntent.putExtra("usernameInput", username);
            RegisterActivity.this.startActivity(prefIntent);
        }

    }
}
