package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by Aditya on 01-Apr-16.
 */
public class BackendTest extends AndroidTestCase {
    private String joke;

    public void testBackend() throws ExecutionException, InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListner(new EndpointsAsyncTask.TaskListner() {
            @Override
            public void getTaskResult(String result) {
                joke = result;
            }
        }).execute(mContext).get();

        assertTrue(joke, joke.length() > 0);
    }
}
