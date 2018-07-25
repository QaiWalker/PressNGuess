package com.example.qaite.pressnguess;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class InstrumentsActivity extends AppCompatActivity {

    ListView lvInstruments;
    InstrumentAdapter ia;
    ArrayList<Integer> imageIDs;
    ArrayList<String> nameList;
    MediaPlayer mp        = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments);
        lvInstruments = findViewById(R.id.lvInstruments);
        imageIDs = new ArrayList<>();
        nameList = new ArrayList<>();
        imageIDs = getList();
        nameList = getNameList();
        ia = new InstrumentAdapter(InstrumentsActivity.this, imageIDs, nameList);
        lvInstruments.setAdapter(ia);
        lvInstruments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                managerOfSound(nameList.get(position));
            }
        });

    }

    public ArrayList<Integer>getList(){
        imageIDs = new ArrayList<>();
        imageIDs.add(R.drawable.clarinet);
        imageIDs.add(R.drawable.drum);
        imageIDs.add(R.drawable.horn);
        imageIDs.add(R.drawable.saxophone);
        imageIDs.add(R.drawable.trumpet);
        imageIDs.add(R.drawable.tuba);
        imageIDs.add(R.drawable.flute);
        return imageIDs;
    }

    public ArrayList<String> getNameList() {
        nameList = new ArrayList<>();
        nameList.add("Clarinet");
        nameList.add("Drum");
        nameList.add("French Horn");
        nameList.add("Saxophone");
        nameList.add("Trumpet");
        nameList.add("Tuba");
        nameList.add("Flute");
        return nameList;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent intent = new Intent(InstrumentsActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.instrumentSound){
            Intent intent = new Intent(InstrumentsActivity.this, InstrumentsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    protected void managerOfSound(String pos) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        if (pos == "Clarinet") {
            mp = MediaPlayer.create(this, R.raw.clarinet);
        } else if (pos == "Flute") {
            mp = MediaPlayer.create(this, R.raw.flute);
        } else if (pos == "Saxophone"){
            mp = MediaPlayer.create(this, R.raw.saxophone);
        } else if (pos == "French Horn"){
            mp = MediaPlayer.create(this, R.raw.frenchhorn);
        } else if (pos == "Tuba"){
            mp = MediaPlayer.create(this, R.raw.tuba);
        }else if (pos == "Trumpet"){
            mp = MediaPlayer.create(this, R.raw.trumpet);
        }else if (pos == "Drum"){
            mp = MediaPlayer.create(this, R.raw.drum);
        }

        mp.start();
    }

}
