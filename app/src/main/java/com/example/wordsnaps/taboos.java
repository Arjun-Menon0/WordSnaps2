package com.example.wordsnaps;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class taboos extends AppCompatActivity {
    public static final int[] celebImg = {R.drawable.c1, R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6, R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10};
    public static final int[] fictionalImg = {R.drawable.f1, R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6, R.drawable.f7,R.drawable.f8,R.drawable.f9,R.drawable.f10};
    public static final int[] mixImg = {R.drawable.c1, R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.f1, R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5};
    public static int[] numsUsed = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
    int generatedNum;
    public static int correct =0;
    public static int skip = 0;
    public static int millisLeft = 30000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taboos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public int genNum() {
        while (true) {
            boolean state = true;
            generatedNum= (int) (Math.random() * 10);
            for (int i = 0; i < 10; i++) {
                if (numsUsed[i] == generatedNum) {
                    state = false;
                }
            }
            if (state) {
                numsUsed[generatedNum] = generatedNum;
                //System.out.println(generatedNum);
                //System.out.print(numsUsed[generatedNum]);
                return generatedNum;
            }


        }
    }
    public int[] getMixImg()
    {
        return mixImg;
    }
    public int[] getCelebImg()
    {
        return celebImg;
    }
    public int[] getFictionalImg()
    {
        return fictionalImg;
    }
    public void resetNum(){for(int i=0;i<10;i++){
    numsUsed[i] = -1;}
    }
    public int getCorrect() {return correct;}
    public int getSkip() {return skip;}
    public void correct() {correct++;}
    public void skip() {skip++;}
    public void resetSkip(){skip = 0;}
    public void resetCorrect(){correct = 0;}
    public int getMillis(){return millisLeft;}
    public void setMillis(int passed){millisLeft -= passed;}
    public void resetMillis(){millisLeft = 30000;}

}
