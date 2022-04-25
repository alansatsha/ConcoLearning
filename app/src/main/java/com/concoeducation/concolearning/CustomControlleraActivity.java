package com.concoeducation.concolearning;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.concoeducation.concolearning.databinding.CustomControlleraBinding;

public class CustomControlleraActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private CustomControlleraBinding binding;


    private RelativeLayout mllll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CustomControlleraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        mllll = findViewById(R.id.vvvvv);

        Toast.makeText(getApplicationContext(), " da sd as da das dad as", Toast.LENGTH_SHORT).show();
    }


    public void mlllo(View view)
    {
        ViewGroup.LayoutParams uuui = new ViewGroup.LayoutParams(mllll.getLayoutParams());

        uuui.height = 1500;

        mllll.setLayoutParams(uuui);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}