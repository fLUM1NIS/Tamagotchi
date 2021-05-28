package org.flum.tamagotchi;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
//import android.app.Fragment;

import static org.flum.tamagotchi.Person.bored;
import static org.flum.tamagotchi.Person.drink;
import static org.flum.tamagotchi.Person.eat;
import static org.flum.tamagotchi.Person.health;
import static org.flum.tamagotchi.Person.shower;
import static org.flum.tamagotchi.Person.sleep;
import static org.flum.tamagotchi.Person.toilet;

public class IndicatorsView extends Fragment {


    Bundle bundle = new Bundle();
    Fragment fragment;
//    public FragmentActivity viewP = getActivity();

    //public Timer timer = new Timer();

    public boolean isTimerWork;

    EditText enterName;
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

//        enterName = view.findViewById(R.id.EnterNickName);  //.findViewById(R.id.EnterNickName);
        nickName = view.findViewById(R.id.nickName);
        nickName.setText(StartActivity.enterName.getText().toString());
        //nickName.setText(MainActivity.nick);
        //nickName.setText(StartActivity.intent.getStringExtra("enterName"));
//        nickName.setText(enterName.getText().toString());

        indHealth = view.findViewById(R.id.indHealth);
        indHealthInt = view.findViewById(R.id.indHealthInt);
        indHealthBar = view.findViewById(R.id.indHealthBar);
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

        //timer.start();

        return view;
        //return new test(getContext());
    }

    @Override
    public void onResume() {
        UpdateIndicators();
        super.onResume();
    }

    public void UpdateIndicators() {
        nickName = getActivity().findViewById(R.id.nickName);
        if (StartActivity.isItFirstStart == true) {
            Log.d("what", "(IndicatorsView) enterNick = " + StartActivity.enterName.getText().toString());
            nickName.setText(StartActivity.enterName.getText().toString());
        }
        else {
            nickName.setText(MainActivity.nick);
        }


        Log.d("what", "(IndicatorsView) enterNick = " + StartActivity.enterName.getText().toString());
        nickName.setText(StartActivity.enterName.getText().toString());

        indHealth = getActivity().findViewById(R.id.indHealth);
        //indHealth = viewP.findViewById(R.id.indHealth);
        indHealthInt = getActivity().findViewById(R.id.indHealthInt);
        indHealthBar = getActivity().findViewById(R.id.indHealthBar);
        indHealth.setText(R.string.upHealth);
        indHealthInt.setText(String.valueOf(Person.health));
        indHealthBar.setProgress(Person.health);

        indDrink = getActivity().findViewById(R.id.indDrink);
        indDrinkInt = getActivity().findViewById(R.id.indDrinkInt);
        indDrinkBar = getActivity().findViewById(R.id.indDrinkBar);
        indDrink.setText(R.string.upDrink);
        indDrinkInt.setText(String.valueOf(Person.drink));
        indDrinkBar.setProgress(Person.drink);

        indEat = getActivity().findViewById(R.id.indEat);
        indEatInt = getActivity().findViewById(R.id.indEatInt);
        indEatBar = getActivity().findViewById(R.id.indEatBar);
        indEat.setText(R.string.upEat);
        indEatInt.setText(String.valueOf(Person.eat));
        indEatBar.setProgress(Person.eat);

        indToilet = getActivity().findViewById(R.id.indToilet);
        indToiletInt = getActivity().findViewById(R.id.indToiletInt);
        indToiletBar = getActivity().findViewById(R.id.indToiletBar);
        indToilet.setText(R.string.upToilet);
        indToiletInt.setText(String.valueOf(Person.toilet));
        indToiletBar.setProgress(Person.toilet);

        indBored = getActivity().findViewById(R.id.indBored);
        indBoredInt = getActivity().findViewById(R.id.indBoredInt);
        indBoredBar = getActivity().findViewById(R.id.indBoredBar);
        indBored.setText(R.string.upBored);
        indBoredInt.setText(String.valueOf(Person.bored));
        indBoredBar.setProgress(Person.bored);

        indSleep = getActivity().findViewById(R.id.indSleep);
        indSleepInt = getActivity().findViewById(R.id.indSleepInt);
        indSleepBar = getActivity().findViewById(R.id.indSleepBar);
        indSleep.setText(R.string.upSleep);
        indSleepInt.setText(String.valueOf(Person.sleep));
        indSleepBar.setProgress(Person.sleep);

        indShower = getActivity().findViewById(R.id.indShower);
        indShowerInt = getActivity().findViewById(R.id.indShowerInt);
        indShowerBar = getActivity().findViewById(R.id.indShowerBar);
        indShower.setText(R.string.upShower);
        indShowerInt.setText(String.valueOf(Person.shower));
        indShowerBar.setProgress(Person.shower);

        System.out.println("Update Ind");
    }
}
