// 라디오 버튼 다이얼로그 알림
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
        final String[] items = getResources().getStringArray(R.array.LAN);
        final ArrayList<String> selectedItem  = new ArrayList<String>();
        selectedItem.add(items[0]);

        builder.setTitle("리스트 추가 예제");

        builder.setSingleChoiceItems(R.array.LAN, 0, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos)
            {
                selectedItem.clear();
                selectedItem.add(items[pos]);
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos)
            {
                Toast toast = Toast.makeText(getApplicationContext(), "선택된 항목 : " + selectedItem.get(0), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}