package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.aditya.myapplication.backend.myApi.MyApi;
import com.example.jokeandroid.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * From google Source
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private TaskListner mlistner = null;


    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1268.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];


        try {
            return myApiService.sayHi("Aditya Ladwa").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (null != mlistner)
            this.mlistner.getTaskResult(result);
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        context.startActivity(intent);
    }


    public interface TaskListner {
        void getTaskResult(String result);
    }

    public EndpointsAsyncTask setListner(TaskListner listner) {
        this.mlistner = listner;
        return this;
    }


}
