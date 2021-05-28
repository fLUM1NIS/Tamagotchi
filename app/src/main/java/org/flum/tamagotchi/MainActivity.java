package org.flum.tamagotchi;

import androidx.fragment.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import static org.flum.tamagotchi.Person.bored;
import static org.flum.tamagotchi.Person.drink;
import static org.flum.tamagotchi.Person.eat;
import static org.flum.tamagotchi.Person.health;
import static org.flum.tamagotchi.Person.mainActivity;
import static org.flum.tamagotchi.Person.shower;
import static org.flum.tamagotchi.Person.sleep;
import static org.flum.tamagotchi.Person.status;
import static org.flum.tamagotchi.Person.toilet;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    //IndicatorsView indicatorsView = new IndicatorsView();
    android.app.Fragment fragment = getFragmentManager().findFragmentById(R.id.indicators_view);
    FragmentManager fragmentManager = getSupportFragmentManager();
    String ickName;
    public static int points = 3;

    public String NAME_HEALTH = "SAVED_HEALTH";
    public String NAME_DRINK = "SAVED_DRINK";
    public String NAME_EAT = "SAVED_EAT";
    public String NAME_TOILET = "SAVED_TOILET";
    public String NAME_BORED = "SAVED_BORED";
    public String NAME_SLEEP = "SAVED_SLEEP";
    public String NAME_SHOWER = "SAVED_SHOWER";
    public String NAME_NICK = "SAVED_NICK";
    public String NAME_HM_WATER = "SAVED_WATER";
    public String NAME_HM_EAT = "SAVED_EAT";

    public static String nick;

    EditText enterNick;

    public static Person person = new Person();
    public TextView indicators;
    EditText editText;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new DrawPerson(this));
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enterNick = findViewById(R.id.EnterNickName);
//        nick = enterNick.getText().toString();
          //nick =  StartActivity.intent.getStringExtra("enterName");
        nick = StartActivity.enterName.getText().toString();

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Еды: " + person.HMEat + "Воды: " + person.HMWater, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        person.timer.start();
        Log.d("Err", "Person timer started");

        //CheckStatus();

        person.Start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        if (health < 1) {
            person.Start();
        }
    }

    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }

//    public void CheckStatus() {
//        if (((health * drink * eat * toilet * bored * sleep * shower) / 7) > 1 && ((health * drink * eat * toilet * bored * sleep * shower) / 7) < 100) {
//            status = 2;
//        }
//        status =2;
//    }

    void saveData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NAME_HEALTH, health);
        editor.putInt(NAME_DRINK, drink);
        editor.putInt(NAME_EAT, eat);
        editor.putInt(NAME_TOILET, toilet);
        editor.putInt(NAME_BORED, bored);
        editor.putInt(NAME_SLEEP, sleep);
        editor.putInt(NAME_SHOWER, shower);
        editor.putInt(NAME_HM_WATER, person.HMWater);
        editor.putInt(NAME_HM_EAT, person.HMEat);
        editor.putString(NAME_NICK, nick);
        //editor.putBoolean("isItFirstStart", StartActivity.isItFirstStart);
        editor.commit();
    }

    public void loadData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        int savedHealth = sharedPreferences.getInt(NAME_HEALTH, -1);
        int savedDrink = sharedPreferences.getInt(NAME_DRINK, -1);
        int savedEat = sharedPreferences.getInt(NAME_EAT, -1);
        int savedToilet = sharedPreferences.getInt(NAME_TOILET, -1);
        int savedBored = sharedPreferences.getInt(NAME_BORED, -1);
        int savedSleep = sharedPreferences.getInt(NAME_SLEEP, -1);
        int savedShower = sharedPreferences.getInt(NAME_SHOWER, -1);
        int savedHMWater = sharedPreferences.getInt(NAME_HM_WATER, 5);
        int savedHMEat = sharedPreferences.getInt(NAME_HM_EAT, 5);
//        boolean savedIsItFirstStart = sharedPreferences.getBoolean("isItFirstStart", true);

        String savedNick = sharedPreferences.getString(NAME_NICK, "NiCk_nAmE");

        health = savedHealth;
        drink = savedDrink;
        eat = savedEat;
        toilet = savedToilet;
        bored = savedBored;
        sleep = savedSleep;
        shower = savedShower;
        person.HMWater = savedHMWater;
        person.HMEat = savedHMEat;
        nick = savedNick;
        //StartActivity.isItFirstStart = savedIsItFirstStart;

    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        @StringRes
        private static final int[] TAB_TITLES = new int[]{R.string.kitchen, R.string.bedroom, R.string.livingroom, R.string.bathroom};
        private final Context mContext;

        public SectionsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {

                   //return PlaceholderFragment.newInstance(position + 1);

            switch (position) {
                case 0:
                    return new Tab1();
                case 1:
                    return new Tab2();
                case 2:
                    return new Tab3();
                case 3:
                    return new Tab4();
                default:
                    return null;
            }
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    if (Locale.getDefault().getLanguage() == "ru") {
                        return "Кухня";
                    } else return "Kitchen";
                case 1:
                    if (Locale.getDefault().getLanguage() == "ru") {
                        return "Спальня";
                    } else return "Bedroom";
                case 2:
                    if (Locale.getDefault().getLanguage() == "ru") {
                        return "Зал";
                    } else return "Living" + "\n" + "room";
                case 3:
                    if (Locale.getDefault().getLanguage() == "ru") {
                        return "Ванна";
                    } else return "Bathroom";
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public class PageViewModel extends ViewModel {

        private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
        private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
            @Override
            public String apply(Integer input) {
                return "Hello world from section: " + input;
            }
        });

        public void setIndex(int index) {
            mIndex.setValue(index);
        }

        public LiveData<String> getText() {
            return mText;
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        private PageViewModel pageViewModel;

        public static PlaceholderFragment newInstance(int index) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_SECTION_NUMBER, index);
            fragment.setArguments(bundle);
            return fragment;
        }
    }
}

