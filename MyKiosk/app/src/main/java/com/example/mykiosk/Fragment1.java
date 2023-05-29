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
    ArrayList<Order> order=new ArrayList<Order>();

    public Fragment1(){

    }
    public void setOrder(ArrayList<Order> order) {
        this.order = order;
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

//                // 주문목록에 메뉴 추가
//                if (order.contains(menu)) {
//                    // 이미 주문목록에 있는 메뉴인 경우 수량만 업데이트
//
//
//                    int index = order.indexOf(menu);
//                    Order orderMenu = order.get(index);
//                    orderMenu.setOrderQuantity(quantity);
//                    ((MainActivity) getActivity()).orderAdapter.notifyDataSetChanged(); // 어댑터에 변경 내용을 알림
//
//                } else {
                    // 주문목록에 새로운 메뉴 추가
                    Order orderMenu = new Order(quantity, menu.getMenuName(), menu.getMenuPrice());
//                    order.add(orderMenu);
                    ((MainActivity) getActivity()).addOrder(orderMenu);

//                }

                Toast.makeText(getActivity(), menu.getMenuName()  +"이(가) "+ quantity + "개 추가되었습니다.", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), order.get(order.size()-1).getOrderMenu(), Toast.LENGTH_SHORT).show();
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
