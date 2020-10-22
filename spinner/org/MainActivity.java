
public class MainActivity extends AppCompatActivity {
    TextView textView;
    String[] items = {"rrr","foxboxr","crow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);

         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 textView.setText(items[i]);
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {
                 textView.setText("");
             }
         });
    }
}