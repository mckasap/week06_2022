package com.example.week06_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

   public class myTask extends AsyncTask<String,Void,String>  {
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       public myTask() {
           super();
       }

       @Override
       protected void onCancelled(String s) {
           super.onCancelled(s);
       }

       @Override
       protected void onCancelled() {
           super.onCancelled();
       }

       @Override
       protected void onProgressUpdate(Void... values) {
           super.onProgressUpdate(values);
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);

           Log.d("TestAsyncTask",s);
       }

       @Override
        protected String doInBackground(String ... str) {

           StringBuilder sb= new StringBuilder("");
           URL url;
           HttpURLConnection con;

           try{
               url= new URL(str[0]);
               con = (HttpURLConnection) url.openConnection();
               InputStream is = con.getInputStream();
               InputStreamReader reader = new InputStreamReader(is);

               int data= reader.read();

               while(data!=-1){

               char c=(char)data;
               sb.append(c);

               data=reader.read();
               }


           }catch (Exception ex){

        return "Failed Because >>: "+ex.getMessage();

           }


           return sb.toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTask mt= new myTask();

        mt.execute("https://www.hepsiburada.com");
    }
}