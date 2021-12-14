package com.sample.payoneer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showSnack(String message) {
        Snackbar snack =
                Snackbar.make(this.findViewById(android.R.id.content),
                        message,
                        BaseTransientBottomBar.LENGTH_LONG);
        snack.setBackgroundTint(this.getResources().getColor(R.color.payoneer_green_dark,
                this.getTheme()));
        snack.setTextColor(this.getResources().getColor(R.color.white,
                this.getTheme()));
        snack.show();
    }

}