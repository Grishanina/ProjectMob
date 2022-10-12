package com.example.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btn2;

    Connection connection;
    String ConnectionResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    SimpleAdapter ad;
    public void GetData(View v)
    {

        listView = findViewById(R.id.listview);
        List<Map<String,String>> MyDataList = null;
        ListItem MyData = new ListItem();
        MyDataList = MyData.getlist();

        String[] Fromw = {"txtID", "txtTitle", "txtAuthor", "txtGenre", "txtPublication_data"};
        int[] Tow = {R.id.txtID,R.id.txtTitle,R.id.txtAuthor,R.id.txtGenre};
        ad = new SimpleAdapter(MainActivity.this,MyDataList,R.layout.listlayouttemplate,Fromw,Tow);
        listView.setAdapter(ad);
    }

    public void OnClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn2:
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ActivityTwo.class);
            startActivity(intent);
                break;
            default:
                break;
        }


    }

}
