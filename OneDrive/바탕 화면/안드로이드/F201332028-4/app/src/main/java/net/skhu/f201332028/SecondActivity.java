package net.skhu.f201332028;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;

        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.GenericTypeIndicator;
        import com.google.firebase.database.ValueEventListener;
        import android.widget.Toast;
        import java.util.ArrayList;
        import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<String> stringList;
    Person person = new Person();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final DatabaseReference myServerData02 = FirebaseDatabase.getInstance().getReference("myServerData02");
        ValueEventListener listener1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String msg;
                GenericTypeIndicator<Person> typeIndicator = new GenericTypeIndicator<Person>() {};
                Person temp  = dataSnapshot.getValue(typeIndicator);

                if(temp!=null) {
                    msg = "이름: " + temp.getName() + "  나이: " + temp.getAge();
                    Toast.makeText(SecondActivity.this, msg, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("내태그", "서버 에러: ", error.toException());
            }
        };
        myServerData02.addValueEventListener(listener1);

        Button button = (Button)findViewById(R.id.btn);
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.editText_name);
                String s = editText.getText().toString();
                EditText editAge = (EditText)findViewById(R.id.editText_age);
                int i = Integer.parseInt(editAge.getText().toString());

                person.setName(s);
                person.setAge(i);
                myServerData02.setValue(person);
                editText.setText("");
                editAge.setText("");
            }
        };
        button.setOnClickListener(listener2);
    }
}

