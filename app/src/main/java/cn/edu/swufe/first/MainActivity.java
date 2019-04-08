package cn.edu.swufe.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView out;
    EditText inp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out = (TextView) findViewById(R.id.textView01);
        inp = (EditText) findViewById(R.id.editText);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Log.i("click","onClick .....");

        //TextView out = (TextView) findViewById(R.id.textView01);

        //EditText editText = findViewById(R.id.editText);
        String str = inp.getText().toString();

        double i = Integer.parseInt(str);
        double b = i*9/5+32;

        out.setText("结果为:"+b);
        //out.setText(str);

    }
}
