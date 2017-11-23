package com.ibrahim.mohammad.soccerworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import 	android.widget.ImageView;
import android.view.View.OnClickListener;

public class PreferenceActivity extends AppCompatActivity implements OnClickListener{


    private TextView tvUsername;
    public Button btNext;
    public Button btPrev;
    public Button btSelect;
    private TextView tvEpl;
    private TextView tvLaliga;
    private TextView tvBundesliga;
    private TextView tvSeriaA;
    private TextView tvLg1;
    private String current = "epl";
    private String userSelection;
    private ImageView starOn;
    private ImageView starOff;
    private String[] leagueSelections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        String username = intent.getExtras().getString("usernameInput");
        username = "Welcome, " + username;
        tvUsername.setText(username);

        tvEpl = (TextView) findViewById(R.id.tvEpl);
        tvLaliga = (TextView) findViewById(R.id.tvLaLiga);
        tvBundesliga = (TextView) findViewById(R.id.tvBundesliga);
        tvSeriaA = (TextView) findViewById(R.id.tvSeriaA);
        tvLg1 = (TextView) findViewById(R.id.tvLigueOne);

        starOn = (ImageView) findViewById(R.id.selectStarOn);
        starOff = (ImageView) findViewById(R.id.selectStarOff);

        btNext = (Button) findViewById(R.id.btNext);
        btPrev = (Button) findViewById(R.id.btPrev);
        btSelect = (Button) findViewById(R.id.btSelectFavLg);

        btNext.setOnClickListener(this);
        btPrev.setOnClickListener(this);
        btSelect.setOnClickListener(this);


        leagueSelections = new String[4];


    }

    @Override
    public void onClick(View v) {

        if (v == btSelect){
            for(int i=0; i<4; i++){
                leagueSelections[i] = current;
            }
            starOn.setVisibility(View.VISIBLE);
            starOff.setVisibility(View.INVISIBLE);

        }

        if (v == btNext){
            switch(current) {
                case "epl":
                    tvEpl.setVisibility(View.INVISIBLE);
                    tvLaliga.setVisibility(View.VISIBLE);
                    current = "laliga";
                break;
                case "laliga":
                    tvLaliga.setVisibility(View.INVISIBLE);
                    tvBundesliga.setVisibility(View.VISIBLE);
                    current = "bundesliga";
                    break;
                case "bundesliga":
                    tvBundesliga.setVisibility(View.INVISIBLE);
                    tvSeriaA.setVisibility(View.VISIBLE);
                    current = "seriaa";
                    break;
                case "seriaa":
                    tvSeriaA.setVisibility(View.INVISIBLE);
                    tvLg1.setVisibility(View.VISIBLE);
                    current = "lg1";
                    break;
                case "lg1":
                    tvLg1.setVisibility(View.INVISIBLE);
                    tvEpl.setVisibility(View.VISIBLE);
                    current = "epl";
                    break;

            }
        }

        if (v == btPrev){
            switch(current) {
                case "epl":
                    tvEpl.setVisibility(View.INVISIBLE);
                    tvLg1.setVisibility(View.VISIBLE);
                    current = "lg1";
                    break;
                case "lg1":
                    tvLg1.setVisibility(View.INVISIBLE);
                    tvSeriaA.setVisibility(View.VISIBLE);
                    current = "seriaa";
                    break;
                case "seriaa":
                    tvSeriaA.setVisibility(View.INVISIBLE);
                    tvBundesliga.setVisibility(View.VISIBLE);
                    current = "bundesliga";
                    break;
                case "bundesliga":
                    tvBundesliga.setVisibility(View.INVISIBLE);
                    tvLaliga.setVisibility(View.VISIBLE);
                    current = "laliga";
                    break;
                case "laliga":
                    tvLaliga.setVisibility(View.INVISIBLE);
                    tvEpl.setVisibility(View.VISIBLE);
                    current = "epl";
                    break;

            }
        }

        }
}
