package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetTextFromSql(View v)
    {
        TextView ID = findViewById(R.id.txtID);
        TextView Title = findViewById(R.id.txtTitle);
        TextView Author = findViewById(R.id.txtAuthor);
        TextView Genre = findViewById(R.id.txtGenre);
        TextView Publication_data = findViewById(R.id.txtPublication_data);


        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = ConnectionHelper.connectionClass();

            if(connection!=null) {
                String query = "Select * From Library";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    ID.setText(resultSet.getString(1));
                    Title.setText(resultSet.getString(2));
                    Author.setText(resultSet.getString(3));
                    Genre.setText(resultSet.getString(4));
                    Publication_data.setText(resultSet.getString(5));
                }
            }
            else {
                ConnectionResult = "Check Connection";
            }

        }
        catch (Exception ex)
        {


        }
    }
}
