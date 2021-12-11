package com.sample.payoneer.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sample.payoneer.MainActivity;
import com.sample.payoneer.util.NetworkUtil;

public class BaseFragment extends Fragment {

    public MainActivity activity;

    public boolean isNetworkConnected(){
        return NetworkUtil.getConnectivityString(activity);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (activity==null && context instanceof MainActivity){
            activity = (MainActivity) context;
        }
    }

    @Override
    public void onDetach() {
        this.activity = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        this.activity = null;
        super.onDestroy();
    }
}
