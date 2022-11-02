package com.example.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ScrollView;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ScrollView scrollView = new ScrollView(this);
//        scrollView.addView(listView);
//        setContentView(scrollView);
    }

    SimpleAdapter ad;
    public void GetData(View v)
    {

        listView = findViewById(R.id.listview);
        List<Map<String,String>> MyDataList = null;
        ListItem MyData = new ListItem();
        MyDataList = MyData.getlist();

        String[] Fromw = {"txtID", "txtTitle", "txtAuthor", "txtGenre", "txtImage"};
        int[] Tow = {R.id.txtID,R.id.txtTitle,R.id.txtAuthor,R.id.txtGenre, R.id.txtImage};
        ad = new SimpleAdapter(MainActivity.this,MyDataList,R.layout.listlayouttemplate,Fromw,Tow);
        listView.setAdapter(ad);
    }


}
