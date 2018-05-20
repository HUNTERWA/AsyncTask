package com.ats.rohit.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CheckConnectionStatus extends AsyncTask<String,Void,String>
{

    @Override
    protected String doInBackground(String... strings)
    {
        URL url=null;

        try
        {
            url=new URL("https://www.google.com/");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            Log.d("errorIsInMalformed",e.getMessage());
        }

        try
        {
            HttpsURLConnection httpsURLConnection= (HttpsURLConnection) url.openConnection();
            Log.d("responseIs",""+httpsURLConnection.getResponseMessage()+"\n"+httpsURLConnection.getResponseCode());
            return String.valueOf(httpsURLConnection.getResponseCode());
        } catch (IOException e)
        {
            e.printStackTrace();
            Log.d("errorIsInIoException",e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Log.d("I am from","Post execute");
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.d("I am from","Pre execute");
    }
}
