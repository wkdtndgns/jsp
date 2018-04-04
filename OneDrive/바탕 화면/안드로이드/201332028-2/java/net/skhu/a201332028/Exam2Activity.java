package net.skhu.a201332028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Exam2Activity extends AppCompatActivity {

    static String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        CompoundButton.OnCheckedChangeListener listener1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String s="";

                if(isChecked==true) {
                    s = String.format("%s"+" 선택되었습니다.", buttonView.getText());
                    text+=" " +s;

                }

                else if(isChecked == false){
                    s = String.format("%s"+" 선택이 취소되었습니다..", buttonView.getText());

                }


                Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        };

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox_dog);
        checkBox1.setOnCheckedChangeListener(listener1);


        CompoundButton.OnCheckedChangeListener listener2 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String s="";

                if(isChecked==true) {
                    s = String.format("%s"+" 선택되었습니다.", buttonView.getText());
                    text+=" " +s;

                }

                else if(isChecked == false){
                    s = String.format("%s"+" 선택이 취소되었습니다..", buttonView.getText());
                }


                Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        };

        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox_cat);
        checkBox2.setOnCheckedChangeListener(listener1);


        RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);

                String s="";
                s = radioButton.getText().toString();
                s+=" 선택되었습니다.";
                text+=" " +s;


                Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        };

        final RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup1.setOnCheckedChangeListener(listener3);

        Button button = (Button)findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView t = (TextView)findViewById(R.id.textView2);

                t.setText(text);

            }
        });


    }
}
