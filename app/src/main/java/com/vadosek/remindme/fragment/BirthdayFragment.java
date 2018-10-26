package com.vadosek.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.remindme.R;

public class BirthdayFragment extends AbstractTabFragment {

    //объявляем главный лэйаут
    private static final int LAYOUT = R.layout.fragment_example;


    public static BirthdayFragment getInstance(Context context){
        Bundle args = new Bundle(); //передача параметров и получение из других мест
        BirthdayFragment fragment = new BirthdayFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_birthday));//достаем тайтл

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);
        return view;
    }


    public void setContext(Context context) {
        this.context = context;
    }

}
