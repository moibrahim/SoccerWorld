package com.ibrahim.mohammad.soccerworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btRegisterPg;
    private Button btLogin;
    private String adminUsername;
    private String adminPassword;
    private EditText etloginUsername;
    private EditText etloginPassword;
    private String loginPassword;
    private String loginUsername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegisterPg = (Button) findViewById(R.id.btRegisterPg);
        btLogin = (Button) findViewById(R.id.btLogin);

        etloginUsername = (EditText) findViewById(R.id.etLoginUsername);
        etloginPassword = (EditText) findViewById(R.id.etLoginPassword);


        btLogin.setOnClickListener(this);
        btRegisterPg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        loginPassword = etloginPassword.getText().toString();
        loginUsername = etloginUsername.getText().toString();

        switch (v.getId()) {
            case R.id.btLogin:

                if (loginPassword.equals("password") && loginUsername.equals("Moibra")){
                    Toast.makeText(MainActivity.this,
                            "Logged in as Mo, Welcome back!", Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(MainActivity.this, HomePageActivity.class);
                    MainActivity.this.startActivity(loginIntent);

                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Login Failed, try agian", Toast.LENGTH_LONG).show();
                }
                    break;

            case R.id.btRegisterPg:
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
                break;
        }


    }
}
