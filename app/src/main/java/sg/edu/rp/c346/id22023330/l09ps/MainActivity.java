package sg.edu.rp.c346.id22023330.l09ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button insert, show;
    EditText sTitle, singers, yor;
    RadioGroup rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.btnUpdate);
        show = findViewById(R.id.btnDel);
        sTitle = findViewById(R.id.ET1);
        singers = findViewById(R.id.ET2);
        yor = findViewById(R.id.ET3);
        rating = findViewById(R.id.radioGroup);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
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
                db.insertSong(sTitle.getText().toString(), singers.getText().toString(), Integer.parseInt(yor.getText().toString()), star);
                db.close();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, list.class);
                startActivity(intent);
            }
        });

    }
}