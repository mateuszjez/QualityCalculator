package pl.edu.agh.qualitycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;
    EditText etNum3;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnAv;

    TextView tvResult;

    Calculations calculations = new Calculations();
    CalculationsVerbalizer verbalizer = new CalculationsVerbalizer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        etNum3 = (EditText) findViewById(R.id.etNum3);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnAv = (Button) findViewById(R.id.btnAv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Operation selectedOperation = null;
        switch (v.getId()) {
            case R.id.btnAdd:
                selectedOperation = Operation.SUM;
                break;
            case R.id.btnSub:
                selectedOperation = Operation.SUBTRACT;
                break;
            case R.id.btnMult:
                selectedOperation = Operation.MULTIPLY;
                break;
            case R.id.btnDiv:
                selectedOperation = Operation.DIVIDE;
                break;
            case R.id.btnAv:
                selectedOperation = Operation.AVERAGE;
                break;
            default:
                break;
        }
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            tvResult.setText("Enter some data to calculate");
            return;
        }

        float num1 = Float.parseFloat(etNum1.getText().toString());
        float num2 = Float.parseFloat(etNum2.getText().toString());
        try {
            float result;
            String verbalizedOperation;
            if ((!TextUtils.isEmpty(etNum3.getText().toString()))
                    && selectedOperation==Operation.AVERAGE) {
                float num3 = Float.parseFloat(etNum3.getText().toString());
                result = calculations.calculate(selectedOperation, num1, num2, num3);
                verbalizedOperation = verbalizer.verbalize(selectedOperation, num1, num2, num3, result);
            }
            else {
                result = calculations.calculate(selectedOperation, num1, num2);
                verbalizedOperation = verbalizer.verbalize(selectedOperation, num1, num2, result);
            }
            tvResult.setText(verbalizedOperation);
        }
        catch (Exception ex) {
            tvResult.setText("An error ocurred: " + ex.getMessage());
        }

    }
}
