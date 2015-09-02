package com.coder4.easyufwandroid;

import android.app.usage.UsageEvents;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.coder4.easyufwandroid.event.NavigationDrawerClickEvent;
import com.coder4.easyufwandroid.fragment.NavigationDrawerFragment;

import de.greenrobot.event.EventBus;

public class HomeActivity extends AppCompatActivity implements
        NavigationDrawerFragment.OnFragmentInteractionListener {

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // unregister event bus
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(NavigationDrawerClickEvent event) {
        Toast.makeText(this, event.getPosition() + " clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
