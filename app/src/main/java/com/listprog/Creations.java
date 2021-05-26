package com.listprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Creations extends AppCompatActivity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public static final int REQUEST_CODE_ADD_NOTE = 1;

    View menuHome;
    View menuMenu;
    View menuDescrip;

    MaterialButton imgButtonCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creations);
        menuHome = findViewById(R.id.menuHome);
        menuMenu = findViewById(R.id.menuMenu);
        menuDescrip = findViewById(R.id.menuDescrip);
        ImageView buttonBack = findViewById(R.id.buttonBack);
        ImageView buttonBackClose1 = findViewById(R.id.buttonBackClose1); // кнопка "Закрыть" перекидывает на главную
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        //imgButtonCreate = findViewById(R.id.imgButtonCreate);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        buttonBackClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), MainActivity.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        });

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menuHome:
//                        menuHome.setBackgroundColor(Color.parseColor("#292734"));
//                        menuMenu.setBackgroundResource(R.drawable.trending_background);
//                        menuDescrip.setBackgroundResource(R.drawable.trending_background);
//
//
//                        break;
//
//                    case R.id.menuMenu:
//                        menuHome.setBackgroundResource(R.drawable.trending_background);
//                        menuMenu.setBackgroundColor(Color.parseColor("#292734"));
//                        menuDescrip.setBackgroundResource(R.drawable.trending_background);
//
//                        break;
//
//                    case R.id.menuDescrip:
//                        menuHome.setBackgroundResource(R.drawable.trending_background);
//                        menuDescrip.setBackgroundColor(Color.parseColor("#292734"));
//                        menuMenu.setBackgroundResource(R.drawable.trending_background);
//                        break;
//
//                }
//                return false;
//            }
//
//        });
//
//        menuDescrip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivityForResult(new Intent(getApplicationContext(), Main_menu_activities.class),
//                        REQUEST_CODE_ADD_NOTE);
//            }
//        }); // кнопка перекидывает в "Мои списки"
//        menuMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivityForResult(new Intent(getApplicationContext(), Recept.class),
//                        REQUEST_CODE_ADD_NOTE);
//            }
//        }); // кнопка перекидывает на вкладку "Рецепты"
//        menuHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivityForResult(new Intent(getApplicationContext(), Calculation.class),
//                        REQUEST_CODE_ADD_NOTE);
//            }
//        }); // кнопка перекидывает на вкладку "Калькулятор"


        expListView = findViewById(R.id.expandableListView);

        prepareListData();

        listAdapter = new com.listprog.ExpandableListAdapter(this,listDataHeader,listDataChild);

        expListView.setAdapter(listAdapter);

        }
    private void prepareListData() {


        //* Подготавливаем данные для списка:

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //Добавляем данные о пунктах списка:
        listDataHeader.add("Пункт 1");
        listDataHeader.add("Пункт 2");
        listDataHeader.add("Пункт 3");

        //Добавляем данные о подпунктах:
        List<String> top250 = new ArrayList<String>();
        top250.add("Подпункт 1.1");
        top250.add("Подпункт 1.2");
        top250.add("Подпункт 1.3");
        top250.add("Подпункт 1.4");
        top250.add("Подпункт 1.5");
        top250.add("Подпункт 1.6");
        top250.add("Подпункт 1.7");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Подпункт 2.1");
        nowShowing.add("Подпункт 2.2");
        nowShowing.add("Подпункт 2.3");
        nowShowing.add("Подпункт 2.4");
        nowShowing.add("Подпункт 2.5");
        nowShowing.add("Подпункт 2.6");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Подпункт 3.1");
        comingSoon.add("Подпункт 3.2");
        comingSoon.add("Подпункт 3.3");
        comingSoon.add("Подпункт 3.4");
        comingSoon.add("Подпункт 3.5");

        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
