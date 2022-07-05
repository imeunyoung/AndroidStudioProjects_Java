package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainFragment extends Fragment {
    //프래그먼트는 액티비티 위에 올라갔을 때 비로소 프래그먼트로서 동작할 수 있기 때문에 액티비티 위에 올라갈 때
    //onAttach, 액티비티에서 내려올 때 onDetach 메소드를 자동으로 호출해줌으로써 그 시점을 알 수 있도록 해 줍니다.
    //onAttach 가 onCreate보다 먼저 호출됨
    MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);

        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(1);
            }
        });

        return rootView;
    }
}
