package edu.neu.madcourse.numad22summer_lipingding1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class AddLinkActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "edu.neu.madcourse.lipingding.EXTRA_NAME";
    public static final String EXTRA_URL = "edu.neu.madcourse.lipingding.EXTRA_URL";

    private EditText editTextName;
    private EditText editTextUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_link);

        editTextName = findViewById(R.id.text_name);
        editTextUrl = findViewById(R.id.text_url);

        setTitle("Add Link");
    }

    public void saveLink(View view) {
        String name = editTextName.getText().toString();
        String url = editTextUrl.getText().toString();

        if (name.trim().isEmpty() || url.trim().isEmpty()) {
            Snackbar.make(view, "Input invalid", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }
        if (!(url.trim().length() >= 7 && (url.trim().substring(0, 7).equals("http://") ||
                url.trim().substring(0, 7).equals("https:/")))) {
            url = "http://" + url.trim();
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_URL, url);
        setResult(RESULT_OK, data);
        finish();
    }
}
