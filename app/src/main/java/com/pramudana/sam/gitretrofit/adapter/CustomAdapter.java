package com.pramudana.sam.gitretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pramudana.sam.gitretrofit.R;
import com.pramudana.sam.gitretrofit.response.DataItem;

import java.util.List;

/**
 * Created by sampramudana on 8/24/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    List<DataItem> data;
    public static final String WebUrl = "http://192.168.10.52/GitRetrofit/";

    public CustomAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.data = dataItems;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, int position) {

        final String url_image = WebUrl+"upload/"+data.get(position).getImage();
        final String strId = data.get(position).getId().toString();
        holder.name.setText(data.get(position).getName());
        holder.address.setText(data.get(position).getAddress());
        Glide.with(context)
                .load(url_image)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, address;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtName);
            address = itemView.findViewById(R.id.txtAddress);
            img = itemView.findViewById(R.id.image);
        }
    }
}
