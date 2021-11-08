package com.example.testgit;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.home_fragment, container, false);

        ImageView homeslide = (ImageView) rootView.findViewById(R.id.homeslide);
        AnimationDrawable animationDrawable = (AnimationDrawable) homeslide.getDrawable();
        animationDrawable.start();
        return rootView;

    }
}
