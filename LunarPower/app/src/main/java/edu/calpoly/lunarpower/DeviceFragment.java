package edu.calpoly.lunarpower;

import java.util.LinkedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import edu.calpoly.lunarpower.model.*;

import static edu.calpoly.lunarpower.HomeActivity.*;

public class DeviceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout view = (LinearLayout)inflater.inflate(R.layout.fragment_devices, container, false);
        HomeActivity activity = (HomeActivity)getActivity();
        LinkedList<DevicesDO> devices = activity.getDevices();
        TextView textVal;

        for (DevicesDO d : devices) {
            textVal = new TextView(getActivity());
            textVal.setText(d.getName());
            textVal.setId(d.getName().hashCode());
            view.addView(textVal);
        }

        return inflater.inflate(R.layout.fragment_devices,container,false);
    }
}
