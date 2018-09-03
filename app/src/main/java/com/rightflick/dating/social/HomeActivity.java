package com.rightflick.dating.social;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ProfileCardsFragment.OnFragmentInteractionListener, MyProfileFragment.OnFragmentInteractionListener{

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Window window = HomeActivity.this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(HomeActivity.this,R.color.colorPrimaryDark));
        }

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.top_navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        bottomNavigationView.setSelectedItemId(R.id.action_schedules);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id){
                    case R.id.action_favorites :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        MyProfileFragment myProfileFragment = new MyProfileFragment();
                        fragmentTransaction.replace(R.id.fragment_container, myProfileFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                        break;

                    case R.id.action_schedules :
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        ProfileCardsFragment profileCardsFragment = new ProfileCardsFragment();
                        fragmentTransaction.replace(R.id.fragment_container, profileCardsFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                        break;
                }

                return true;
            }
        });

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ProfileCardsFragment profileCardsFragment = new ProfileCardsFragment();
        fragmentTransaction.add(R.id.fragment_container, profileCardsFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
