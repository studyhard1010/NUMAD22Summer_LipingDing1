package edu.neu.madcourse.numad22summer_lipingding1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ConnectLinkActivity extends AppCompatActivity {
    public static final int ADD_LINK_REQUEST = 1;
    private ArrayList<LinkItem> linksList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter Adapter;
    private ItemClickListener itemClickListener;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_link);

        linksList = new ArrayList<>();

        initialItemData(savedInstanceState);

        itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String link = linksList.get(position).getUrl();
                Uri uri = Uri.parse(link);
                Intent intent= new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        };
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Adapter = new Adapter(linksList, itemClickListener);
        recyclerView.setAdapter(Adapter);

        Adapter.setOnItemClickListener(itemClickListener);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConnectLinkActivity.this, AddLinkActivity.class);
                startActivityForResult(intent, ADD_LINK_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_LINK_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(AddLinkActivity.EXTRA_NAME);
            String url = data.getStringExtra(AddLinkActivity.EXTRA_URL);

            LinkItem linkItem = new LinkItem(name, url);
            linksList.add(linkItem);
            Snackbar.make(findViewById(R.id.recyclerView), "Link saved!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        } else {
            Snackbar.make(findViewById(R.id.recyclerView), "Link not saved!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        int size = linksList == null ? 0 : linksList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        // Create each item's unique key
        for (int i = 0; i < size; i++) {
            // generate instance of name information id
            outState.putString(KEY_OF_INSTANCE + i + "0", linksList.get(i).getName());
            // generate instance information
            outState.putString(KEY_OF_INSTANCE + i + "1", linksList.get(i).getUrl());
        }
        super.onSaveInstanceState(outState);
    }

    private void initialItemData(Bundle savedInstanceState) {

        // Not the initial activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (linksList == null || linksList.size() == 0) {

                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);
                // Retrieve instance stored keys
                for (int i = 0; i < size; i++) {
                    String name = savedInstanceState.getString(KEY_OF_INSTANCE + i + "0");
                    String url = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    LinkItem itemCard = new LinkItem(name, url);

                    linksList.add(itemCard);
                }
            }
        }
    }
}
