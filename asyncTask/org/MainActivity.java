
public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BackgroundTask task = new BackgroundTask();
                task.execute();
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected void onPreExecute() {//쓰레드 실행 전 호출 함수
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected void onPostExecute(Integer integer) {//쓰레드 끝나고 호출하는 함수
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {//업데이트 하는 함수
            progressBar.setProgress((values[0].intValue()));
        }

        @Override
        protected Integer doInBackground(Integer... integers) {//쓰레드가 동작되는 함수
            while(isCancelled() == false){
                value += 1;
                if(value >= 100){
                    break;
                }

                publishProgress(value);//onProgressUpdate 로 가기

                try{
                    Thread.sleep(100);
                } catch(Exception e){}

            }
            return value;//리턴한 값은 onPostExcute 로 간다.
        }
    }
}