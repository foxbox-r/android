
public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Handler handler =  new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        textView = findViewById(R.id.text);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String urlStr = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(urlStr);
                    }
                }).start();
            }
        });
    }

    public void request(String urlStr){
        try {

            StringBuilder builder = new StringBuilder();
            URL url = new URL(urlStr);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            if(connection != null){
                connection.setConnectTimeout(10000);//10초가 지나도 연결 안되면 연결 취소
                connection.setRequestMethod("GET");
                connection.setDoInput(true);

                int resCode = connection.getResponseCode();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                while(true){
                    line = reader.readLine();
                    if(line == null){
                        break;
                    }

                    builder.append(line+"\n");
                }
                reader.close();
                connection.disconnect();
            }
            println("응답 : "+builder.toString());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data+"\n");
            }
        });
    }
}