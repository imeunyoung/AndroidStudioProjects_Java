package com.example.mykiosk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykiosk.model.Menu;
import com.example.mykiosk.model.Order;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    ArrayList<Menu> menu = new ArrayList<Menu>();
    ArrayList<Order> order = new ArrayList<Order>(); // 주문 목록에 담긴 메뉴를 저장하는 리스트

    public Fragment1(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1,container,false);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.recyclerview);
        menu.add(new Menu(R.drawable.hamburger1,"햄버거1","10000"));
        menu.add(new Menu(R.drawable.hamburger1,"햄버거2","11000"));
        menu.add(new Menu(R.drawable.hamburger1,"햄버거3","12000"));
        menu.add(new Menu(R.drawable.hamburger1,"햄버거4","13000"));
        recyclerView.setHasFixedSize(true);

        adapter=new MyAdapter(getActivity(),menu,new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Menu menu) {
                showQuantityDialog(menu);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        return rootView;
    }
    private void showQuantityDialog(final Menu menu) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("메뉴 추가");
        builder.setMessage(menu.getMenuName() + "의 수량을 변경하세요");

        final EditText quantityEditText = new EditText(getActivity());
        quantityEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(quantityEditText);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String quantityStr = quantityEditText.getText().toString();
                int quantity = Integer.parseInt(quantityStr);

//                menu.setQuantity(quantity);

                Toast.makeText(getActivity(), menu.getMenuName()  +"이(가) "+ quantity + "개 추가되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
