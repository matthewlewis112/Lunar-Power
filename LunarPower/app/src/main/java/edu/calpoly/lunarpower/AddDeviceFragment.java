package edu.calpoly.lunarpower;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AddDeviceFragment extends Fragment implements View.OnClickListener {

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_device,container,false);
        view.findViewById(R.id.submit).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment deviceFragment = new DeviceFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, deviceFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}