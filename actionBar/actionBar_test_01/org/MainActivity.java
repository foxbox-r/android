
public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.home);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch(curId){
            case R.id.menu_refresh:
                showTaost("새로고침 메뉴 선택됨");
                break;
            case R.id.menu_search:
                showTaost("검색 메뉴 선택됨");
                break;
            case R.id.menu_setting:
                showTaost("설정 메뉴 선택됨");
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showTaost(String string){
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }
}