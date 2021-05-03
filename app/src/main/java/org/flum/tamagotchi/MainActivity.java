package org.flum.tamagotchi;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//import kotlinx.coroutines.scheduling.NanoTimeSource;

        public class MainActivity extends AppCompatActivity {

            Person person = new Person();
            public static TextView indicators;
            EditText editText;

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
//                getWindow().setFlags(Window.FEATURE_NO_TITLE, Window.FEATURE_NO_TITLE);


                fab.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                    }
                });

                person.Start();

                indicators = (TextView) findViewById(R.id.indicators);



                //editText.setText("Health: " + Person.health);

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
                            Tab1 tab1 = new Tab1();
                            return tab1;
                        case 1:
                            Tab2 tab2 = new Tab2();
                            return tab2;
                        case 2:
                            Tab3 tab3 = new Tab3();
                            return tab3;
                        case 3:
                            Tab4 tab4 = new Tab4();
                            return tab4;
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

