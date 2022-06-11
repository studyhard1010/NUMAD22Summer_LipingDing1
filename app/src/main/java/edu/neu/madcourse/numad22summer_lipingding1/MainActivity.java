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
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Name: Liping Ding\n" +
                            "Email: studyhard1010@gmail.com", Toast.LENGTH_LONG).show();
                    openActivity2();
                }
            });
        }

        public void openActivity2() {
        Intent intent = new Intent(this, A5Activity2.class);
        startActivity(intent);
        }

        // trying to connect when the user click the Clicky Clicky button
        public void Clicky(View view) {
            // Do something in response to button
            Intent intent = new Intent(MainActivity.this, ClickyActivity.class);
            startActivity(intent);
        }

    //trying to connect when the user click the Link Connector button
        public void connectLink(View view) {
            // respond to button after starting activity
            Intent intent = new Intent(MainActivity.this, ConnectLinkActivity.class);
            startActivity(intent);
        }

}


