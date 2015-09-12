package com.coder4.easyufwandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.coder4.easyufwandroid.R;

public class LoginFragment extends Fragment implements Button.OnClickListener {

    private Button loginButton;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }else{

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        loginButton = (Button) v.findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                login();
                break;
            default:
                break;
        }
    }

    private void login(){
        if(checkLogin()){
            // login success
            getFragmentManager().popBackStack();
            Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkLogin(){
        // Mock as true
        return true;
    }
}
