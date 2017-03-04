package cn.edu.cqu.mydutch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    String amount;
    EditText totalAmount, peopleNum;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalAmount = (EditText) findViewById(R.id.etAmount);
        peopleNum = (EditText) findViewById(R.id.etNumber);
        display = (TextView) findViewById(R.id.tvResult);
        totalAmount.setFilters(new InputFilter[]{lengthFilter});
        //peopleNum.setFilters(new InputFilter[]{lengthFilter});
    }


    public void btnConfirm(View v) {
        Double persons = Double.parseDouble(peopleNum.getText().toString());
        if (totalAmount.length() == 0 || peopleNum.length() == 0) {
            if (totalAmount.length() == 0){
                Toast.makeText(getBaseContext(), "Please enter the amount", Toast.LENGTH_SHORT).show();
            }
            else  {
                Toast.makeText(getBaseContext(), "Please enter the number of people", Toast.LENGTH_SHORT).show();
            }
        }

        else if (persons == 0) {
            Toast.makeText(getBaseContext(), "Please enter the number of people properly", Toast.LENGTH_SHORT).show();
        }
        else {
            /***********to the other activity
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, FinalPage.class);
            MainActivity.this.startActivity(intent);
            */
            totalAmount = (EditText) findViewById(R.id.etAmount);
            peopleNum = (EditText) findViewById(R.id.etNumber);
            display = (TextView) findViewById(R.id.tvResult);

            Double total = Double.parseDouble(totalAmount.getText().toString());
            persons = Double.parseDouble(peopleNum.getText().toString());
            Double cost = total / persons;
            cost = Double.valueOf(Math.round(cost * 100));
            cost = cost / 100;
            display.setText(String.valueOf(cost));
        }
    }
    /**
     * 输入框小数的位数
     */
    private static final int DECIMAL_DIGITS = 2;

    private InputFilter lengthFilter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            // source:当前输入的字符
            // start:输入字符的开始位置
            // end:输入字符的结束位置
            // dest：当前已显示的内容
            // dstart:当前光标开始位置
            // dent:当前光标结束位置
            Log.i("", "source=" + source + ",start=" + start + ",end=" + end
                    + ",dest=" + dest.toString() + ",dstart=" + dstart
                    + ",dend=" + dend);
            if (dest.length() == 0 && source.equals(".")) {
                return "0.";
            }
            String dValue = dest.toString();
            String[] splitArray = dValue.split("\\.");
            if (splitArray.length > 1) {
                String dotValue = splitArray[1];
                if (dotValue.length() == DECIMAL_DIGITS) {
                    return "";
                }
            }
            return null;
        }

    };
}



