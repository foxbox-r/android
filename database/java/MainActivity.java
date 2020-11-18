package org.techtown.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    TextView text;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit);
        edit2 = findViewById(R.id.edit2);
        text = findViewById(R.id.text);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String database = edit1.getText().toString();
                createDatabase(database);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String tableName = edit2.getText().toString();
                createTable(tableName);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                insertRecord();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                executeQuery();
            }
        });
    }

    public void createDatabase(String databaseName){
        println("createDatabase 호출됨");
        try {
            database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
            println("데이터베이스 생성됨 : " + databaseName);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void createTable(String tableName){
        println("createTable 호출됨");

        try {
            if (database == null) {
                println("데이터베이스를 먼저 열어 주세요.");
                return;
            }

            String sql = "create table if not exists " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, age integer, mobile text)";
            database.execSQL(sql);
            println("테이블 생성됨 : " + tableName);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertRecord(){
        try {
            println("insertRecord 호출됨");
            if (database == null) {
                println("데이터베이스를 먼저 열어주세요.");
                return;
            }
            String tableName = edit2.getText().toString();
            if (tableName == null) {
                println("테이블 이름을 입력하세요");
                return;
            }

            String sql = "insert into " + tableName + "(name,age,mobile) values('foxboxr',17,'010-1111-1111')";
            database.execSQL(sql);
            println("레코드 추가함");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void executeQuery(){
        try {
            println("executeQuery 호출됨");

            if (database == null) {
                println("데이터베이스를 먼저 열어 주세요.");
                return;
            }

            String tableName = edit2.getText().toString();
            if (tableName == null) {
                println("테이블 이름을 출력하세요");
                return;
            }
            String sql = "select _id,name,age,mobile from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);
            int recordCount = cursor.getCount();
            println("레코드 개수 : " + recordCount);

            for (int i = 0; i < recordCount; i++) {
                cursor.moveToNext();//그다음 레코드
                int id = cursor.getInt(0);//age
                String name = cursor.getString(1);//name
                int age = cursor.getInt(2);//age
                String mobile = cursor.getString(3);//mobile

                println("레코드 #" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
            }
            cursor.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void println(String data){
        text.append(data+"\n");
    }

}