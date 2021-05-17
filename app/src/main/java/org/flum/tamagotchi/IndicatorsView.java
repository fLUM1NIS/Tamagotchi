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

    TextView indHealth, indDrink, indEat, indToilet, indBored, indSleep, indShower;
    ProgressBar indHealthBar, indDrinkBar, indEatBar, indToiletBar, indBoredBar, indSleepBar, indShowerBar;
    TextView indHealthInt, indDrinkInt, indEatInt, indToiletInt, indBoredInt, indSleepInt, indShowerInt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indicators_view, container, false);

//        ind = view.findViewById(R.id.ind);
//        indInt = view.findViewById(R.id.indInt);
//        indBar = view.findViewById(R.id.indBar);
//        ind.setText("");
//        indInt.setText(String.valueOf(Person.));
//        indBar.setProgress(Person.);

        indHealth = view.findViewById(R.id.indHealth);
        indHealthInt = view.findViewById(R.id.indHealthInt);
        indHealthBar = view.findViewById(R.id.IndHealthBar);
        indHealth.setText(R.string.upHealth);
        indHealthInt.setText(String.valueOf(Person.health));
        indHealthBar.setProgress(Person.health);

        indDrink = view.findViewById(R.id.indDrink);
        indDrinkInt = view.findViewById(R.id.indDrinkInt);
        indDrinkBar = view.findViewById(R.id.indDrinkBar);
        indDrink.setText(R.string.upDrink);
        indDrinkInt.setText(String.valueOf(Person.drink));
        indDrinkBar.setProgress(Person.drink);

        indEat = view.findViewById(R.id.indEat);
        indEatInt = view.findViewById(R.id.indEatInt);
        indEatBar = view.findViewById(R.id.indEatBar);
        indEat.setText(R.string.upEat);
        indEatInt.setText(String.valueOf(Person.eat));
        indEatBar.setProgress(Person.eat);

        indToilet = view.findViewById(R.id.indToilet);
        indToiletInt = view.findViewById(R.id.indToiletInt);
        indToiletBar = view.findViewById(R.id.indToiletBar);
        indToilet.setText(R.string.upToilet);
        indToiletInt.setText(String.valueOf(Person.toilet));
        indToiletBar.setProgress(Person.toilet);

        indBored = view.findViewById(R.id.indBored);
        indBoredInt = view.findViewById(R.id.indBoredInt);
        indBoredBar = view.findViewById(R.id.indBoredBar);
        indBored.setText(R.string.upBored);
        indBoredInt.setText(String.valueOf(Person.bored));
        indBoredBar.setProgress(Person.bored);

        indSleep = view.findViewById(R.id.indSleep);
        indSleepInt = view.findViewById(R.id.indSleepInt);
        indSleepBar = view.findViewById(R.id.indSleepBar);
        indSleep.setText(R.string.upSleep);
        indSleepInt.setText(String.valueOf(Person.sleep));
        indSleepBar.setProgress(Person.sleep);

        indShower = view.findViewById(R.id.indShower);
        indShowerInt = view.findViewById(R.id.indShowerInt);
        indShowerBar = view.findViewById(R.id.indShowerBar);
        indShower.setText(R.string.upShower);
        indShowerInt.setText(String.valueOf(Person.shower));
        indShowerBar.setProgress(Person.shower);

        return view;
        //return new test(getContext());
    }
}
