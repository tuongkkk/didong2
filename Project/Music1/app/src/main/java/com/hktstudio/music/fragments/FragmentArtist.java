package com.hktstudio.music.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hktstudio.music.R;
import com.hktstudio.music.activities.MainActivity;
import com.hktstudio.music.adapters.AdapterArtist;
import com.hktstudio.music.models.Artist;

import java.util.List;

/**
 * Created by HOANG on 3/19/2018.
 */

public class FragmentArtist extends Fragment {
    RecyclerView rcv_Artist;
    AdapterArtist adapterArtist;
    List<Artist> list;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist,container,false);
        rcv_Artist = view.findViewById(R.id.rcv_Artist);
        list = MainActivity.listArtist;
        adapterArtist = new AdapterArtist(getContext(),list);
        rcv_Artist.setAdapter(adapterArtist);
        rcv_Artist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }
}
