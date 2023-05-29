package com.example.mykiosk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykiosk.model.Menu;

import java.util.ArrayList;

public class Fragment4 extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    ArrayList<Menu> menu = new ArrayList<Menu>();
    public Fragment4(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4,container,false);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerview);
        menu.add(new Menu(R.drawable.hamburger1,"와퍼주니어(행사)","1900~"));
        menu.add(new Menu(R.drawable.hamburger1,"불고기와퍼주니어(행사)","1900~"));
        menu.add(new Menu(R.drawable.hamburger1,"치즈와퍼주니어(행사)","2200~"));
        menu.add(new Menu(R.drawable.hamburger1,"할라피뇨와퍼주니어(행사)","2300~"));
        recyclerView.setHasFixedSize(true);

        adapter=new MyAdapter(getActivity(),menu,new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Menu menu) {
                Toast.makeText(getActivity(), "Clicked: " + menu, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
