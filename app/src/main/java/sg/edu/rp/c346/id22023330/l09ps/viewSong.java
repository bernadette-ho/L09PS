package sg.edu.rp.c346.id22023330.l09ps;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class viewSong extends AppCompatActivity {
    ListView lv;
    ArrayList<ArrayList<Song>> songList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        songList = new ArrayList<ArrayList<Song>>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,songList);
        lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        DBHelper db = new DBHelper(this);

        //populate arraylist of Song objects
        ArrayList<Song> objectList = db.getSongContent();
        songList.add(objectList);
        adapter.notifyDataSetChanged();
    }

}