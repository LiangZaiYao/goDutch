package cn.edu.cqu.mydutch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 一台电脑 on 2017/3/4.
 */

public class FinalPage extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置当前的Activity的界面布局
        setContentView(R.layout.final_page);
        //获得Intent
        Intent intent = this.getIntent();


        String amount;
        EditText totalAmount,peopleNum;
        TextView display;
        totalAmount = (EditText) findViewById(R.id.etAmount);
        peopleNum = (EditText) findViewById(R.id.etNumber);
        display = (TextView) findViewById(R.id.tvFinnalResult);

        Double total = Double.parseDouble(totalAmount.getText().toString());
        Double persons = Double.parseDouble(peopleNum.getText().toString());
        Double cost = total / persons;
        cost = Double.valueOf(Math.round(cost * 100));
        cost = cost / 100;
        display.setText(String.valueOf(cost));
    }


    public void btnComplete(View v){
        final Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
