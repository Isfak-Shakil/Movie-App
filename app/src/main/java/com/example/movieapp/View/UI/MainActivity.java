package com.example.movieapp.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;
import com.example.movieapp.View.Adapter.TopMovieLIstAdapter;
import com.example.movieapp.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel mViewModel;
    private TopMovieLIstAdapter topMovieLIstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
      GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        mViewModel=new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                topMovieLIstAdapter=new TopMovieLIstAdapter(MainActivity.this,results);
                recyclerView.setAdapter(topMovieLIstAdapter);
            }
        });
    }
}