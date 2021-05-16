package org.flum.tamagotchi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Person extends AppCompatActivity {

//    MainActivity mainActivity = new MainActivity();

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
        int rds = (int) Math.random() * 3;
        if (rds > 2) {
            //хорошее начало
            health = 100;
            drink = 100;
            eat = 100;
            toilet = 0;
            bored = 0;
            sleep = 100;
            shower = 0;
        } else {
            //плохое начало
            health = 67;
            drink = 86;
            eat = 89;
            toilet = 13;
            bored = 60;
            sleep = 70;
            shower = 20;
        }
    }

    public void Eat() {
        eat += 40;
    }

    public void Drink() {
        drink += 60;
    }

    public void play() {
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

    public void GoToToilet() {
        toilet -= (toilet - Math.random() * 60);
    }

    public void CheckDead() {
        //проверка показателей
        //если хоть 1 критический - проигрышь
        if (health < 0 || drink < 0 || eat < 0 || toilet > 100 || bored > 100 || sleep < 0 || shower > 100) {
            Dead();
        }
    }

    public void Dead() {
        Toast deadToast = Toast.makeText(getApplicationContext(), "dd", Toast.LENGTH_LONG);
        deadToast.show();
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
