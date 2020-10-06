// 체크박스 버튼 다이얼로그 알림
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
        final ArrayList<String> selectedItems = new ArrayList<String>();
        final String[] items = getResources().getStringArray(R.array.LAN);

        builder.setTitle("리스트 추가 예제");

        builder.setMultiChoiceItems(R.array.LAN, null, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos, boolean isChecked)
            {
                if(isChecked == true) // Checked 상태일 때 추가
                {
                    selectedItems.add(items[pos]);
                }
                else				  // Check 해제 되었을 때 제거
                {
                    selectedItems.remove(pos);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int pos)
            {
                String SeletedItemsString = "";

                for(int i =0; i<selectedItems.size();i++)
                {
                    SeletedItemsString =  SeletedItemsString + "," + selectedItems.get(i);
                }

                Toast toast = Toast.makeText(getApplicationContext(), "선택 된 항목은 :" + SeletedItemsString,Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}