package com.example.randomapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ImageView love;
    boolean React_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (loadState() == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setTheme(R.style.Theme_AppCompat_DayNight);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setTheme(R.style.Theme_AppCompat_DayNight);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        love = findViewById(R.id.favorite);
        love.setImageResource(isLove() ? R.drawable.ic_baseline_favorite_24 : R.drawable.ic_baseline_favorite_border_24);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (React_love == false) {
                    setLove(!isLove());
                    love.setImageResource(isLove() ? R.drawable.ic_baseline_favorite_24 : R.drawable.ic_baseline_favorite_border_24);
                } else
                    setLove(!isLove());
                love.setImageResource(isLove() ? R.drawable.ic_baseline_favorite_24 : R.drawable.ic_baseline_favorite_border_24);
            }
        });

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMylist());
        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMylist() {
        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setTitle("AirPods");
        m.setPost(R.drawable.airpods);
        m.setImg(R.drawable.appl);
        models.add(m);
        m = new Model();
        m.setTitle("Android");
        m.setPost(R.drawable.and);
        m.setImg(R.drawable.profand);
        models.add(m);
        m = new Model();
        m.setTitle("Appl");
        m.setPost(R.drawable.apple);
        m.setImg(R.drawable.ap);
        models.add(m);
        m = new Model();
        m.setTitle("HeadPhon");
        m.setPost(R.drawable.hp);
        m.setImg(R.drawable.hp);
        models.add(m);
        m = new Model();
        m.setTitle("watch");
        m.setPost(R.drawable.wach);
        m.setImg(R.drawable.ap);
        models.add(m);
        m = new Model();
        m.setTitle("Appl");
        m.setPost(R.drawable.apple);
        m.setImg(R.drawable.ap);
        models.add(m);
        m = new Model();
        m.setTitle("HeadPhon");
        m.setPost(R.drawable.hp);
        m.setImg(R.drawable.hp);
        models.add(m);
        m = new Model();
        m.setTitle("watch");
        m.setPost(R.drawable.wach);
        m.setImg(R.drawable.ap);
        models.add(m);
        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item  =menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.theme:
                item.setActionView(R.layout.them_switch);
                final Switch themeSwitch = (Switch) item.getActionView().findViewById(R.id.action_switch);
                if (loadState() == true) {
                    themeSwitch.setChecked(true);
                }
                themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            saveState(true);
                            recreate();
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            saveState(false);
                        }
                    }
                });
                break;
        }
        return true;
    }


    private void saveState(Boolean state) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mode", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("NightMode", state);
        editor.apply();
    }

    private Boolean loadState() {
        SharedPreferences sharedPreferences = getSharedPreferences("Mode", MODE_PRIVATE);
        Boolean state = sharedPreferences.getBoolean("NightMode", false);
        return state;
    }

    public boolean isLove() {
        return React_love;
    }

    public void setLove(boolean love) {
        React_love = love;
    }
}