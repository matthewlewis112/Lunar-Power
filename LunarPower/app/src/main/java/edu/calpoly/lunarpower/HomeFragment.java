package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.Date;


public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        Button getTasks = inflate.findViewById(R.id.get_tasks);
        final Date date = new Date();
        final CalendarView calendar = inflate.findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar tmp = Calendar.getInstance();
                tmp.set(Calendar.YEAR, year);
                tmp.set(Calendar.MONTH, month);
                tmp.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                date.setTime(tmp.getTimeInMillis());
            }
        });
        getTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskListFragment fragment = new TaskListFragment();
                fragment.setDate(date);
                ((HomeActivity)getActivity()).openFragment(fragment);
            }
        });
        return inflate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
