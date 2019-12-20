package com.example.user.ns;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Fragment fragment;
    DrawerLayout drawerLayout; Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        navigationViewOptionSelected();
    }

    private void navigationViewOptionSelected() {

        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ceaserc:
                     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                             new CeaserCipher()).commit();
                        break;
                    case R.id.PolyAlphabetic:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new PolyAlphabetic()).commit();
                        break;
                    case R.id.About:

                        break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void setUpToolbar(){
        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
