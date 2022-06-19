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
import android.location.Location;

public class MainActivity extends AppCompatActivity {
        private Button button;
        private Button locationBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button = findViewById(R.id.button);
            locationBtn = findViewById(R.id.buttonLocation);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity2();
                }
            });

            locationBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openLocationActivity();
                }
            });
        }

        public void openActivity2() {
        Intent intent = new Intent(this, A5Activity2.class);
        startActivity(intent);
        }

    public void openLocationActivity() {
        Intent intent = new Intent(this, A6LocationActivity.class);
        startActivity(intent);
    }
}


