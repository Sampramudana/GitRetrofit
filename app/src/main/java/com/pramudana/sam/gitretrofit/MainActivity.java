package com.pramudana.sam.gitretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pramudana.sam.gitretrofit.adapter.CustomAdapter;
import com.pramudana.sam.gitretrofit.api.ApiService;
import com.pramudana.sam.gitretrofit.api.InstanceRetrofit;
import com.pramudana.sam.gitretrofit.response.DataItem;
import com.pramudana.sam.gitretrofit.response.ResponseData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //TODO Create RecyclerView variable class
    RecyclerView recyclerView;
    String name, address;
    List<DataItem> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Inlitialize Widget to Variable
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    private void getData() {
        ApiService api = InstanceRetrofit.getInstance();
        Call<ResponseData> call = api.response_read_data();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Boolean status = response.body().isSuccess();
                if (status){
                    dataItems = response.body().getData();
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, dataItems);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }
}
