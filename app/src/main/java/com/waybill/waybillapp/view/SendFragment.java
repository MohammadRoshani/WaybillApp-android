package com.waybill.waybillapp.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.waybill.waybillapp.R;
import com.waybill.waybillapp.databinding.FragmentSendBinding;
import com.waybill.waybillapp.viewmodel.MainActivityViewModel;

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
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        fragmentSendBinding.setViewmodel(mainActivityViewModel);
    }
}
