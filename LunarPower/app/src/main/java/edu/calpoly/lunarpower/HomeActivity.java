package edu.calpoly.lunarpower;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        openFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_home) {
                    openFragment(new HomeFragment());
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_history) {
                    openFragment(new HistoryFragment());
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_devices) {
                    openFragment(new DeviceFragment());
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_history) {
                    openFragment(new SettingsFragment());
                    return true;
                }
                return false;
            }
        });

    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
