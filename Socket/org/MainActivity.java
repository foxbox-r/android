
public class MainActivity extends AppCompatActivity {
    EditText input1;
    TextView output1;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        output1 = findViewById(R.id.output1);
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String data = input1.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();

            }
        });

        Button startServerButton = findViewById(R.id.startServerButton);
        startServerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });
    }

    public void startServer(){
        int port = 5001;
        try {
            ServerSocket server = new ServerSocket(port);//자동으로 자기 아이피 사용
            while(true){
                Socket socket = server.accept();//socket이 요청할때 승인 대기
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                println("connected client : "+clientHost+","+clientPort);

                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                String input = (String)inStream.readObject();

                println("get data : "+input);

                ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                outStream.writeObject(input+" from server.");
                outStream.flush();
                println("send data");
                socket.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                output1.append(data+"\n");
            }
        });
    }

    public void send(String data){
        int port = 5001;

        try {
            Socket socket = new Socket("localhost", port);

            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            outStream.writeObject(data);
            outStream.flush();

            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            String input = (String)inStream.readObject();
            Log.d("main","geted data : "+input);
            socket.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}