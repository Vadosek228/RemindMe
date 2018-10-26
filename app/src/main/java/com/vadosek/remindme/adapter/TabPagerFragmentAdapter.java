package com.vadosek.remindme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vadosek.remindme.fragment.ExampleFragment;

public class TabPagerFragmentAdapter extends FragmentPagerAdapter{

    //где хранить табы
    private String[] tabs;

    public TabPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        //обращаемся к табу
        //заполняем массив
        tabs = new String[]{
                "Таб 1",
                "Напоминания",
                "Таб 1"
        };

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position]; //обращаемся к табам, чтобы дали позицию
    }

    @Override
    public Fragment getItem(int position) { //будет возвращать фрагмент

        switch (position){
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
