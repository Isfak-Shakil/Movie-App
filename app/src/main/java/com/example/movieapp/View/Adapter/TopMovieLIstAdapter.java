package com.example.movieapp.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.R;
import com.example.movieapp.Service.Model.Result;

import java.util.List;

public class TopMovieLIstAdapter extends RecyclerView.Adapter<TopMovieLIstAdapter.MyViewHolder> {

    private Context context;
    private List<Result>mList;

    public TopMovieLIstAdapter(Context context, List<Result> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_movie_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mRating.setText(mList.get(position).getVoteAverage().toString());
        holder.mReleaseDate.setText(mList.get(position).getReleaseDate());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+mList.get(position).getPosterPath()).into(holder
                .mImageView);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitle,mRating,mReleaseDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTitle=itemView.findViewById(R.id.title);
            mRating=itemView.findViewById(R.id.rating_Tv);
            mReleaseDate=itemView.findViewById(R.id.releaseDate_Tv);
        }
    }
}
