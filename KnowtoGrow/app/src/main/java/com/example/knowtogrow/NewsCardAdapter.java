package com.example.knowtogrow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.knowtogrow.pojoclass.News;

import java.util.List;

public class NewsCardAdapter extends RecyclerView.Adapter<com.example.knowtogrow.NewsCardAdapter.ViewHolder>{

        private List<News> localDataSet;
        Context c;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView headline;
            private final TextView content;
            private final ImageView image;
            private final ImageView like;
            private final ImageView dislike;
            private final ImageView share;
            private final ImageView favourite;
            private final TextView date_fetch;
            private final TextView publisher_fetch;
            private final Button visit;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                content = (TextView) view.findViewById(R.id.content);
                date_fetch = (TextView) view.findViewById(R.id.date_fetch);
                headline = (TextView) view.findViewById(R.id.headline);
                publisher_fetch = (TextView) view.findViewById(R.id.publisher_fetch);
                visit = (Button) view.findViewById(R.id.visit);
                image = (ImageView) view.findViewById(R.id.image);
                like = (ImageView) view.findViewById(R.id.like);
                dislike = (ImageView) view.findViewById(R.id.dislike);
                share = (ImageView) view.findViewById(R.id.share);
                favourite= (ImageView) view.findViewById(R.id.favourite);


            }

            public TextView getTextView() {
                return content;
            }
        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param dataSet String[] containing the data to populate views to be used
         * by RecyclerView.
         */
        public NewsCardAdapter(List<News> dataSet,Context context) {
            localDataSet = dataSet;
            c=context;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.news_card, viewGroup, false);


            return new ViewHolder(view);
        }


    // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.content.setText(localDataSet.get(position).getDescription());
            viewHolder.headline.setText(localDataSet.get(position).getTitle());
            viewHolder.publisher_fetch.setText(localDataSet.get(position).getSource().getName());
            viewHolder.date_fetch.setText(localDataSet.get(position).getPublishedAt());
            Glide.with(c).load(localDataSet.get(position).getUrlToImage()).into(viewHolder.image);
            viewHolder.visit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(localDataSet.get(position).getUrl())));
                }
            });

            viewHolder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                    whatsappIntent.setType("text/plain");
                    whatsappIntent.setPackage("com.whatsapp");
                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, localDataSet.get(position).getUrl());
                    whatsappIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                    try {
                        c.startActivity(whatsappIntent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(c, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            viewHolder.like.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    if(viewHolder.like.getTag().equals("like")){
                        viewHolder.like.setImageResource(R.drawable.filledlike);
                        viewHolder.like.setTag("filledlike");
                    }
                    else{
                        viewHolder.like.setImageResource(R.drawable.like);
                        viewHolder.like.setTag("like");
                    }
                }
            });

viewHolder.dislike.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(viewHolder.dislike.getTag().equals("dislike")){
            viewHolder.dislike.setImageResource(R.drawable.filleddislike);
            viewHolder.dislike.setTag("filleddislike");
        }
        else{
            viewHolder.dislike.setImageResource(R.drawable.dislike);
            viewHolder.dislike.setTag("dislike");
        }
    }
});
viewHolder.favourite.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(viewHolder.favourite.getTag().equals("favourite"))
        {
            viewHolder.favourite.setImageResource(R.drawable.filledfavourite);
            viewHolder.favourite.setTag("filledfavourite");
        }
        else
        {
            viewHolder.favourite.setImageResource(R.drawable.favourites);
            viewHolder.favourite.setTag("favourite");
        }
    }
});

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }

}
