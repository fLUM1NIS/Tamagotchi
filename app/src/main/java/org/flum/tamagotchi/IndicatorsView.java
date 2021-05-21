package org.flum.tamagotchi;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IndicatorsView extends Fragment {

    TextView nickName;
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


        nickName = view.findViewById(R.id.nickName);
        nickName.setText("YoUr_NiCk");


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


    class Timer extends CountDownTimer  {

        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public Timer () {
            super(Integer.MAX_VALUE, 10000);
        }

        @Override
        public void onTick(long millisUntilFinished) {



        }

        @Override
        public void onFinish() {

        }
    }

    public TextView getIndHealth() {
        return indHealth;
    }
    public void setIndHealth(TextView indHealth) {
        this.indHealth = indHealth;
    }
    public TextView getIndDrink() {
        return indDrink;
    }
    public void setIndDrink(TextView indDrink) {
        this.indDrink = indDrink;
    }
    public TextView getIndEat() {
        return indEat;
    }
    public void setIndEat(TextView indEat) {
        this.indEat = indEat;
    }
    public TextView getIndToilet() {
        return indToilet;
    }
    public void setIndToilet(TextView indToilet) {
        this.indToilet = indToilet;
    }
    public TextView getIndBored() {
        return indBored;
    }
    public void setIndBored(TextView indBored) {
        this.indBored = indBored;
    }
    public TextView getIndSleep() {
        return indSleep;
    }
    public void setIndSleep(TextView indSleep) {
        this.indSleep = indSleep;
    }
    public TextView getIndShower() {
        return indShower;
    }
    public void setIndShower(TextView indShower) {
        this.indShower = indShower;
    }
    public ProgressBar getIndHealthBar() {
        return indHealthBar;
    }
    public void setIndHealthBar(ProgressBar indHealthBar) {
        this.indHealthBar = indHealthBar;
    }
    public ProgressBar getIndDrinkBar() {
        return indDrinkBar;
    }
    public void setIndDrinkBar(ProgressBar indDrinkBar) {
        this.indDrinkBar = indDrinkBar;
    }
    public ProgressBar getIndEatBar() {
        return indEatBar;
    }
    public void setIndEatBar(ProgressBar indEatBar) {
        this.indEatBar = indEatBar;
    }
    public ProgressBar getIndToiletBar() {
        return indToiletBar;
    }
    public void setIndToiletBar(ProgressBar indToiletBar) {
        this.indToiletBar = indToiletBar;
    }
    public ProgressBar getIndBoredBar() {
        return indBoredBar;
    }
    public void setIndBoredBar(ProgressBar indBoredBar) {
        this.indBoredBar = indBoredBar;
    }
    public ProgressBar getIndSleepBar() {
        return indSleepBar;
    }
    public void setIndSleepBar(ProgressBar indSleepBar) {
        this.indSleepBar = indSleepBar;
    }
    public ProgressBar getIndShowerBar() {
        return indShowerBar;
    }
    public void setIndShowerBar(ProgressBar indShowerBar) {
        this.indShowerBar = indShowerBar;
    }
    public TextView getIndHealthInt() {
        return indHealthInt;
    }
    public void setIndHealthInt(TextView indHealthInt) {
        this.indHealthInt = indHealthInt;
    }
    public TextView getIndDrinkInt() {
        return indDrinkInt;
    }
    public void setIndDrinkInt(TextView indDrinkInt) {
        this.indDrinkInt = indDrinkInt;
    }
    public TextView getIndEatInt() {
        return indEatInt;
    }
    public void setIndEatInt(TextView indEatInt) {
        this.indEatInt = indEatInt;
    }
    public TextView getIndToiletInt() {
        return indToiletInt;
    }
    public void setIndToiletInt(TextView indToiletInt) {
        this.indToiletInt = indToiletInt;
    }
    public TextView getIndBoredInt() {
        return indBoredInt;
    }
    public void setIndBoredInt(TextView indBoredInt) {
        this.indBoredInt = indBoredInt;
    }
    public TextView getIndSleepInt() {
        return indSleepInt;
    }
    public void setIndSleepInt(TextView indSleepInt) {
        this.indSleepInt = indSleepInt;
    }
    public TextView getIndShowerInt() {
        return indShowerInt;
    }
    public void setIndShowerInt(TextView indShowerInt) {
        this.indShowerInt = indShowerInt;
    }
}
