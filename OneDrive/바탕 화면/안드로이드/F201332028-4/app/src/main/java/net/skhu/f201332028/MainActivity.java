package net.skhu.f201332028;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Dialog;

import java.util.ArrayList;
import java.util.Date;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    ArrayList<Person> arrayList;
    ArrayAdapter<Person> adapter;
    private int selectedIndex; // 선택된 데이터 항목의, arrayList에서 index


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                if (button.getId() == R.id.btnFirstActiviy)
                    startActivity(new Intent(MainActivity.this,  FirstActivity.class));
                else if (button.getId() == R.id.btnSecondActivity)
                    startActivity(new Intent(MainActivity.this,  SecondActivity.class));
            }
        };
        findViewById(R.id.btnFirstActiviy).setOnClickListener(myOnClickListener);
        findViewById(R.id.btnSecondActivity).setOnClickListener(myOnClickListener);



    }





    }
