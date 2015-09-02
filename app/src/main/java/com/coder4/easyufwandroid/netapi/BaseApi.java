package com.coder4.easyufwandroid.netapi;

import com.android.volley.Request;

/**
 * Created by lihy on 15/9/2.
 */
public class BaseApi {
    // record caller name
    private IVolleyCaller caller;

    private VolleyWrapper volleyWrapper;

    public BaseApi(IVolleyCaller obj){
        caller = obj;
        volleyWrapper = VolleyWrapper.getInstance();
    }

    private void addToQueueByTag(Request<?> request, boolean needTag){
        if(needTag) {
            volleyWrapper.addToQueue(request, caller.getVolleyTagName());
        }else{
            volleyWrapper.addToQueue(request, null);
        }
    }

    public void cancelAll(){
        caller.cancelAllVolleyRequest();
    }
}
