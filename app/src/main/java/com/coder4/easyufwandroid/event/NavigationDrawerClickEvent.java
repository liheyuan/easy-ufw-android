package com.coder4.easyufwandroid.event;

/**
 * Created by lihy on 15/9/2.
 */
public class NavigationDrawerClickEvent {
    private int position;

    public NavigationDrawerClickEvent(int pos){
        position = pos;
    }

    public int getPosition(){
        return position;
    }
}
