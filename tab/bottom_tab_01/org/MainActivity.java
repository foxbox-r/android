
public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment_1 t1 = new Fragment_1();
    private Fragment_2 t2 = new Fragment_2();
    private Fragment_3 t3 = new Fragment_3();
    private Fragment_4 t4 = new Fragment_4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,t1).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Toast.makeText(getApplicationContext(),""+item.getItemId(),Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.tab1:
                        transaction.replace(R.id.frame_layout,t1).commitAllowingStateLoss();
                        break;
                    case R.id.tab2:
                        transaction.replace(R.id.frame_layout,t2).commitAllowingStateLoss();
                        break;
                    case R.id.tab3:
                        transaction.replace(R.id.frame_layout,t3).commitAllowingStateLoss();
                        break;
                    case R.id.tab4:
                        transaction.replace(R.id.frame_layout,t4).commitAllowingStateLoss();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"default",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });
    }
}