package com.hktstudio.music.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hktstudio.music.R;
import com.hktstudio.music.activities.MainActivity;
import com.hktstudio.music.fragments.FragmentDetailAlbum;
import com.hktstudio.music.models.Album;

import java.util.List;

/**
 * Created by HOANG on 3/30/2018.
 */

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.ViewHolder>{
    List<Album> list;
    Context context;
    LayoutInflater inflater;
    int pos = 0;
    public static AdapterAlbum instance;
    public AdapterAlbum(Context context, List<Album> list) {
        instance = this;
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item_album,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.image_Album.setImageDrawable(Drawable.createFromPath(list.get(position).getAlbum_art()));
        holder.tv_Album.setText(list.get(position).getAlbum());
        holder.tv_Artist.setText(list.get(position).getArtist());
        holder.tv_Count.setText(list.get(position).getNumber_of_songs());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("albumID",list.get(position).getId());
                bundle.putString("image_Album",list.get(position).getAlbum_art());
                bundle.putString("tv_Album",list.get(position).getAlbum());
                bundle.putString("tv_Artist",list.get(position).getArtist());
                MainActivity.addFragmentDetailAlbum(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_Album;
        TextView tv_Album, tv_Artist, tv_Count;
        public ViewHolder(View itemView) {
            super(itemView);
            image_Album = itemView.findViewById(R.id.image_Album);
            tv_Album = itemView.findViewById(R.id.tv_Album);
            tv_Artist = itemView.findViewById(R.id.tv_Artist);
            tv_Count = itemView.findViewById(R.id.tv_Count);
        }
    }
}
