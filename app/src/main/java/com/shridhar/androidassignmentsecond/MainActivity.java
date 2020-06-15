package com.shridhar.androidassignmentsecond;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.shridhar.androidassignmentsecond.Model.CardDetails;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<CardDetails> arrayList;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null)
            this.getSupportActionBar().hide();

        arrayList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("Pref", 0);
        getCardDetails();

        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            getCardDetails();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void getCardDetails() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<CardDetails>> call = api.getCardDetails();

        call.enqueue(new Callback<List<CardDetails>>() {
            @Override
            public void onResponse(Call<List<CardDetails>> call, Response<List<CardDetails>> response) {
                List<CardDetails> cardDetailsList = response.body();
                Log.d("Response", response.body().toString());

                arrayList.clear();

                for (int i = 0; i < cardDetailsList.size(); i++) {
                    if (!sharedPreferences.getBoolean(cardDetailsList.get(i).getId().toString(), false))
                        arrayList.add(cardDetailsList.get(i));
                }

                MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(arrayList, MainActivity.this);
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<CardDetails>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
