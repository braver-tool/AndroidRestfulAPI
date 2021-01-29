package com.retrofit.example.parsing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.retrofit.example.AppUtils;
import com.retrofit.example.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private final List<DataItems> dataItemsList;
    private final Context context;

    public RecyclerAdapter(List<DataItems> itemsList, Context ctx) {
        this.dataItemsList = itemsList;
        this.context = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_json_parser, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataItems dataItems = dataItemsList.get(position);
        if (dataItems != null) {
            holder.aboutLeaderTextView.setText(dataItems.getAbout());
            holder.leaderNameTextView.setText(dataItems.getName());
            String quote = "“".concat(dataItems.getQuote()).concat("”");
            holder.leaderQuoteTextView.setText(quote);
            Bitmap bitmap = AppUtils.getLeaderProfile(context, position);
            //holder.leaderProfileImageView.setImageBitmap(bitmap);
            //Glide.with(context).load(AppUtils.getCircularBitmap(bitmap)).placeholder(R.drawable.default_profile).into(holder.leaderProfileImageView);
            Glide.with(context).load(bitmap).placeholder(R.drawable.default_profile).into(holder.leaderProfileImageView);
            holder.knowMoreTextView.setOnClickListener(v -> {
                //String webLink = dataItemsList.get(position).getLink();
                Intent intent = new Intent(context, WebViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("URL", dataItemsList.get(position).getLink());
                intent.putExtras(bundle);
                //intent.setData(Uri.parse(webLink));
                context.startActivity(intent);
            });
        }

    }

    @Override
    public int getItemCount() {
        return dataItemsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final CircularImageView leaderProfileImageView;
        private final TextView aboutLeaderTextView;
        private final TextView leaderNameTextView;
        private final TextView knowMoreTextView;
        private final TextView leaderQuoteTextView;

        public MyViewHolder(@NonNull View v) {
            super(v);
            leaderProfileImageView = v.findViewById(R.id.leaderProfileImageView);
            aboutLeaderTextView = v.findViewById(R.id.aboutLeaderTextView);
            leaderNameTextView = v.findViewById(R.id.leaderNameTextView);
            knowMoreTextView = v.findViewById(R.id.knowMoreTextView);
            leaderQuoteTextView = v.findViewById(R.id.leaderQuoteTextView);
        }
    }
}
