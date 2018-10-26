package com.vadosek.remindme.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.remindme.R;
import com.vadosek.remindme.fragment.AbstractTabFragment;
import com.vadosek.remindme.fragment.BirthdayFragment;
import com.vadosek.remindme.fragment.ExampleFragment;
import com.vadosek.remindme.fragment.HistoryFragment;
import com.vadosek.remindme.fragment.IdeasFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    //где хранить табы
    //private String[] tabs;
    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        //обращаемся к табу
        //заполняем массив
//        tabs = new String[]{
//                "History",
//                "ideas",
//                "TODO",
//                "Birthday"
//        };
        this.context = context;
        init(context);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return tabs[position]; //обращаемся к табам, чтобы дали позицию
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) { //будет возвращать фрагмент

//        switch (position){
//            case 0:
//                return ExampleFragment.getInstance();
//            case 1:
//                return ExampleFragment.getInstance();
//            case 2:
//                return ExampleFragment.getInstance();
//        }



        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void init(Context context) {
        //инифиализируем мэп
        tabs = new HashMap<>();
 
        tabs.put(0, HistoryFragment.getInstance(context));// это значение vial
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, ExampleFragment.getInstance(context));
        tabs.put(3, BirthdayFragment.getInstance(context));
    }
}
