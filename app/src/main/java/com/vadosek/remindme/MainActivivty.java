package com.vadosek.remindme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.vladislav.remindme.R;
import com.vadosek.remindme.adapter.TabsFragmentAdapter;


public class MainActivivty extends AppCompatActivity{

    private Toolbar toolbar;
    //объявляем главный лэйаут
    private static final int LAYOUT = R.layout.activity_main;
    private DrawerLayout drawerLayout;
    //получаем доступ к tabLayout
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //указываем, какую тему должен использовать
        setTheme(R.style.AppDefault); //будет использоваться по умолчанию
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        //принимаем тулбар
        initToolbar();

        //добавляем содержимое в NavigationView
        initNavigationView();
        //подгружаем данные
        initTabs();
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

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //инициализируем адаптер
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        //проставляем viePager adapter
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);//получаем доступ к дровер лайаут
        //если хотим переидти без свайпа
        //создаем тогл
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        //присваиваем его дровер лейаут
        drawerLayout.setDrawerListener(toggle);
        //наш тогле должен быть в синхронизированном состояние
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }
        });
    }

    //для перехода на напоминание
    private void showNotificationTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);//хотим обратиться ко второму табу //пока что делает тупо переход

    }
}
