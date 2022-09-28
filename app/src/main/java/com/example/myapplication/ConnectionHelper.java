package com.example.myapplication;

import java.sql.DriverManager;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import android.annotation.SuppressLint;


public class ConnectionHelper {

    private static String ip;
    private static String dataBase;
    private static String userPassword;
    private static String userName;
    private static String port;

    @SuppressLint("NewApi")
    public static Connection connectionClass()
    {
        ip = "ngknn.ru";
        dataBase = "Project_Biblioteka";
        userPassword = "12357";
        userName = "31П";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection = null;
        String connectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databasename=" + dataBase + ";user=" + userName + ";password=" + userPassword + ";";
            connection = DriverManager.getConnection(connectionURL);
        }
        catch (Exception ex)
        {
            Log.e("Error",ex.getMessage());
        }
        return connection;
    }
}


