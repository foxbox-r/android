
public class MainActivity extends AppCompatActivity {

    TextView text;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

        handler = new MainHandler();
    }

    class BackgroundThread extends Thread{
        int value = 0;

        public void run(){
            for(int i=0;i<100;i++){
                try{
                    Thread.sleep(1000);
                } catch(Exception e){}

                ++value;
//                text.setText("값 : "+value);
                Log.d("MyThread","value : "+value);

                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value",value);
                msg.setData(bundle);

                handler.sendMessage(msg);

            }
        }
    }

    class MainHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            text.setText("값 : "+value);
        }
    }
}