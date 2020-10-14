public class MyService extends Service {
    final String tag = "service";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(tag,"onCreate 호출");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag,"onStartCommnad 호출");

        if(intent != null){
            processCommand(intent);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(tag,"onDestroy 호출");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");
        Log.d(tag,"command : "+command+", name : "+name);
//        try{
//            Thread.sleep(1000);
//        } catch(Exception e){
//            e.printStackTrace();
//        }

        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("command",command+" from service");
        showIntent.putExtra("name",name+" from service");
        startActivity(showIntent);
    }

}