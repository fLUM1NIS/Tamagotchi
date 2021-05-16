package org.flum.tamagotchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static org.flum.tamagotchi.Person.bored;
import static org.flum.tamagotchi.Person.drink;
import static org.flum.tamagotchi.Person.eat;
import static org.flum.tamagotchi.Person.health;
import static org.flum.tamagotchi.Person.shower;
import static org.flum.tamagotchi.Person.sleep;
import static org.flum.tamagotchi.Person.status;
import static org.flum.tamagotchi.Person.toilet;

//import kotlinx.coroutines.scheduling.NanoTimeSource;

        public class MainActivity extends AppCompatActivity {

            Person person = new Person();
            public TextView indicators;
            EditText editText;

            SharedPreferences sharedPreferences;
            View view;

            public String NAME_HEALTH = "SAVED_HEALTH";
            public String NAME_DRINK = "SAVED_DRINK";
            public String NAME_EAT = "SAVED_EAT";
            public String NAME_TOILET = "SAVED_TOILET";
            public String NAME_BORED = "SAVED_BORED";
            public String NAME_SLEEP = "SAVED_SLEEP";
            public String NAME_SHOWER = "SAVED_SHOWER";

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

                fab.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                    }
                });

                //IndicatorsView indicatorFragment = getFragmentManager().findFragmentById(R.id.indicators_view);
                //indicators = indicatorFragment.getView().findViewById(R.id.ind);
                //indicatorFragment.getView().findViewById(R.id.ind);
                //indicators.setText("erererer");



                //indicators = findViewById(R.id.ind);

                String stHea = Integer.toString(health);
//                indicators.setText("");

                person.Start();

            }

            @Override
            protected void onStop() {
                super.onStop();
                saveData();
            }

            @Override
            protected void onResume() {
                super.onResume();
                loadData();
                if (health < 1) {
                    person.Start();
                }

                status = 2;
                System.out.println("Status: " + status);
            }

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
                editor.commit();

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            }

            void loadData() {
                sharedPreferences = getPreferences(MODE_PRIVATE);
                int savedHealth = sharedPreferences.getInt(NAME_HEALTH, -1);
                int savedDrink = sharedPreferences.getInt(NAME_DRINK, -1);
                int savedEat = sharedPreferences.getInt(NAME_EAT, -1);
                int savedToilet = sharedPreferences.getInt(NAME_TOILET, -1);
                int savedBored = sharedPreferences.getInt(NAME_BORED, -1);
                int savedSleep = sharedPreferences.getInt(NAME_SLEEP, -1);
                int savedShower = sharedPreferences.getInt(NAME_SHOWER, -1);

                health = savedHealth;
                drink = savedDrink;
                eat = savedEat;
                toilet = savedToilet;
                bored = savedBored;
                sleep = savedSleep;
                shower = savedShower;

                Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
            }

            public static class SectionsPagerAdapter extends FragmentPagerAdapter {

                @StringRes
                private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
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
//                            Tab1 tab1 = new Tab1();
//                            return tab1;
                            return new Tab1();
                        case 1:
//                            Tab2 tab2 = new Tab2();
//                            return tab2;
                            return new Tab2();
                        case 2:
//                            Tab3 tab3 = new Tab3();
//                            return tab3;
                            return new Tab3();
                        case 3:
//                            Tab4 tab4 = new Tab4();
//                            return tab4;
                            return new Tab4();
                        default:
                            return null;
                    }
                }



                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    //return mContext.getResources().getString(TAB_TITLES[position]);

                    switch (position) {
                        case 0:
                            return "Kitchen";
                        case 1:
                            return "Bedroom";
                        case 2:
                            return "Livingroom";
                        case 3:
                            return "Bathroom";
                    }
                    return null;
                }

                @Override
                public int getCount() {
                    // Show 3 total pages.
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

//                @Override
//                public void onCreate(Bundle savedInstanceState) {
//                    super.onCreate(savedInstanceState);
////                    pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
//                    int index = 1;
//                    if (getArguments() != null) {
//                        index = getArguments().getInt(ARG_SECTION_NUMBER);
//                    }
////                    pageViewModel.setIndex(index);
//                }

//                @Override
//                public View onCreateView(
//                        @NonNull LayoutInflater inflater, ViewGroup container,
//                        Bundle savedInstanceState) {
//                    View root = inflater.inflate(R.layout.tab1, container, false);
//                    final TextView textView = root.findViewById(R.id.section_label);
//                    pageViewModel.getText().observe(this, new Observer<String>() {
//                        @Override
//                        public void onChanged(@Nullable String s) {
//                            textView.setText(s);
//                        }
//                    });
//                    return root;
//                }
//            }

            }
        }

