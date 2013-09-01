package net.rudsu.fragmenttest;

import android.os.Bundle;
//import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
//import android.view.Menu;
import android.view.View;
//import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

    private boolean mTwoPane;

    private FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            FragmentOne firstFragment = new FragmentOne();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            fm.beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void btnToFragmentTwo(View view) {
        FragmentTwo secondFragment = new FragmentTwo();
        FragmentTransaction ftrans = fm.beginTransaction();
//        ftrans.remove(fm.findFragmentById(R.id.fragment_container));
//        ftrans.add(R.id.fragment_container, secondFragment);

        ftrans.setCustomAnimations(R.anim.right_to_left, R.anim.fade_out_transition,
                R.anim.left_to_right, R.anim.fade_out_transition);
        ftrans.replace(R.id.fragment_container, secondFragment);

//        ftrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        String tag = null;
        ftrans.addToBackStack(tag);

        ftrans.commit();
    }

    public void btnToFragmentOne(View view) {
        super.onBackPressed();
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    
}
