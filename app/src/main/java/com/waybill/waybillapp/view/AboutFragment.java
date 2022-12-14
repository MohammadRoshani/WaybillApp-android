package com.waybill.waybillapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waybill.waybillapp.R;
import com.waybill.waybillapp.databinding.FragmentAboutBinding;
import com.waybill.waybillapp.viewmodel.MainActivityViewModel;

import java.util.Objects;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding fragmentAboutBinding;
    private MainActivityViewModel mainActivityViewModel;

    public AboutFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false);
        return fragmentAboutBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);

        fragmentAboutBinding.setViewmodel(mainActivityViewModel);
    }
}
