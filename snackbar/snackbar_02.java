// 확인 버튼을 눌러서 스낵바 없애기
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//              이 경우 메시지를 화면에 보여주는 시간을 LENGTH_INDEFINITE를 선택했기 때문에 자동으로 사라지지 않습니다.
//              확인을 선택할 경우에 Snackbar가 사라지도록 구현되어 있습니다.
                final Snackbar snackbar = Snackbar.make(v, "Snackbar 메시지입니다.\n확인 누르면 사라집니다.", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("확인",new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });
    }
}