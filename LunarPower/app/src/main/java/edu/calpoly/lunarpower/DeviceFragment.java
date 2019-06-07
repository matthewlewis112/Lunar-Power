package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.calpoly.lunarpower.model.DevicesDO;

public class DeviceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout view = (LinearLayout)inflater.inflate(R.layout.fragment_devices, container, false);
        final HomeActivity activity = (HomeActivity)getActivity();
        List<DevicesDO> devices = activity.getDevices();
        TextView textVal;

        for (DevicesDO d : devices) {
            textVal = new TextView(getActivity());
            textVal.setText(d.getName());
            textVal.setId(d.getName().hashCode());
            view.addView(textVal);
        }

        Button device = view.findViewById(R.id.lights);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.openFragment(new AddTaskFragment());
            }
        });

        return view;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
