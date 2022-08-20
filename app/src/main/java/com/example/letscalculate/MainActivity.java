package com.example.letscalculate;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display= findViewById(R.id.input);
        //-----------------------To Remove Default Keyboard--------------------
          display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(view -> {
            if(getString(R.string.bodmass).equals(display.getText().toString()))
            {
                display.setText(" ");
            }
        });
    }
//    Function For Cursor Position And Getting Data From EditView
    private void updatedText(String strAdd)
    {
          String old =display.getText().toString();
          int cursor=display.getSelectionStart();
          String leftStr=old.substring(0,cursor);
          String rightStr=old.substring(cursor);
        if(getString(R.string.bodmass).equals(display.getText().toString()))
        {
            display.setText(strAdd);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strAdd, rightStr));
        }
        display.setSelection(cursor + 1);

    }
// Implementing Set On ClickListener in each button
    public void zeroBTN(View view)
    {
        updatedText("0");
    }
    public void oneBTN(View view)
    {
updatedText("1");
    }
    public void twoBTN(View view)
    {
updatedText("2");
    }
    public void threeBTN(View view)
    {
updatedText("3");
    }
    public void fourBTN(View view)
    {
updatedText("4");
    }
    public void fiveBTN(View view)
    {
        updatedText("5");
    }
    public void sixBTN(View view)
    {
        updatedText("6");
    }
    public void sevenBTN(View view)
    {
        updatedText("7");
    }
    public void eightBTN(View view)
    {
        updatedText("8");
    }
    public void nineBTN(View view)
    {
        updatedText("9");
    }
    public void plusBTN(View view)
    {
        updatedText("+");
    }
    public void minusBTN(View view)
    {
        updatedText("-");
    }
    public void multiplyBTN(View view)
    {
        updatedText("*");
    }
    public void divideBTN(View view)
    {
        updatedText("/");
    }
    public void equalBTN(View view)
    {
String userExp=display.getText().toString();
userExp=userExp.replaceAll("÷","/");
userExp=userExp.replaceAll("×","*");

Expression expression=new Expression(userExp);
String result= String.valueOf(expression.calculate());
display.setText(result);
display.setSelection(result.length());


     }

    public void exponentBTN(View view)
    {
updatedText("^");
    }
    public void parentBTN(View view)
    {
int cursor=display.getSelectionStart();
int openParent=0;
int closeParent=0;
int textLen=display.getText().length();
for(int i=0;i<cursor;i++)
{
   if(display.getText().toString().charAt(i) == '(')
   {
       openParent+=1;
   }
    if(display.getText().toString().charAt(i) == ')')
    {
        closeParent+=1;
    }
}
if (openParent==closeParent|| display.getText().toString().charAt(textLen - 1) == '(')
{
    updatedText("(");
}
        if (closeParent<openParent && display.getText().toString().charAt(textLen - 1) != ')')
        {
            updatedText(")");
        }
        display.setSelection((cursor+1));
    }
    public void clearBTN(View view)
    {
        display.setText("");
    }
    public void dotBTN(View view)
    {
        updatedText(".");
    }
    public void plusMinusBTN(View view)
    {
        updatedText("-");
    }
    public void backBTN(View view)
    {
int cursor=display.getSelectionStart();
int textLen =display.getText().length();
if(cursor!=0 && textLen!=0)
{
    SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
    selection.replace(cursor-1,cursor,"");
    display.setText(selection);
    display.setSelection(cursor-1);
}
    }

}