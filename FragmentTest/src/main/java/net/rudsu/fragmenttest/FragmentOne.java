package net.rudsu.fragmenttest;

import android.os.Bundle;
//import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
//import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_fragment, container, false);
    }
}
