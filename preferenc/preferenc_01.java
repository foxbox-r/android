// sharedPreferences 사용법
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharePref = getSharedPreferences("SHARE_PREF",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharePref.edit();

        final EditText editTxt = findViewById(R.id.edit);
        Button saveButton = findViewById(R.id.button);

        String initialValue = sharePref.getString("data","");

        Log.d("log","==initialData==>"+initialValue);
        if(initialValue != null){
            editTxt.setText(initialValue);
        }

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data = editTxt.getText().toString();
                Log.d("log","==inserted data==>"+data);
                if(data.length()>0) {
                    editor.putString("data", data);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"saved data",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"insert data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}