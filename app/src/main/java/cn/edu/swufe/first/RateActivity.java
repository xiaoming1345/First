package cn.edu.swufe.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class RateActivity extends AppCompatActivity {

    EditText rmb;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        rmb = findViewById(R.id.rmb);
        show = findViewById(R.id.showOut);

    }

    public void onClick(View btn) {
        String str = rmb.getText().toString();
        float r = 0;
        if (str.length() > 0) {
            r = Float.parseFloat(str);
        }else{
            Toast.makeText(this, "请输入金额", Toast.LENGTH_SHORT).show();
        }

        float val;
        if (btn.getId() == R.id.btn_dollar) {
           val = r * (1/6.7f);
        } else if (btn.getId() == R.id.btn_euro) {
            val = r * (1/11f);
        } else {
            val = r * 500;
        }
        BigDecimal b  =   new BigDecimal(val);
        float   f   =  b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        show.setText(String.valueOf(f));
    }
    public void openOne(View btn){
        Log.i("open","openOne:");
        Intent hello = new Intent(this,Main2Activity.class);
        startActivity(hello);
    }
}
