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
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btRegisterPg;
    private Button btLogin;
    private String adminUsername;
    private String adminPassword;
    private EditText etloginUsername;
    private EditText etloginPassword;
    private String loginPassword;
    private String loginUsername;
    private User user;
    private AppDatabase database;


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



/*
        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.userDao().removeAllUsers();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Test 1", 1));
            user = database.userDao().getAllUser().get(0);
            Trophy trophy = new Trophy(user.id, "Learned to use 3");
            database.trophyDao().addTrophy(trophy);
            database.userDao().addUser(new User(2, "Test 2", 2));
            database.userDao().addUser(new User(3, "Test 3", 3));
        }

*/

    }
/*

    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<Trophy> trophiesForUser = database.trophyDao().findTrophiesForUser(user.get(0).id);
        TextView textView = findViewById(R.id.tvUsername);
        Toast.makeText(this, trophiesForUser.toString(), Toast.LENGTH_SHORT).show();
        if (user.size()>0){
            textView.setText(user.get(0).name + " Skill points " + user.get(0).skillPoints + " Trophys " + trophiesForUser.size() );
        }
    }

*/



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
