package com.vadosek.remindme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.vladislav.remindme.R;


public class MainActivivty extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //указываем, какую тему должен использовать
        setTheme(R.style.AppDefault); //будет использоваться по умолчанию
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //принимаем тулбар
        initToolbar();
    }

    private void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //устанавливаем имя
        toolbar.setTitle(R.string.app_name);
        //устанавливаем слушателей на кнопки
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        //нужно исполькозать меню
        toolbar.inflateMenu(R.menu.menu);
        //getSupportActionBar().hide();//скрыть тулбар
        //toolbar.setTitleTextColor(0xFFFFFFFF);//сделать надпись на тулбар белой

    }
}
