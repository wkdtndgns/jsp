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
import android.util.Log;
import java.util.ArrayList;
import java.util.Date;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    static final String TAG = "내로그";

    ArrayList<Person> arrayList;
    ArrayAdapter<Person> adapter;
    private int selectedIndex; // 선택된 데이터 항목의, arrayList에서 index
    // 대화상자 관리자 객체를 한 번 만든 다음 계속 사용하기 위해서 멤버 변수로 선언하였다
    private CreateDialogFragment createDialogfragment; // 새 메모 작성 대화상자 관리자
    private EditDialogFragment editDialogfragment; // 수정 대화상자 관리자
    private DeleteDialogFragment deleteDialogfragment; // 삭제 대화상자 관리자


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        arrayList = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setName("홍길동");
        person1.setAge(18);

        Person person2 = new Person();
        person2.setName("전우치");
        person2.setAge(19);

        arrayList.add(person1);
        arrayList.add(person2);
        adapter = new PersonArrayAdapter(this, R.layout.person, arrayList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

// ListView 항목을 클릭했을 때 실행될 메소드 등록하는 코드의 시작
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (editDialogfragment == null) // 대화상자 관리자 객체를 아직 만들지 않았다면
                    editDialogfragment = new EditDialogFragment(); // 대화상자 관리자 객체를 만든다
                selectedIndex = position; // 수정할 항목의 index를 대입한다.
                editDialogfragment.show(getSupportFragmentManager(), "EditDialog"); // 화면에 대화상자 보이기
            }
        });
        // ListView 항목을 길게 클릭했을 때 실행될 메소드 등록하는 코드의 끝


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu); // 액티비티의 메뉴 생성하기
        // List4Activity의 메뉴를 그대로 사용한다.
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_create) {
            if (createDialogfragment == null) // 대화상자 관리자 객체를 아직 만들지 않았다면
                createDialogfragment = new CreateDialogFragment(); // 대화상자 관리자 객체를 만든다
            createDialogfragment.show(getSupportFragmentManager(), "CreateDialog"); // 화면에 대화상자 보이기
            return true;

        }
        if (id == R.id.action_delte) {
            if (deleteDialogfragment == null) // 대화상자 관리자 객체를 아직 만들지 않았다면
                deleteDialogfragment = new DeleteDialogFragment(); // 대화상자 관리자 객체를 만든다
            deleteDialogfragment.show(getSupportFragmentManager(), "DeleteDialog"); // 화면에 대화상자 보이기
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    // 새 메모를 작성하기 위한 대화상자 관리자 클래스
    public static class CreateDialogFragment extends DialogFragment {
        @Override
        // 새 메모 작성 대화상자를 만드는 메소드
        // 이 메소드는 대화상자를 새로 만들어야 할 때에만 호출된다.
        // 한 번 만들어진 대화상자는 계속 재사용 된다.
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final FirstActivity activity = (FirstActivity)getActivity();  // 액티비티 객체에 대한 참조 얻기
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("사람 입력"); // 대화 상자의 제목 설정하기

            // 대화 상자에 표시될 뷰 객체들을 자동으로 생성함.
            final View rootView = activity.getLayoutInflater().inflate(R.layout.person_edit, null);

            // 자동으로 생성된 EditText 객체들에 대한 참조를 미리 얻어 둔다.
            final EditText editText_name = (EditText)rootView.findViewById(R.id.editText_name);
            final EditText editText_age = (EditText)rootView.findViewById(R.id.editText_age);

            // 자동으로 생성된 뷰 객체들을 대화상자에 추가한다
            builder.setView(rootView);

            // 대화상자에 '저장' 버튼 추가하는 코드의 시작
            builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                @Override
                // 대화상자의 '저장' 버튼이 클릭되면 실행되는 메소드
                public void onClick(DialogInterface dialog, int which) {
                    // 대화 상자의 EditText에 입력된 내용을 꺼낸다.
                    // editText_title, editText_body는 outer 메소드의 final 지역 변수이다.
                    // outer 메소드의 final 지역 변수는 inner 메소드에서 사용할 수 있다.
                    CharSequence s1 = editText_name.getText();
                    CharSequence s2 = editText_age.getText();
                    String s= s2.toString();

                    Person dataItem = new Person();    // ListView에 추가할 데이터 항목 객체 생성
                    dataItem.setName(s1.toString());      // 데이터 항목 객체에 제목 채우기
                    dataItem.setAge(Integer.parseInt(s));       // 데이터 항목 객체에 내용 채우기

                    activity.arrayList.add(dataItem);        // 데이터 목록에 새 객체 추가하기
                    activity.adapter.notifyDataSetChanged(); // 새로 추가된 객체가 화면에서도 보이도록 하기
                } // onClick 메소드의 끝
            });
            // 대화상자에 '저장' 버튼을 추가하는 코드의 끝

            builder.setNegativeButton("취소", null); // 대화상자에 '취소' 버튼을 추가하기
            AlertDialog dialog = builder.create(); // 대화상자 객체 생성하기
            return dialog; // 생성된 대화상자 객체 리턴
        }
    }

    // 데이터 항목을 수정하기 위한 대화상자 관리자 클래스
    public static class EditDialogFragment extends DialogFragment {
        @Override
        // 수정 대화상자를 만드는 메소드
        // 이 메소드는 대화상자를 새로 만들어야 할 때에만 호출된다.
        // 한 번 만들어진 대화상자는 계속 재사용 된다.
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final FirstActivity activity = (FirstActivity)getActivity();  // 액티비티 객체에 대한 참조 얻기
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("사람 수정"); // 대화 상자의 제목 설정하기

            // 대화 상자에 표시될 뷰 객체들을 자동으로 생성함.
            final View rootView = activity.getLayoutInflater().inflate(R.layout.person_edit, null);

            // 자동으로 생성된 EditText 객체들에 대한 참조를 미리 얻어 둔다.
            final EditText editText_name= (EditText)rootView.findViewById(R.id.editText_name);
            final EditText editText_age = (EditText)rootView.findViewById(R.id.editText_age);

            // arrayList에서 selectedIndex 위치의 데이터 항목 객체에 대한 참조를 얻는다.
            int index = activity.selectedIndex;
            final Person dataItem = activity.arrayList.get(index);

            // 데이터 항목의 제목과 내용을 EditText에 채운다.
            editText_name.setText(dataItem.getName());
            editText_age.setText(String.valueOf(dataItem.getAge()));

            // 자동으로 생성된 뷰 객체들을 대화상자에 추가한다
            builder.setView(rootView);

            // 대화상자에 '저장' 버튼 추가하는 코드의 시작
            builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                @Override
                // 대화상자의 '저장' 버튼이 클릭되면 실행되는 메소드
                public void onClick(DialogInterface dialog, int which) {
                    // 대화 상자의 EditText에 입력된 내용을 꺼낸다.
                    // editText_title, editText_body는 outer 메소드의 final 지역 변수이다.
                    // outer 메소드의 final 지역 변수는 inner 메소드에서 사용할 수 있다.
                    CharSequence s1 = editText_name.getText();
                    CharSequence s2 = editText_age.getText();
                    String s=s2.toString();
                    // dataItem은 outer 메소드의 final 지역변수이다.
                    dataItem.setName(s1.toString());      // 데이터 항목 객체에 제목 채우기
                    dataItem.setAge(Integer.parseInt(s));       // 데이터 항목 객체에 내용 채우기

                    activity.adapter.notifyDataSetChanged(); // 새로 추가된 객체가 화면에서도 보이도록 하기
                } // onClick 메소드의 끝
            });
            // 대화상자에 '저장' 버튼을 추가하는 코드의 끝

         

            builder.setNegativeButton("취소", null); // 대화상자에 '취소' 버튼을 추가하기
            AlertDialog dialog = builder.create(); // 대화상자 객체 생성하기
            return dialog; // 생성된 대화상자 객체 리턴
        }
    }

    // 데이터 항목을 삭제하기 위한 대화상자 관리자 클래스
    public static class DeleteDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final FirstActivity activity = (FirstActivity) getActivity(); // 액티비티 객체에 대한 참조 얻기

            // 데이터 항목을 삭제하기 위한 대화상자를 생성하는 코드의 시작
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("확인"); // 대화상자 제목 설정하기
            builder.setMessage("삭제하시겠습니까?"); // 대화상자에 표시할 문자열 설정하기

            // 대화상자에 "예" 버튼 추가하는 코드의 시작
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int index) {
                    // arrayList에서 selectedIndex 위치의 데이터 항목을 제거한다.

                    int i=activity.adapter.getCount()-1;

                    Log.d(TAG, "EditText에 입력된 문자열 :" + i);
                    activity.arrayList.remove(i); // arrayList에서 itemIndex 위치의 데이터 항목 제거하기
                    activity.adapter.notifyDataSetChanged(); // 삭제된 객체가 화면에서도 보이지 않도록 하기
                }
            });
            // 대화상자에 "예" 버튼 추가하는 코드의 끝

            builder.setNegativeButton("아니오", null); // 대화상자에 "아니오" 버튼 추가하기
            AlertDialog dialog = builder.create(); // 대화상자 객체 생성하기
            return dialog;
        }
    }



}



