package com.listprog;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
public static final int REQUEST_CODE_ADD_NOTE = 1;

View menuHome;
    View menuMenu;
    View menuDescrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        menuHome = findViewById(R.id.menuHome);
        menuMenu = findViewById(R.id.menuMenu);
        menuDescrip = findViewById(R.id.menuDescrip);






        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
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

        menuDescrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), Main_menu_activities.class),
                        REQUEST_CODE_ADD_NOTE);
            }
        }); // перекидыват на вкладку "Мои списки"

        AppCompatButton buttonCreate = findViewById(R.id.buttonCreate); // кнопка "Создать
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getApplicationContext(), Creations.class),
                        REQUEST_CODE_ADD_NOTE
                );

            }
        }); // перекидывает во вкладку "Создать"
    }

  public void buttonRecept(View view) {
       Intent intent = new Intent(this, Recept.class);
      startActivity(intent);
    } // кнопка "Рецепты"




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.help_menu, menu);
        return true;
    } // всплывающее меню


    }


