package org.flum.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    public static void Drink_SA () {
        Person.Drink();
    }

    SharedPreferences sharedPreferences2;
    public String IS_IT_FIRST = "SAVED_IS_IT_FIRST";

    public static EditText enterName;

    Person person = new Person();

    public static boolean isItFirstStart;
    public Button startButton;
    public static Intent intent;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        startButton = findViewById(R.id.StartButton);
        startButton.setOnClickListener(this);
        enterName = findViewById(R.id.EnterNickName);
        //MainActivity.nick = enterName.getText().toString();

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
    }

    public void loadData() {
        sharedPreferences2 = getPreferences(MODE_PRIVATE);
        boolean savedIsItFirst = sharedPreferences2.getBoolean(IS_IT_FIRST, true);

        StartActivity.isItFirstStart = savedIsItFirst;
    }

    public void Check() {


        if (isItFirstStart == true) {
            intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }
    }

    public void Start() {
        isItFirstStart = true;
        saveData();
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("enterName", enterName.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Start();
    }
}