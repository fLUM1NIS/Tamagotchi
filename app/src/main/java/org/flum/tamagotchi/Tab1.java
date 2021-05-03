package org.flum.tamagotchi;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.xmlpull.v1.XmlPullParser;

import java.util.zip.Inflater;

public class Tab1 extends Fragment {

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab1, container, false);
        //View view = inflater.onCreateView(drawPerson, this, "12", )
        //return new DrawPerson(getContext());
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new DrawPerson(this));
    }
}
