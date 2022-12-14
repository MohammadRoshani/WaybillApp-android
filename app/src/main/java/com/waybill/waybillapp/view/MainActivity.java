package com.waybill.waybillapp.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.waybill.waybillapp.R;
import com.waybill.waybillapp.model.Message;
import com.waybill.waybillapp.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.onPullingMessage();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);


        mainActivityViewModel.getAllMessages().observe(this, messages -> {
            for (Message m : messages) {
                Log.i(TAG, m.toString());
            }
        });


        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
