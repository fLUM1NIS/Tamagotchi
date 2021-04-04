package org.flum.tamagotchi;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Person extends AppCompatActivity {

     private float health, drink, eat, toilet, bored, sleep;
     public static int status;

    public static int getStatus() {
        return status;
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
        } else {
            //плохое начало
            health = 67;
            drink = 86;
            eat = 89;
            toilet = 13;
            bored = 60;
            sleep = 70;
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

    public int CheckStatus() {
        if (health < 50 || drink < 50 || eat < 50 || toilet > 50 || bored > 50 || sleep < 50) {
            status = 3; // (normal)
        }
        return status;
    }

    public void GoToToilet() {
        toilet -= (toilet - Math.random() * 12);
    }

    public void CheckDead() {
        //проверка показателей
        //если хоть 1 критический - проигрышь
        if (health == 0 || drink == 0 || eat == 0 || toilet == 100 || bored == 100 || sleep == 0) {
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


}
