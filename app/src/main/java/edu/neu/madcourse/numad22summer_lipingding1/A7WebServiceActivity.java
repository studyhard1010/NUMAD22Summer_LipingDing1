package edu.neu.madcourse.numad22summer_lipingding1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class A7WebServiceActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Button buttonPing;
    TextView message;
    ProgressBar progressBar;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        buttonPing = (Button) findViewById(R.id.buttonPing);
        message = (TextView) findViewById(R.id.webServiceView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4.setOnCheckedChangeListener(this);
        checkBox5.setOnCheckedChangeListener(this);
        checkBox6.setOnCheckedChangeListener(this);
        checkBox7.setOnCheckedChangeListener(this);
        checkBox8.setOnCheckedChangeListener(this);
        checkBox9.setOnCheckedChangeListener(this);
        checkBox10.setOnCheckedChangeListener(this);

        buttonPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                if (checkBox1.isChecked()) {
                    id = "1";
                } else if (checkBox2.isChecked()) {
                    id = "2";
                } else if (checkBox3.isChecked()) {
                    id = "3";
                } else if (checkBox4.isChecked()) {
                    id = "4";
                } else if (checkBox5.isChecked()) {
                    id = "5";
                } else if (checkBox6.isChecked()) {
                    id = "6";
                } else if (checkBox7.isChecked()) {
                    id = "7";
                } else if (checkBox8.isChecked()) {
                    id = "8";
                } else if (checkBox9.isChecked()) {
                    id = "9";
                } else if (checkBox10.isChecked()) {
                    id = "10";
                } else {
                    id = "";
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AsyncHttpClient client = new AsyncHttpClient();
                String sUrl = "https://jsonplaceholder.typicode.com/users/" + id;
                client.get(sUrl, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String response = new String(responseBody);
                        progressBar.setVisibility(View.INVISIBLE);
                        message.setText(response);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        message.setText("Error in calling api! Cannot connect to the remote server.");
                    }
                });
            }
        });

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkBox1:
                if (checkBox1.isChecked()) {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox2:
                if (checkBox2.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox3:
                if (checkBox3.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox4:
                if (checkBox4.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox5:
                if (checkBox5.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox6:
                if (checkBox6.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox7:
                if (checkBox7.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox8:
                if (checkBox8.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox9.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox9:
                if (checkBox9.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox10.setChecked(false);
                }
                break;
            case R.id.checkBox10:
                if (checkBox10.isChecked()) {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                    checkBox5.setChecked(false);
                    checkBox6.setChecked(false);
                    checkBox7.setChecked(false);
                    checkBox8.setChecked(false);
                    checkBox9.setChecked(false);
                }
                break;
            default:
                break;
        }
    }
}