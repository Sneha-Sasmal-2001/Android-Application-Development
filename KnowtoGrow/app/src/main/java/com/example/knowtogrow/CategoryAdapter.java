package com.example.knowtogrow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.ArrayAdapter; 
import android.widget.ImageView; 
import android.widget.TextView; 
import androidx.annotation.NonNull; 
import androidx.annotation.Nullable;

import java.util.ArrayList;

    public class CategoryAdapter extends ArrayAdapter<Category> {
        ArrayList<Category> categoryArrayList;
        Context c;
        public CategoryAdapter(@NonNull Context context, ArrayList<Category> categoryArrayList) {
            super(context, 0, categoryArrayList);
            this.c = context;
            this.categoryArrayList = categoryArrayList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listitemView = convertView;
            if (listitemView == null) {
                // Layout Inflater inflates each item to be displayed in GridView.
                listitemView = LayoutInflater.from(getContext()).inflate(R.layout.sports, parent, false);
            }
            Category category = getItem(position);
            TextView courseTV = listitemView.findViewById(R.id.sport_t);
            ImageView courseIV = listitemView.findViewById(R.id.sport_img);
            View v = listitemView.findViewById(R.id.car_lay_select);
            courseTV.setText(category.getCourse_name());
            courseIV.setImageResource(category.getImgid());
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(c,News_Activity.class);
                    i.putExtra("option","everything_cat");
                    i.putExtra("category",courseTV.getText());
                    c.startActivity(i);

                }
            });

            return listitemView;
        }
    }


