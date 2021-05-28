package com.listprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Creations extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NOTE = 1;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    View menuHome;
    View menuMenu;
    View menuDescrip;
   //CheckBox checkboxItem;
    Button buttonCreate;
    TextView expandedListItem;



   // MaterialButton imgButtonCreate;




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
        //checkboxItem = findViewById(R.id.checkboxItem);
        expandedListItem = findViewById(R.id.expandedListItem);

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

        listAdapter = new MyExpandableListAdapter(this,listDataHeader,listDataChild);




        expListView.setAdapter(listAdapter);
        //expListView.setChoiceMode(ExpandableListView.CHOICE_MODE_MULTIPLE);
//        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            int lastExpPos = -1;
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (lastExpPos != -1 && groupPosition != lastExpPos) {
//                    expListView.collapseGroup(lastExpPos);
//                }
//                lastExpPos = groupPosition;
//            }
//        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(), listDataHeader.get(groupPosition), Toast.LENGTH_LONG).show();
            }
        });
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(), listDataHeader.get(groupPosition) + " выыбрано ", Toast.LENGTH_LONG).show();
            }
        });



//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//                Toast.makeText(getBaseContext(),
//                        listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
//
//                return false;
//            }
//        });


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




}

 class MyExpandableListAdapter extends BaseExpandableListAdapter {


    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;




    public MyExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {

        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }



    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.listTitle);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        ImageButton check = convertView.findViewById(R.id.checkbox);

          check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List <String> array = new ArrayList<String>();

                //List <String> child = listDataChild.get(listDataHeader.get(groupPosition));
                String selected = getChild(groupPosition, childPosition).toString();
                Toast.makeText(context, selected, Toast.LENGTH_SHORT).show();
                array.add(selected);
                StringBuilder builder = new StringBuilder();


            }

        });


        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.expandedListItem);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}


