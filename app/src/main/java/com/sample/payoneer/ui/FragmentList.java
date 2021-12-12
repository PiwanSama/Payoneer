package com.sample.payoneer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.sample.payoneer.R;
import com.sample.payoneer.databinding.FragmentPaymentTypeBinding;

public class FragmentList extends BaseFragment{

    private FragmentPaymentTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_type, container, false);
        return binding.getRoot();
    }

}
