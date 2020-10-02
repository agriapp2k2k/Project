package com.example.agriproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LoginFragment extends Fragment {
    ImageView psign;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        psign = v.findViewById(R.id.psign);
        psign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(getContext()).inflate(R.layout.phone,null,false);
                BottomSheetDialog dialog = new BottomSheetDialog(getContext());
                dialog.setContentView(v);
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        return v;
    }
}