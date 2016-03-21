package bingo.notes.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import bingo.notes.R;
import bingo.notes.ui.detail.DetailActivity;
import bingo.notes.ui.main.adapter.NotesAdapter;
import bingo.notes.data.entity.pojo.Message;

public class MainActivity extends AppCompatActivity {

    private List<Message> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NotesAdapter(initData()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });
    }

    private List<Message> initData() {
        list = new ArrayList<>();
        list.add(new Message("Like", "Very cool!", R.mipmap.ic_s, R.string.like));
        list.add(new Message("Error", "try again!", R.mipmap.ic_s, R.string.error));
        list.add(new Message("Complete", "well down!", R.mipmap.ic_s, R.string.complete));
        list.add(new Message("Like", "Very cool!", R.mipmap.ic_s, R.string.like));
        list.add(new Message("Error", "try again!", R.mipmap.ic_s, R.string.error));
        list.add(new Message("Complete", "well down!", R.mipmap.ic_s, R.string.complete));
        list.add(new Message("Like", "Very cool!", R.mipmap.ic_s, R.string.like));
        list.add(new Message("Error", "try again!", R.mipmap.ic_s, R.string.error));
        list.add(new Message("Complete", "well down!", R.mipmap.ic_s, R.string.complete));
        return list;
    }
}