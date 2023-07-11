package sg.edu.rp.c346.id22023330.l09ps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class thirdActivity extends AppCompatActivity {

    EditText ET1, ET2, ET3;
    Button btnUpdate, btnDel, btnCancel;
    RadioGroup rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

        ET1 = findViewById(R.id.ET1);
        ET2 = findViewById(R.id.ET2);
        ET3 = findViewById(R.id.ET3);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDel = findViewById(R.id.btnDel);
        btnCancel = findViewById(R.id.button);
        rating = findViewById(R.id.radioGroup);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ET1.getText().toString();

                // Retrieve song details from the database based on the ID
                Object id = null;
                Object dbHelper = null;
                Song song = dbHelper.getSongById(id);
                if (song != null) {
                    // Display the retrieved song details
                    String songName = song.getTitle();
                    String singer = song.getSinger();
                    int year = song.getYear();
                    String star = song.getStars();
                    // You can update other UI elements with the retrieved data as needed

                    // For example, if you have a TextView to display the song name:
                    ET1.setText(songName);
                    ET2.setText(singer);
                    ET3.setText(year);
                    if (star.equals("1")) {
                        rating.check(R.id.radioButton1);
                    } else if (star.equals("2")) {
                        rating.check(R.id.radioButton2);
                    } else if (star.equals("3")) {
                        rating.check(R.id.radioButton3);
                    } else if (star.equals("4")) {
                        rating.check(R.id.radioButton4);
                    } else if (star.equals("5")) {
                        rating.check(R.id.radioButton5);
                    }
                }
            }
        });
    }

}