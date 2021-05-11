package com.example.jakathishab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mainButton;
    EditText numberText,sonaText,rupaText;
    String[] sonaArray,rupaArray;
    Spinner sonaSpinner,rupaSpinner;
    ArrayList<SpinnerItem> sonaItem,rupaItem;
    SpinnerAdapter sonaAdapter,rupaAdapter;
    ArrayAdapter<String> sonaAdepter,rupaAdepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nesab);
        //initList();
        goToMain();
    }
    public void initList()
    {
        sonaItem=new ArrayList<>();
        sonaItem.add(new SpinnerItem("১৮ ক্যারেটের স্বর্ণের ভরি-","57192.30"));
        sonaItem.add(new SpinnerItem("২১ ক্যারেটের স্বর্ণের ভরি-","65937.30"));
        sonaItem.add(new SpinnerItem("২২ ক্যারেটের স্বর্ণের ভরি-","69085.50"));
        sonaItem.add(new SpinnerItem("সনাতন স্বর্ণের ভরি-","46873.20"));

        rupaItem=new ArrayList<>();
        rupaItem.add(new SpinnerItem("১৮ ক্যারেটের রুপার ভরি-","1224.30"));
        rupaItem.add(new SpinnerItem("২১ ক্যারেটের রুপার ভরি-","1434.18"));
        rupaItem.add(new SpinnerItem("২২ ক্যারেটের রুপার ভরি-","1515.80"));
        rupaItem.add(new SpinnerItem("সনাতন রুপার ভরি-","994.00"));
    }
    public void goToMain()
    {
        mainButton = (Button) findViewById(R.id.mainButton);
        numberText=(EditText) findViewById(R.id.neasbValue) ;
        sonaSpinner=(Spinner) findViewById(R.id.sonaSpinner);
        rupaSpinner=(Spinner) findViewById(R.id.rupaSpinner);
        sonaArray=getResources().getStringArray(R.array.sonalArray);
        rupaArray=getResources().getStringArray(R.array.rupaArray);

        /*sonaAdapter=new SpinnerAdapter(MainActivity.this,sonaItem);
        sonaSpinner.setAdapter(sonaAdapter);

        rupaAdapter=new SpinnerAdapter(MainActivity.this,rupaItem);
        rupaSpinner.setAdapter(rupaAdapter);*/

       sonaAdepter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.sonaView,sonaArray);
       rupaAdepter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.sonaView,rupaArray);
       sonaSpinner.setAdapter(sonaAdepter);
        rupaSpinner.setAdapter(rupaAdepter);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,HomeActivity.class);

              String sona=sonaSpinner.getSelectedItem().toString();

                String rupa=rupaSpinner.getSelectedItem().toString();


                if(sona.compareTo("১৮ ক্যারেটের স্বর্ণের ভরি-৫৭১৯২.৩০ টাকা")==0)
                {
                    intent.putExtra("sona",57192.30);
                }
                else if(sona.compareTo("২১ ক্যারেটের স্বর্ণের ভরি-৬৫৯৩৭.৩০ টাকা")==0)
                {
                    intent.putExtra("sona",65937.30);
                }
                else if(sona.compareTo("২২ ক্যারেটের স্বর্ণের ভরি-৬৯০৮৫.৫০ টাকা")==0)
                {
                    intent.putExtra("sona",69085.50);
                }
                else if(sona.compareTo("সনাতন স্বর্ণের ভরি-৪৬৮৭৩.২০ টাকা")==0)
                {
                    intent.putExtra("sona",46873.20);
                }

                if(rupa.compareTo("১৮ ক্যারেটের রুপার ভরি-১২২৪.৩০ টাকা")==0)
                {
                    intent.putExtra("rupa",1224.30);
                }
                else if(rupa.compareTo("২১ ক্যারেটের রুপার ভরি-১৪৩৪.১৮ টাকা")==0)
                {
                    intent.putExtra("rupa",1434.18);
                }
                else if(rupa.compareTo("২২ ক্যারেটের রুপার ভরি-১৫১৫.৮০ টাকা")==0)
                {
                    intent.putExtra("rupa",1515.80);
                }
                else if(rupa.compareTo("সনাতন রুপার ভরি-৯৩৩.০০ টাকা")==0)
                {
                    intent.putExtra("rupa",933.00);
                }

                intent.putExtra("nesab",Double.parseDouble(numberText.getText().toString()));
                startActivity(intent);
                //overridePendingTransition(R.anim.home_to_main,R.anim.main_to_home);
            }
        });
    }

}