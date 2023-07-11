package sg.edu.rp.c346.id22023330.l09ps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    Button back;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Song> arrList;
    Button btnShowAll;
    RadioGroup rating;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        back = findViewById(R.id.button3);
        lv = findViewById(R.id.lv);
        btnShowAll = findViewById(R.id.btnShowAll);
        rating = findViewById(R.id.radioGroup);

        DBHelper db = new DBHelper(list.this);
        db.close();
        DBHelper lvdb = new DBHelper(list.this);
        arrList = lvdb.getSongContent();
        lvdb.close();
        aa = new ArrayAdapter(list.this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(aa);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(list.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ) {
                Song data = arrList.get(position);
                Intent i = new Intent(list.this, thirdActivity.class);
                i.putExtra("song", (CharSequence) data);
                startActivity(i);
            }
        });

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ratingID = rating.getCheckedRadioButtonId();
                String star = "";
                if(ratingID == R.id.radioButton){
                    star = "1";
                }else if(ratingID == R.id.radioButton2){
                    star = "2";
                }else if(ratingID == R.id.radioButton3){
                    star = "3";
                }else if(ratingID == R.id.radioButton4){
                    star = "4";
                }else{
                    star = "5";
                }

                for (Song value : arrList) {
                    if (value.getRating() == 5) {
                        System.out.println(value);
                    }
                }
            }
        });


    }
}