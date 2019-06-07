package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amazonaws.mobile.auth.core.IdentityManager;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        Button logoutBtn = rootView.findViewById(R.id.logout);
        logoutBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("Settings","Logging Out");
                IdentityManager.getDefaultIdentityManager().signOut();
                getActivity().finishAndRemoveTask();
            }
        });
        return rootView;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
