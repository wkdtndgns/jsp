package net.skhu.a201332028;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b1 = (Button)findViewById(R.id.button_exam1Activity);

        View.OnClickListener listenerObj1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Exam1Activity.class);
                startActivity(intent);

            }
        };

        b1.setOnClickListener(listenerObj1);

        Button b2 = (Button)findViewById(R.id.button_exam2Activity);

        View.OnClickListener listenerObj2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Exam2Activity.class);
                startActivity(intent);

            }
        };

        b2.setOnClickListener(listenerObj2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exam1Activity){
            Intent intent = new Intent(this, Exam1Activity.class);
            startActivity(intent);

            return true;
        }

        else if (id == R.id.action_exam2Activity) {
            Intent intent = new Intent(this, Exam2Activity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
