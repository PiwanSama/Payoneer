package com.sample.payoneer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.sample.payoneer.R;
import com.sample.payoneer.databinding.FragmentWelcomeBinding;

public class FragmentWelcome extends BaseFragment {

    private FragmentWelcomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        NavController controller = Navigation.findNavController(view);
        binding.cardNavigateToPayments.setOnClickListener(view1 -> controller.navigate(R.id.action_fragmentWelcome_to_fragmentList));
        binding.cardViewPayments.setOnClickListener(view2 -> Toast.makeText(activity, "Feature Coming Soon!", Toast.LENGTH_SHORT).show());
    }
}
