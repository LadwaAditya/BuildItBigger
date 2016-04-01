package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Created by Aditya on 01-Apr-16.
 */
public class BackendTest extends AndroidTestCase {
    public void testBackend() {
        EndpointsAsyncTask task = new EndpointsAsyncTask();

        String response = task.execute(new Pair<Context, String>(mContext, "Aditya")).toString();
        Log.d("TEST", response);

    }
}
