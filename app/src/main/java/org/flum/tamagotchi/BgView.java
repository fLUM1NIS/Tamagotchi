package org.flum.tamagotchi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BgView extends View {

    public BgView(Context context) {
        super(context);
    }

    public static class View1 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.bg_view_1, container, false);

            // теперь можем получить наши элементы, расположенные во фрагменте
            Button button_drink = (Button) view.findViewById(R.id.button_drink);
            Button button_eat = (Button) view.findViewById(R.id.button_eat);
            button_drink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Drink", Toast.LENGTH_SHORT).show();
                }
            });
            button_eat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Eat", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }

    public static class View2 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.bg_view_2, container, false);

            // теперь можем получить наши элементы, расположенные во фрагменте
            Button button_sleep = (Button) view.findViewById(R.id.button_sleep);
            Button button_rest = (Button) view.findViewById(R.id.button_rest);
            button_sleep.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Sleep", Toast.LENGTH_SHORT).show();
                }
            });
            button_rest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Rest", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }

    public static class View3 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.bg_view_3, container, false);

            // теперь можем получить наши элементы, расположенные во фрагменте
            Button button_fun = (Button) view.findViewById(R.id.button_fun);
            Button button_play = (Button) view.findViewById(R.id.button_play);
            button_fun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Fun", Toast.LENGTH_SHORT).show();
                }
            });
            button_play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Play", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }


    public static class View4 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.bg_view_4, container, false);

            // теперь можем получить наши элементы, расположенные во фрагменте
            Button button_toilet = (Button) view.findViewById(R.id.button_toilet);
            Button button_bath = (Button) view.findViewById(R.id.button_bath);
            button_toilet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Toilet", Toast.LENGTH_SHORT).show();
                }
            });
            button_bath.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Bath", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }


}
