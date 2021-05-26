package com.listprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_menu_activities extends AppCompatActivity {
    public static final int REQUEST_CODE_ADD_NOTE = 1;
    View menuHome;
    View menuMenu;
    View menuDescrip;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activities);

        menuHome = findViewById(R.id.menuHome); // калькулятор
        menuMenu = findViewById(R.id.menuMenu); // рецепты
        menuDescrip = findViewById(R.id.menuDescrip); // Мой список
        ImageView buttonBack3 = findViewById(R.id.buttonBack3);
        ImageView buttonBackClose1 = findViewById(R.id.buttonBackClose1);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        menuDescrip.setBackgroundColor(Color.parseColor("#292734")); // цвет бэкграунда кнопки меню навигации


        buttonBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        }); // кнопка "назад"
        buttonBackClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), MainActivity.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        menuHome.setBackgroundColor(Color.parseColor("#292734"));
                        menuMenu.setBackgroundResource(R.drawable.trending_background);
                        menuDescrip.setBackgroundResource(R.drawable.trending_background);


                        break;

                    case R.id.menuMenu:
                        menuHome.setBackgroundResource(R.drawable.trending_background);
                        menuMenu.setBackgroundColor(Color.parseColor("#292734"));
                        menuDescrip.setBackgroundResource(R.drawable.trending_background);

                        break;

                    case R.id.menuDescrip:
                        menuHome.setBackgroundResource(R.drawable.trending_background);
                        menuDescrip.setBackgroundColor(Color.parseColor("#292734"));
                        menuMenu.setBackgroundResource(R.drawable.trending_background);
                        break;

                }
                return false;
            }

        });

        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Calculation.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // кнопка перекидывает на вкладку "Калькулятор"

        menuMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Recept.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // кнопка перекидывает на вкладку "Рецепты"
    }

    public void buttonCreat(View view) {
        Intent intent = new Intent(this, Creations.class);
        startActivity(intent);
    } // кнопка перекидывает на вкладку "Создать"


}