package com.ibrahim.mohammad.soccerworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageActivity extends AppCompatActivity implements OnClickListener{
    public Button btLaliga;
    public Button btEpl;
    public Button btTxt;
    public Button btEml;
    private String[] fruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btLaliga = (Button) findViewById(R.id.btLaliga);
        btLaliga.setOnClickListener(this);
        btEpl = (Button) findViewById(R.id.btEpl);
        btEpl.setOnClickListener(this);
        btTxt = (Button) findViewById(R.id.btTxt);
        btTxt.setOnClickListener(this);
        btEml = (Button) findViewById(R.id.btEml);
        btEml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btLaliga){
            final ListView lv = (ListView) findViewById(R.id.lvMatches);
            fruits = new String[]{"Barcelona 3 - 0 Real Madrid", "Atlético Madrid 2 - 1 Celta Vigo", "Alavés 1 - 1 Espanyol", "Eibar 2 - 2 Deportivo", "Athletic Bilbao 1 - 0 Málaga", "Sevilla 2 - 4 Valencia",
                    "Barcelona 3 - 0 Real Madrid", "Atlético Madrid 2 - 1 Celta Vigo", "Alavés 1 - 1 Espanyol", "Eibar 2 - 2 Deportivo", "Athletic Bilbao 1 - 0 Málaga"};
            final List<String> laligalist = new ArrayList<String>(Arrays.asList(fruits));
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, laligalist);
            lv.setAdapter(arrayAdapter);
        }
        if (v == btEpl){
            final ListView lv = (ListView) findViewById(R.id.lvMatches);
            fruits = new String[]{"Manchester United 3 - 2 chelsea", "Tottenham 0 - 1 Everton", "Southampton 2 - 1 Watford", "Liverpool 4 - 0 Bournemouth", "Leicester City 0 - 0 Stoke City", "Manchester City 2 - 0 Arsenal",
                    "Manchester United 3 - 2 chelsea", "Tottenham 0 - 1 Everton", "Southampton 2 - 1 Watford", "Liverpool 4 - 0 Bournemouth", "Leicester City 0 - 0 Stoke City", "Manchester City 2 - 0 Arsenal"};
            final List<String> laligalist = new ArrayList<String>(Arrays.asList(fruits));
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, laligalist);
            lv.setAdapter(arrayAdapter);
        }
        if (v == btTxt){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Manchester United 3 - 2 chelsea");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        if (v == btEml) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "");
            emailIntent.putExtra(Intent.EXTRA_CC, "");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Match Results");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Manchester United 3 - 2 chelsea");
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        }

    }
}
