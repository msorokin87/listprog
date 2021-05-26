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

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
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
    CheckBox checkboxItem;
    Button buttonCreate;

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
        buttonCreate = findViewById(R.id.buttonCreate);
        checkboxItem = findViewById(R.id.checkboxItem);

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

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResulT();
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
        listDataHeader.add("Мясо");
        listDataHeader.add("Рыба");
        listDataHeader.add("Морепродукты");
        listDataHeader.add("Чай, кофе");
        listDataHeader.add("Молоко, масло, яйца");
        listDataHeader.add("Фрукты");
        listDataHeader.add("Овощи");
        listDataHeader.add("Зелень");
        listDataHeader.add("Крупы, специи");
        listDataHeader.add("Мучные продукты");
        listDataHeader.add("Кондитерские изделия");
        listDataHeader.add("Соки, воды, алкоголь");

        //Добавляем данные о подпунктах:
        List<String> meet = new ArrayList<String>();
        meet.add("Курица");
        meet.add("Свинина");
        meet.add("Говядина");
        meet.add("Телятина");
        meet.add("Баранина");
        meet.add("Крольчатина");
        meet.add("Мясо");

        List<String> feesh = new ArrayList<String>();
        feesh.add("Горбуша");
        feesh.add("Кижуч");
        feesh.add("Кета");
        feesh.add("Минтай");
        feesh.add("Икра");
        feesh.add("Осётр");
        feesh.add("Палтус");
        feesh.add("Дорадо");
        feesh.add("Сёмга");
        feesh.add("Сибас");
        feesh.add("Скумбрия");
        feesh.add("Сом");
        feesh.add("Судак");
        feesh.add("Тилапия");
        feesh.add("Треска");
        feesh.add("Тунец");
        feesh.add("Форель");
        feesh.add("Щука");
        feesh.add("Рыба");

        List<String> seaFood = new ArrayList<String>();
        seaFood.add("Кальмар");
        seaFood.add("Мидии");
        seaFood.add("Молюски");
        seaFood.add("Морской гребешок");
        seaFood.add("Осьминог");
        seaFood.add("Устрицы");
        seaFood.add("Краб");
        seaFood.add("Креветки");
        seaFood.add("Лобстер");
        seaFood.add("Раки");
        seaFood.add("Водоросли");
        seaFood.add("Морская капуста");
        seaFood.add("Морепродукты");

        listDataChild.put(listDataHeader.get(0), meet);
        listDataChild.put(listDataHeader.get(1), feesh);
        listDataChild.put(listDataHeader.get(2), seaFood);
        listDataChild.put(listDataHeader.get(3), seaFood);
        listDataChild.put(listDataHeader.get(4), seaFood);
        listDataChild.put(listDataHeader.get(5), seaFood);
        listDataChild.put(listDataHeader.get(6), seaFood);
        listDataChild.put(listDataHeader.get(7), seaFood);
        listDataChild.put(listDataHeader.get(8), seaFood);
        listDataChild.put(listDataHeader.get(9), seaFood);
        listDataChild.put(listDataHeader.get(10), seaFood);
        listDataChild.put(listDataHeader.get(11), seaFood);
    }

    private void showResulT() {
        String message = "Выбранно";
        if(checkboxItem.isChecked()){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}
