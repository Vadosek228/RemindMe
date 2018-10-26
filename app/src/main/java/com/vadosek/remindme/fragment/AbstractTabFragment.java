package com.vadosek.remindme.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;


public class AbstractTabFragment extends Fragment {

    private String title;
    protected View view;//могут использовать только наследники класса
    protected Context context;

    //контекст для получения стринга
    // private String title;//которые в будущем будем подгружать

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
