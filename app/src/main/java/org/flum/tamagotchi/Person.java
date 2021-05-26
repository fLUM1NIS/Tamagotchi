package org.flum.tamagotchi;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Person extends AppCompatActivity {

//    MainActivity mainActivity = new MainActivity();

    public static IndicatorsView indicatorsView = new IndicatorsView();
    public static MainActivity mainActivity = new MainActivity();
    public static Activity activity = new Activity();
    public static Fragment fragment = new Fragment();

    Timer timer = new Timer();


    public static int HMWater;
    public static int HMEat;

     public static int health, drink, eat, toilet, bored, sleep, shower;
     public static int status; // 1 - good; 2 - normal; 3 - bad; 4 - awful; 5 - dead;

     TextView indicators;


    public static int getStatus() {
        return status;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Start();

        timer.start();

    }



    public void Start() {
        //рандомизация начальных показателей
        double rds = Math.random() * 1;
        if (rds > 0.3) {
            //хорошее начало
            health = (int) (Math.random() * 30 + 70);
            drink = (int) (Math.random() * 30 + 70);
            eat = (int) (Math.random() * 30 + 70);
            toilet = (int) (Math.random() * 30 + 70);
            bored = (int) (Math.random() * 30 + 70);
            sleep = (int) (Math.random() * 30 + 70);
            shower = (int) (Math.random() * 30 + 70);
        } else {
            //плохое начало
            health = (int) (Math.random() * 50 + 20);
            drink = (int) (Math.random() * 50 + 20);
            eat = (int) (Math.random() * 50 + 20);
            toilet = (int) (Math.random() * 50 + 20);
            bored = (int) (Math.random() * 50 + 20);
            sleep = (int) (Math.random() * 50 + 20);
            shower = (int) (Math.random() * 50 + 20);
        }
        StartActivity.isItFirstStart = true;
    }

    public static void Eat() {
        eat += (int) (Math.random() * 25 + 35);
        if (eat > 100) eat = eat - (eat - 100);
    }

    public static void Drink() {
        drink += (int) (Math.random() * 55 + 20);
        if (drink > 100) drink = drink - (drink - 100);
    }

    public static void Sleep() {
        sleep+= (int) (Math.random() * 25 + 35);
        if (sleep > 100) sleep = sleep - (sleep - 100);
    }

    public static void Rest() {
        sleep += (int) (Math.random() * 20 + 5);
        bored += (int) (Math.random() * 8 + 7);
        if (sleep > 100) sleep = sleep - (sleep - 100);
        if (bored > 100) bored = bored - (bored - 100);
    }

    public static void Fun() {
        bored += (int) (Math.random() * 25 + 35);
        if (bored > 100) bored = bored - (bored - 100);
    }

    public static void Play() {
        //поиграть в игру
        //для уменьшения скуки или добычи ресурсов
        // // //ПОТОМ расчёт повышения интереса от времяни игры
        int rd = (int) Math.random() * 5;
        if (rd > 2) {
            //скучная игра
            bored += 30;
            if (bored > 100) bored = bored - (bored - 100);
        } else {
            //интересная игра
            bored += 60;
            if (bored > 100) bored = bored - (bored - 100);
        }
    }



    public int CheckStatus() {
        if (((health * drink * eat * toilet * bored * sleep * shower) / 7) > 80 && ((health * drink * eat * toilet * bored * sleep * shower) / 7) < 101) {
            status = 1; // (good)
        }
        if (((health * drink * eat * toilet * bored * sleep * shower) / 7) > 60 && ((health * drink * eat * toilet * bored * sleep * shower) / 7) < 80) {
            status = 2; // (normal)
        }
        if (((health * drink * eat * toilet * bored * sleep * shower) / 7) > 40 && ((health * drink * eat * toilet * bored * sleep * shower) / 7) < 60) {
            status = 3; // (bad)
        }
        if (((health * drink * eat * toilet * bored * sleep * shower) / 7) > 0 && ((health * drink * eat * toilet * bored * sleep * shower) / 7) < 40) {
            status = 4; // (awful)
        }
        return status;
    }

    public static void GoToToilet() {
        toilet += (toilet - Math.random() * 60);
        if (toilet > 100) toilet = toilet - (toilet - 100);
    }

    public static void GoShower() {
        shower += (int) (Math.random() * 25 + 35);
        if (shower > 100) shower = shower - (shower - 100);
    }

    public static void CheckDead() {
        //проверка показателей
        //если хоть 1 критический - проигрышь
        if (health < 1) {
            Dead();
        }
    }

    public static void Dead() {
        Intent intent = new Intent (mainActivity, StartActivity.class);
        activity.startActivity(intent);
    }

    public void update () {

    }




    class Timer extends CountDownTimer  {

        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public Timer () {
            super(Integer.MAX_VALUE, 60);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            CheckDead();
            indicatorsView.UpdateIndicators();
        }

        @Override
        public void onFinish() {

        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getBored() {
        return bored;
    }

    public void setBored(int bored) {
        this.bored = bored;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getShower() {
        return shower;
    }

    public void setShower(int shower) {
        this.shower = shower;
    }

    public static void setStatus(int status) {
        Person.status = status;
    }
}
