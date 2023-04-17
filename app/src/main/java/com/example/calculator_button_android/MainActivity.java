package com.example.calculator_button_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6
            , R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i;
    Button[] numButton = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult = (TextView) findViewById(R.id.TextResult);
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
                return false;
            }
        });
        for (i=0; i< numBtnIDs.length; i++){
            numButton[i]= (Button) findViewById(numBtnIDs[i]);
        }
        for (i=0; i< numBtnIDs.length; i++){
            final int index;
            index = i;

            numButton[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused()==true){
                        num1 = edit1.getText().toString()+numButton[index].getText().toString();
                    }else if (edit2.isFocused()==true){
                        num2 = edit2.getText().toString()+numButton[index].getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(),"먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
