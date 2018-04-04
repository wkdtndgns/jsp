package net.skhu.a201332028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    static String s="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        TextView t = (TextView)findViewById(R.id.textView);
        s+= t.getText();

        Button b = (Button)findViewById(R.id.button_save);

        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView t = (TextView)findViewById(R.id.textView);
                EditText e = (EditText)findViewById(R.id.editText);

                String content = e.getText().toString();
                if (isEmptyOrWhiteSpace(content))
                    e.setError("내용을 입력하세요");

                else {

                    CharSequence c = e.getText();
                    s += " " + c;

                    t.setText(s);
                    s += "";
                }
            }

        };
        b.setOnClickListener(listenerObj);



        Button b2 = (Button)findViewById(R.id.button_delete);

        View.OnClickListener listenerObj2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView t = (TextView)findViewById(R.id.textView);
                EditText e = (EditText)findViewById(R.id.editText);

                String del="";

                e.setText(del);
                t.setText(del);



            }
        };

        b2.setOnClickListener(listenerObj2);

    }




    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.toString().trim().length() == 0;
    }


}
