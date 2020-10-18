
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter();
        adapter.addItem(new Person("rsua","010-1531-1324"));
        adapter.addItem(new Person("foxboxr","010-1531-1324"));
        adapter.addItem(new Person("rrr","010-1531-1324"));
        adapter.addItem(new Person("rsae","010-1531-1324"));
        adapter.addItem(new Person("rsua","010-1531-1324"));
        adapter.addItem(new Person("foxboxr","010-1531-1324"));
        adapter.addItem(new Person("rrr","010-1531-1324"));
        adapter.addItem(new Person("rsae","010-1531-1324"));
        adapter.addItem(new Person("rsua","010-1531-1324"));
        adapter.addItem(new Person("foxboxr","010-1531-1324"));
        adapter.addItem(new Person("rrr","010-1531-1324"));
        adapter.addItem(new Person("rsae","010-1531-1324"));
        recyclerView.setAdapter(adapter);
    }
}