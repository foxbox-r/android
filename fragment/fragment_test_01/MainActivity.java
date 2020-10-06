public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    SubFragment subFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        subFragment = new SubFragment();
    }

    public void onFragmentChange(int index){
        switch(index){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,mainFragment).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,subFragment).commit();
                break;
            default:break;
        }
    }
}