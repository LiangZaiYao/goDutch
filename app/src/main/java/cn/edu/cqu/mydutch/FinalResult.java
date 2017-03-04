package cn.edu.cqu.mydutch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
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
}
