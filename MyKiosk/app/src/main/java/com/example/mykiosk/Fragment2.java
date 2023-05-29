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

public class Fragment2 extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    ArrayList<Menu> menu = new ArrayList<Menu>();

    public Fragment2(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2,container,false);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerview);
        menu.add(new Menu(R.drawable.coke,"콜라M","1500"));
        menu.add(new Menu(R.drawable.coke,"콜라L","1500"));
        menu.add(new Menu(R.drawable.coke,"사이다M","2000"));
        menu.add(new Menu(R.drawable.coke,"사이다L","2000"));
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
