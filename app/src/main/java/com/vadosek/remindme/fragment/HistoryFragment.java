package com.vadosek.remindme.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.remindme.R;
import com.vadosek.remindme.adapter.RemindListAdapter;
import com.vadosek.remindme.dto.RemindDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {

    //объявляем главный лэйаут
    private static final int LAYOUT = R.layout.fragment_history;


    public static HistoryFragment getInstance(Context context){
        Bundle args = new Bundle(); //передача параметров и получение из других мест
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);

        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));//достаем тайтл

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT,container,false);

        //получаем ресайкл вью
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        //просечиваем адаптер
        rv.setAdapter(new RemindListAdapter(createMockData()));

        return view;
    }

    private List<RemindDTO> createMockData() {
        //список элементов, которые будем выводить
        List<RemindDTO> data = new ArrayList<>();
        //добавим несколько элементов
        data.add(new RemindDTO("Item_1"));
        data.add(new RemindDTO("Item_2"));
        data.add(new RemindDTO("Item_3"));
        data.add(new RemindDTO("Item_4"));
        data.add(new RemindDTO("Item_5"));
        data.add(new RemindDTO("Item_6"));

        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
