package com.coder4.easyufwandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.coder4.easyufwandroid.R;
import com.coder4.easyufwandroid.event.NavigationDrawerClickEvent;
import com.coder4.easyufwandroid.fragment.HomeFragment;
import com.coder4.easyufwandroid.fragment.LoginFragment;
import com.coder4.easyufwandroid.fragment.NavigationDrawerFragment;

import de.greenrobot.event.EventBus;

public class HomeActivity extends AppCompatActivity {

    NavigationDrawerFragment navigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(
                R.id.navigation_drawer);
        navigationDrawerFragment.setUpDrawer(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        // register event bus
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // unregister event bus
        EventBus.getDefault().unregister(this);
    }

    // Response when Click on NavigationDrawer
    public void onEventMainThread(NavigationDrawerClickEvent event) {
        Toast.makeText(this, event.getPosition() + " clicked", Toast.LENGTH_LONG).show();
        switch(event.getPosition()){
            case 0:
                break;
            case 1:
                break;
            case 2:
                // 登录
                LoginFragment fragment = new LoginFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.layout_main, fragment).addToBackStack(null).commit();
                break;
            case 3:
                break;
        }
    }
}
