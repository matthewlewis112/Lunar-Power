package edu.calpoly.lunarpower;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.LinkedList;
import java.util.List;

import edu.calpoly.lunarpower.model.DevicesDO;

public class HomeActivity extends AppCompatActivity {

    private DynamoDBMapper dynamoDBMapper;

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
                } else if (menuItem.getItemId() == R.id.nav_settings) {
                    openFragment(new SettingsFragment());
                    return true;
                }
                return false;
            }
        });

        AWSCredentialsProvider credentialsProvider = AWSMobileClient.getInstance().getCredentialsProvider();
        AWSConfiguration configuration = AWSMobileClient.getInstance().getConfiguration();

        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);

        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(configuration)
                .build();

    }

    public DynamoDBMapper getDynamoDBMapper() {
        return dynamoDBMapper;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public List<DevicesDO> getDevices() {
        Log.d("Home Activity", "Devices got?");
        final LinkedList<DevicesDO> devices = new LinkedList<>();
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    devices.add(dynamoDBMapper.load(DevicesDO.class, "Name"));
                }
                Log.d("Home Activity", "Returned devices");
            }
        };

        new Thread(runnable).start();
        return devices;
    }

    public void addDevice(View view) {
        openFragment(new AddDeviceFragment());
    }
    public void submitInfo(View view) {
        DevicesDO device = new DevicesDO();
        EditText name = findViewById(R.id.deviceNameInput);
        device.setName(
            name.getText().toString()
        );
        EditText id = findViewById(R.id.deviceIDInput);
        device.setID(
                Double.parseDouble(id.getText().toString())
        );

        device.setUserId("Tester");
        dynamoDBMapper.save(device);
        openFragment(new DeviceFragment());
    }
}