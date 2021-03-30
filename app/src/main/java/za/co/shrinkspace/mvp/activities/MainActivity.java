package za.co.shrinkspace.mvp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;

import za.co.shrinkspace.mvp.R;
import za.co.shrinkspace.mvp.adapters.TabsAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabsAdapter tabsAdapter;

    private FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        if (firebaseUser == null) {
            sendUserToLoginActivity();
        }
    }

    private void sendUserToLoginActivity() {
        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initWidgets();
    }

    private void initWidgets() {
        mToolbar = findViewById(R.id.main_activity_app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Shrink Space");

        mViewPager = findViewById(R.id.main_tabs_pager);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(tabsAdapter);

        mTabLayout = findViewById(R.id.main_tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}