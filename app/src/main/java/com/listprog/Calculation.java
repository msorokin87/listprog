package com.listprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Calculation extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NOTE = 1;
    View menuHome;
    View menuMenu;
    View menuDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_layout);

        menuHome = findViewById(R.id.menuHome);
        menuMenu = findViewById(R.id.menuMenu);
        menuDescrip = findViewById(R.id.menuDescrip);
        ImageView buttonBack4 = findViewById(R.id.buttonBack4);
        ImageView buttonBackClose1 = findViewById(R.id.buttonBackClose1); // кнопка "Закрыть" перекидывает на главную
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        menuHome.setBackgroundColor(Color.parseColor("#292734")); // цвет бэкграунда кнопки меню навигации

        buttonBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        }); // кнопка "Назад"
        buttonBackClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), MainActivity.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // кнопка "Закрыть" перекидывает на главную

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

        menuDescrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Main_menu_activities.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // кнопка перекидывает в "Мои списки"

        menuMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Recept.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // кнопка перекидывает на вкладку "Рецепты"
    }
}