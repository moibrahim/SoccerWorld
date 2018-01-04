package com.ibrahim.mohammad.soccerworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btRegisterPg;
    private Button btLogin;
    private Button btGuest;
    private String adminUsername;
    private String adminPassword;
    private EditText etloginUsername;
    private EditText etloginPassword;
    private String loginPassword;
    private String loginUsername;
    private AppDatabase database;
    private String passwordDatabase;
    private String usernameDatabase;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegisterPg = (Button) findViewById(R.id.btRegisterPg);
        btLogin = (Button) findViewById(R.id.btLogin);
        btGuest = (Button) findViewById(R.id.btGuest);
        etloginUsername = (EditText) findViewById(R.id.etLoginUsername);
        etloginPassword = (EditText) findViewById(R.id.etLoginPassword);


        btLogin.setOnClickListener(this);
        btRegisterPg.setOnClickListener(this);
        btGuest.setOnClickListener(this);


        database = AppDatabase.getDatabase(getApplicationContext());
        database.userDao().removeAllUsers();
        database.userDao().addUser(new User(1, "admin", "admin"));

    }



    @Override
    public void onClick(View v) {

        loginPassword = etloginPassword.getText().toString();
        loginUsername = etloginUsername.getText().toString();
        boolean userfound = false;

        switch (v.getId()) {
            case R.id.btLogin:
                List<User> users = database.userDao().getAllUser();
                for(int i=0; i<users.size(); i++){
                    user = database.userDao().getAllUser().get(i);
                    usernameDatabase = user.name.toString();
                    passwordDatabase = user.password.toString();

                    if (loginPassword.equals(passwordDatabase) && loginUsername.equals(usernameDatabase)){
                        userfound = true;
                        Toast.makeText(MainActivity.this,
                                "Logged in as " + usernameDatabase + ", Welcome back!", Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(MainActivity.this, HomePageActivity.class);
                        MainActivity.this.startActivity(loginIntent);
                    }
                    else {
                        userfound = false;
                    }

                }
                if (userfound == false){
                    userNotFound();
                }
                break;

            case R.id.btRegisterPg:
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
                break;

            case R.id.btGuest:
                Intent guestIntent = new Intent(MainActivity.this, HomePageActivity.class);
                MainActivity.this.startActivity(guestIntent);
                break;
        }


    }
    public void userNotFound(){
            Toast.makeText(MainActivity.this,
                    "Login Failed, try agian", Toast.LENGTH_LONG).show();

    }

    public static class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

        @Override
        public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d("myistanceID", "Refreshed token: " + refreshedToken);

            // If you want to send messages to this application instance or
            // manage this apps subscriptions on the server side, send the
            // Instance ID token to your app server.
            //sendRegistrationToServer(refreshedToken);
        }
    }
}
