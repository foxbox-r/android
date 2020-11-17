package org.techtown.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

    RecyclerView recyclerView;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        textView = findViewById(R.id.text);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String urlStr = editText.getText().toString();
                request(urlStr);
            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public void request(String urlStr){
        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlStr,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        println("응답 => " + response);

                        processResponse(response);

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.d("main",error.toString());
                        println("error => "+ error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄");
    }

    public void processResponse(String response){
        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(response,MovieList.class);
        println("영화 정보의 수 : "+movieList.boxOfficeResult.dailyBoxOfficeList.size());

        for(int i=0;i<movieList.boxOfficeResult.dailyBoxOfficeList.size();i++){
            Movie movie = movieList.boxOfficeResult.dailyBoxOfficeList.get(i);
            adapter.addItem(movie);
        }
        adapter.notifyDataSetChanged();

    }

    public void println(String data){
        textView.append(data+'\n');
    }
}