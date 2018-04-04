package net.skhu.c201332028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ArrayList<Person> arrayList;
    ArrayAdapter<Person> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList = new ArrayList<Person>();
        Person person = new Person();
        person.setName("홍길동");
        person.setAge("18");
        Person person1 = new Person();
        person1.setName("전우치");
        person1.setAge("19");
        Person person2 = new Person();
        person2.setName("임꺽정");
        person2.setAge("20");
        arrayList.add(person);
        arrayList.add(person1);
        arrayList.add(person2);
        adapter = new PersonArrayAdapter(this, R.layout.layout_person, arrayList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);



    }
}



