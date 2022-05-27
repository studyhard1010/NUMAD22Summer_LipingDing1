package edu.neu.madcourse.numad22summer_lipingding1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
        Button About;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            About = (Button) findViewById(R.id.buttonAbout);
            About.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Name: Liping Ding\n" +
                            "Email: studyhard1010@gmail.com", Toast.LENGTH_LONG).show();
                }
            });
        }

        /** Called when the user taps the Clicky Clicky button */
        public void Clicky(View view) {
            // Do something in response to button
            Intent intent = new Intent(MainActivity.this, ClickyActivity.class);
            startActivity(intent);
        }
}
