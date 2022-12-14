package com.waybill.waybillapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waybill.waybillapp.R;
import com.waybill.waybillapp.databinding.ActivityMainBinding;
import com.waybill.waybillapp.databinding.FragmentSendBinding;
import com.waybill.waybillapp.viewmodel.MainActivityViewModel;

import java.util.Objects;

public class SendFragment extends Fragment {

    MainActivityViewModel mainActivityViewModel;
    FragmentSendBinding fragmentSendBinding;
    public SendFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSendBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_send, container, false);
        return fragmentSendBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);
        fragmentSendBinding.setViewmodel(mainActivityViewModel);
    }
}
