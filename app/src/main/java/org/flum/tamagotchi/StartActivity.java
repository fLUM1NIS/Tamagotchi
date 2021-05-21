package org.flum.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    public static void Drink_SA () {
        Person.Drink();
    }

    SharedPreferences sharedPreferences2;
    public String IS_IT_FIRST = "SAVED_IS_IT_FIRST";

    Person person = new Person();

    public static boolean isItFirstStart;
    public Button startButton;
    Intent intent;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        startButton = findViewById(R.id.StartButton);
        startButton.setOnClickListener(this);




//        if (isItFirstStart == false) {
//            intent2 = new Intent(this, MainActivity.class);
//            startActivity(intent2);
//        }


        System.out.println("OnCreate " + isItFirstStart);

        Check();

    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
        loadData();
    }

    @Override
    protected void onStop() {
        saveData();
        super.onStop();
        saveData();
    }

    void saveData() {
        sharedPreferences2 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putBoolean(IS_IT_FIRST, StartActivity.isItFirstStart);
        editor.commit();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        sharedPreferences2 = getPreferences(MODE_PRIVATE);
        boolean savedIsItFirst = sharedPreferences2.getBoolean(IS_IT_FIRST, true);

        StartActivity.isItFirstStart = savedIsItFirst;

        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }

    public void Check() {


        if (isItFirstStart == true) {
            intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
            System.out.println("Check " + isItFirstStart);
        }
    }

    public void Start() {
        isItFirstStart = true;
        saveData();
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Start();
    }
}