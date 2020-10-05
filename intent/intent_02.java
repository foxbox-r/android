// intent에 대이터를 넣어서 보내기

class Info implements Serializable {
    String phone;
    String addr;

    public Info(){ }
    public Info(String phone,String addr){
        this.phone = phone;
        this.addr = addr;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddr(){
        return this.addr;
    }

    public void setAddr(String addr){
        this.addr = addr;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] strArray = {"foxboxr","rsua","rrr"};
                Info info = new Info("010-2222-5555","대구xxxxxx");

                Intent intent = new Intent(getApplicationContext(),SubActivity.class);

                intent.putExtra("name","류수아");
                intent.putExtra("age",16);
                intent.putExtra("strArray",strArray);
                intent.putExtra("InfoClass",info);

                startActivity(intent);
            }
        });
    }
}class intent_02 {
    
}


// 
// subActivity
// 



public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);
        TextView t4 = findViewById(R.id.t4);
        TextView t5 = findViewById(R.id.t5);

        Intent intent = getIntent();//intent 받기

        String name = intent.getExtras().getString("name");
        t1.setText(name);

        int age = intent.getExtras().getInt("age");
        t2.setText(age+"");

        String strArray[] = intent.getExtras().getStringArray("strArray");
        String nameList = "";
        for(int i=0;i<strArray.length;i++){
            nameList += strArray[i]+", ";
        }
        t3.setText(nameList);

        Info info = (Info)intent.getSerializableExtra("InfoClass");
        t4.setText(info.getPhone());
        t5.setText(info.getAddr());

    }
}
