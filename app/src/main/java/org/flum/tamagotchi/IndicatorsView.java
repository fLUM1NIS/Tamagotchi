package org.flum.tamagotchi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IndicatorsView extends Fragment {

    TextView indHealth;
    TextView indDrink;
    TextView indEat;
    TextView indToilet;
    ProgressBar pb1;
    TextView indHealthInt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indicators_view, container, false);

        indHealth = view.findViewById(R.id.indHealth);
        indHealthInt = view.findViewById(R.id.indHealthInt);
        pb1 = view.findViewById(R.id.IndHealthBar);
        indHealth.setText("Health");
        indHealthInt.setText(String.valueOf(Person.health));
        pb1.setProgress(Person.health);

        //indDrink = view.findViewById(R.id.ind)

        return view;
        //return new test(getContext());
    }
}
