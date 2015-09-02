package com.coder4.easyufwandroid.netapi;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by lihy on 15/9/2.
 */
public class VolleyWrapper {
    // singleton
    public static VolleyWrapper instance;

    private static final String LOG_TAG = VolleyWrapper.class.getSimpleName();

    // volley request queue
    private RequestQueue requestQueue;

    private VolleyWrapper(Context ctx) {
        requestQueue = Volley.newRequestQueue(ctx);
    }

    public static VolleyWrapper getInstance(){
        return instance;
    }

    public static void init(Context ctx) {
        if (instance == null) {
            instance = new VolleyWrapper(ctx);
        }
    }

    public void addToQueue(Request<?> request, String tag) {
        if (tag != null) {
            request.setTag(tag);
        }
        Log.i(LOG_TAG, "addToQueue: " + tag);
        requestQueue.add(request);
    }

    public void cancelByTag(String tag) {
        if (tag != null) {
            requestQueue.cancelAll(tag);
            Log.i(LOG_TAG, "cancelByTag: " + tag);
        }
    }
}
