package cn.edu.swufe.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigActivity extends AppCompatActivity {

    public final String TAG = "ConfigActivity";

    TextView btn;

    EditText dollarText;
    EditText euroText;
    EditText wonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Intent i = getIntent();
        float dollar2=i.getFloatExtra("dollar_rate_key",0.0f);
        float euro2=i.getFloatExtra("euro_rate_key",0.0f);
        float won2=i.getFloatExtra("won_rate_key",0.0f);

        Log.i(TAG,"onCreate:dollar2="+dollar2);
        Log.i(TAG,"onCreate:euro2="+euro2);
        Log.i(TAG,"onCreate:won2="+won2);

        dollarText = findViewById(R.id.dollar);
        euroText = findViewById(R.id.euro);
        wonText = findViewById(R.id.won);

        dollarText.setText(String.valueOf(dollar2));
        euroText.setText(String.valueOf(euro2));
        wonText.setText(String.valueOf(won2));

    }
    public void save(View btn){
        Log.i(TAG,"save：获取到新的值");
        //获取新的输入数据
        float newDollar = Float.parseFloat(dollarText.getText().toString());
        float newEuro = Float.parseFloat(euroText.getText().toString());
        float newWon = Float.parseFloat(wonText.getText().toString());

        Log.i(TAG,"save：获取到新的值");
        Log.i(TAG,"onCreate:dollar2="+newDollar);
        Log.i(TAG,"onCreate:euro2="+newEuro);
        Log.i(TAG,"onCreate:won2="+newWon);

        //保存到Bundle
        Intent intent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putFloat("key_dollar",newDollar);
        bdl.putFloat("key_euro",newEuro);
        bdl.putFloat("key_won",newWon);
        intent.putExtras(bdl);
        setResult(2,intent);

        //返回到调用页面
        finish();
    }
}
