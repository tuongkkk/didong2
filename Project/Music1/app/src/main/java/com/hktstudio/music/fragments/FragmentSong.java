package com.hktstudio.music.fragments;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hktstudio.music.activities.MainActivity;
import com.hktstudio.music.R;
import com.hktstudio.music.adapters.AdapterSong;
import com.hktstudio.music.models.Song;
import com.hktstudio.music.service.MusicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOANG on 3/19/2018.
 */

public class FragmentSong extends Fragment{
    public static FragmentSong instance;
    public static List<Song> list = MainActivity.listSong;
    RecyclerView rcv_Song;
    AdapterSong adapterSong;
    public static int pos = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        rcv_Song = view.findViewById(R.id.rcv_Song);
        instance = this;
        adapterSong = new AdapterSong(getContext(),list);
        rcv_Song.setAdapter(adapterSong);
        rcv_Song.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }
}
