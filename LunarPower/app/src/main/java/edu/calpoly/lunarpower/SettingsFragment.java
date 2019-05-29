package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazonaws.mobile.auth.core.IdentityManager;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        Button logoutBtn = (Button) rootView.findViewById(R.id.logout);
        logoutBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("Settings","Logging Out");
                IdentityManager.getDefaultIdentityManager().signOut();
            }
        });
        return inflater.inflate(R.layout.fragment_settings,container,false);
    }
}
