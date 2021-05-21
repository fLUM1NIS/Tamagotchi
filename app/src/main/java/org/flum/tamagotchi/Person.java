package org.flum.tamagotchi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Person extends AppCompatActivity {

//    MainActivity mainActivity = new MainActivity();

    IndicatorsView indicatorsView = new IndicatorsView();

    public static int HMWater;
    public static int UMEat;

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
    }

    public void Start() {
        //рандомизация начальных показателей
        double rds = Math.random() * 1;
        if (rds > 0.3) {
            //хорошее начало
            health = (int) (Math.random() * 30 + 70);
            drink = (int) (Math.random() * 30 + 70);
            eat = (int) (Math.random() * 30 + 70);
            toilet = (int) (Math.random() * 10 + 5);
            bored = (int) (Math.random() * 10 + 5);
            sleep = (int) (Math.random() * 30 + 70);
            shower = (int) (Math.random() * 10 + 5);
        } else {
            //плохое начало
            health = (int) (Math.random() * 50 + 20);
            drink = (int) (Math.random() * 50 + 20);
            eat = (int) (Math.random() * 50 + 20);
            toilet = (int) (Math.random() * 15 + 15);
            bored = (int) (Math.random() * 15 + 15);
            sleep = (int) (Math.random() * 50 + 20);
            shower = (int) (Math.random() * 15 + 15);
        }
        StartActivity.isItFirstStart = true;
    }

    public static void Eat() {
        eat += (int) (Math.random() * 25 + 35);
    }

    public static void Drink() {
        drink += (int) (Math.random() * 55 + 20);
    }

    public static void play() {
        //поиграть в игру
        //для уменьшения скуки или добычи ресурсов
        // // //ПОТОМ расчёт повышения интереса от времяни игры
        int rd = (int) Math.random() * 5;
        if (rd > 2) {
            //скучная игра
            bored += 30;
        } else {
            //интересная игра
            bored += 60;
        }
    }

//    public int CheckStatus() {
//        if (health > 50 && drink > 50 && eat > 50 && toilet < 50 && bored < 50 && sleep > 50 && shower < 50) {
//            //status = 3; // (normal)
//        }
//        return status;
//    }

    public static void GoToToilet() {
        toilet -= (toilet - Math.random() * 60);
    }

    public static void CheckDead() {
        //проверка показателей
        //если хоть 1 критический - проигрышь
        if (health < 1 || drink < 1 || eat < 1 || toilet > 100 || bored > 100 || sleep < 1 || shower > 100) {
            Dead();
        }
    }

    public static void Dead() {
        //Toast deadToast = Toast.makeText(getApplicationContext(), "dd", Toast.LENGTH_LONG);
        //deadToast.show();
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
