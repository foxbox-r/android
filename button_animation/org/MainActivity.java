public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){//<= v is button
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                v.startAnimation(anim);
            }
        });


    }
}