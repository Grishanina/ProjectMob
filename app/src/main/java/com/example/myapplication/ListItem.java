package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem {

    Connection connect;
    String ConnectionResult="";
    Boolean isSuucess=false;

    public List<Map<String,String>>getlist()
    {
        List<Map<String,String>> data;
        data = new ArrayList<Map<String,String>>();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = ConnectionHelper.connectionClass();
            if(connect != null) {
                String qu = "Select * From Library";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next()) {
                    Map<String, String> btname = new HashMap<String, String>();
                    btname.put("txtID", resultSet.getString("ID"));
                    btname.put("txtTitle", resultSet.getString("Title"));
                    btname.put("txtAuthor", resultSet.getString("Author"));
                    btname.put("txtGenre", resultSet.getString("Genre"));
                    btname.put("txtImage", resultSet.getString("Image"));
                    data.add(btname);
                }
                ConnectionResult = "Success";
                isSuucess = true;
                connect.close();
            }
            else{
                ConnectionResult = "Failed";
            }


        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return data;
    }
}
