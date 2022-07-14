package com.example.movieapp.Service.Network;

import com.example.movieapp.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/top_rated?api_key=51b83c199821324a75f010b140f79b0f")
    Call<MovieModel> getTopRatedMovieLists();
}
