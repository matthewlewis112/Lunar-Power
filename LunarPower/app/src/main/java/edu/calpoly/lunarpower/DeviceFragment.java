package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class DeviceFragment extends Fragment {

    ScrollView devicesList;
    List list = new ArrayList();
    ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_devices,container,false);

        ScrollView devicesList = view.findViewById(R.id.devicesList);

        list.add("orange");
        list.add("apple");
        list.add("banana");
        list.add("grape");
        list.add("pineapple");
        list.add("pomegranate");
        list.add("apricot");
        list.add("cherry");



        return view;
    }
}
