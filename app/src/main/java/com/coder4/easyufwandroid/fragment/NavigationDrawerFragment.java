package com.coder4.easyufwandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coder4.easyufwandroid.R;
import com.coder4.easyufwandroid.adapter.NavigationDrawerAdapter;
import com.coder4.easyufwandroid.event.NavigationDrawerClickEvent;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link NavigationDrawerFragment.OnFragmentInteractionListener} interface to handle interaction
 * events. Use the {@link NavigationDrawerFragment#newInstance} factory method to create an instance
 * of this fragment.
 */
public class NavigationDrawerFragment extends Fragment {

    private View containerView;

    private ListView drawerListView;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public void setUpDrawer(int fragmentId, DrawerLayout dl) {
        // container view
        containerView = getActivity().findViewById(fragmentId);
        // drawer layout
        drawerLayout = dl;

        // set up drawer toggle
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, true,
                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        drawerListView = (ListView) inflater.inflate(R.layout.fragment_navigation_drawer,
                container, false);
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
        drawerListView.setAdapter(new NavigationDrawerAdapter(getActivity()));

        return drawerListView;
    }

    private void selectItem(int position) {
        EventBus.getDefault().post(new NavigationDrawerClickEvent(position));
        // close drawer
        drawerLayout.closeDrawers();
    }

}
