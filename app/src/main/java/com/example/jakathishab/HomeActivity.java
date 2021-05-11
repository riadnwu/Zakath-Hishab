package com.example.jakathishab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;

public class HomeActivity extends AppCompatActivity {

    private EditText[] inputValue;
    private TextView jakatView;
    private double nesab,sonaText,rupaText;
    private double sompod=0,ren=0,sum=0,jakat=0,sona=0,rupa=0,tempSona=0,tempRupa=0;
    private int list[]={R.id.inputNumber2,R.id.inputNumber3,R.id.inputNumber4,R.id.inputNumber5,R.id.inputNumber6,R.id.inputNumber7,
                        R.id.inputNumber8,R.id.inputNumber9,R.id.inputNumber10,R.id.inputNumber11,R.id.inputNumber12,R.id.inputNumber13,
                        R.id.inputNumber15,R.id.inputNumber16,R.id.inputNumber17,R.id.inputNumber18,R.id.inputNumber19,R.id.inputNumber20,
                        R.id.inputNumber21,R.id.inputNumber22,R.id.inputNumber23,R.id.inputNumber24,R.id.inputNumber25};

    public void declearVariable()
    {
        Bundle bundel=getIntent().getExtras();
        if(bundel!=null)
        {
            nesab=bundel.getDouble("nesab");
            sonaText=bundel.getDouble("sona");
            rupaText=bundel.getDouble("rupa");
        }

        jakatView=(TextView) findViewById(R.id.hishabView);
        inputValue=new EditText[23];
        for (int i=0;i<23;i++)
        {
            inputValue[i]=(EditText) findViewById(list[i]);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jakat_hishab);

        declearVariable();
        jakathHishab();
        sonarHishab();
        rupaHishab();
    }

    public void conditionCheck(double sona,double rupa,double sompod,double ren)
    {
        double temp=(double) Math.round(sona+sompod+rupa);
        sum=(double) Math.round(temp-ren);

        if(tempSona>=7.5 && sompod==0)
        {
            jakatView.setText("মোট সম্পদের পরিমাণ : "+temp+ " টাকা\nমোট ঋণের পরিমাণ : "+ ren+" টাকা\nঋণ বিয়োগ করে : "+ sum+" টাকা\nযাকাতের পরিমাণ : "+Math.round((sum*2.5)/100)+" টাকা");
        }
        else if((sompod != 0 || rupa!=0)  && sum>=nesab)
        {
            jakatView.setText("মোট সম্পদের পরিমাণ : "+temp+ " টাকা\nমোট ঋণের পরিমাণ : "+ ren+" টাকা\nঋণ বিয়োগ করে : "+ sum+" টাকা\nযাকাতের পরিমাণ : "+Math.round((sum*2.5)/100)+" টাকা");
        }
        else
        {
            jakatView.setText("মোট সম্পদের পরিমাণ : "+temp+ " টাকা\nমোট ঋণের পরিমাণ : "+ ren+" টাকা\nঋণ বিয়োগ করে : "+ sum+" টাকা\nযাকাতের পরিমাণ : 0 টাকা");
        };
    }
    public void rupaHishab()
    {
        inputValue[1].addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 rupa=0;
                 tempRupa=0;
                 try {
                     tempRupa=Double.parseDouble(inputValue[1].getText().toString());
                 }catch (NumberFormatException e) {
                     tempRupa=0;
                 }

                 rupa=tempRupa*rupaText;
                 conditionCheck(sona,rupa,sompod,ren);
             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         }

        );
    }

    public void sonarHishab()
    {
        inputValue[0].addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 sona=0;
                 tempSona=0;
                 try {
                 tempSona=Double.parseDouble(inputValue[0].getText().toString());
                     }catch (NumberFormatException e) {
                     tempSona=0;
                     }

                 sona=tempSona*sonaText;
                 conditionCheck(sona,rupa,sompod,ren);
             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         }

        );
    }
   public void jakathHishab()
    {

        for (int i=2;i<12;i++)
        {
            inputValue[i].addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                     sompod=0;
                     for (int i=2;i<12;i++)
                     {
                         try {
                             sompod=sompod+ Double.parseDouble(inputValue[i].getText().toString());
                         }catch (NumberFormatException e) {
                             sompod=sompod+0;
                         }
                     }
                     conditionCheck(sona,rupa,sompod,ren);
                 }

                 @Override
                 public void afterTextChanged(Editable s) {

                 }
             }

            );
        }
        for (int i=12;i<23;i++)
        {
            inputValue[i].addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                     ren=0;
                     for (int i=12;i<23;i++)
                     {
                         try {
                             ren=ren+ Double.parseDouble(inputValue[i].getText().toString());
                         }catch (NumberFormatException e) {
                         }
                     }
                     conditionCheck(sona,rupa,sompod,ren);
                 }

                 @Override
                 public void afterTextChanged(Editable s) {

                 }
             }

            );
        }
    }
}