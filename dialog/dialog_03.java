// 리스트 버튼 다이얼로그 알림
// 
// /res/values/strings.xml 
// 
// <?xml version="1.0" encoding="utf-8"?>
// <resources>
//     <string name="app_name">My Application</string>
//     <string name="title_activity_sub">SubActivity</string>

//     <string-array name = "LAN">
//         <item>"Android"</item>
//         <item>"Java"</item>
//         <item>"C/C++"</item>
//     </string-array>
// </resources>
// 
// 
// 
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                OnClickHandler(v);
            }
        });
    }

    public void OnClickHandler(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("리스트 추가 예제");

        builder.setItems(R.array.LAN, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos)
            {
                String[] items = getResources().getStringArray(R.array.LAN);
                Toast.makeText(getApplicationContext(),items[pos],Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}