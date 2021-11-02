package com.wallpy.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dispText;
    int num,num2,total=0;
    float nump,num2p;
    float totalp=0.0f;

    String x;
    String c;

    Character oper='q';
    public  String str="";
    public  String str2="";

    boolean o,to,numon,po,operwrok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        }

        dispText=findViewById(R.id.display);
        dispText.setShowSoftInputOnFocus(false);

}

    public void Enter(String s){

        if (o==true) {
            str2=str2+s;
            dispText.setText(str+x+str2);
            Log.d("ok", "Enter: second value "+str+x+str2);
            secondvalue();
            Log.d("ok", "secondvalue() call");
        } else {
            operwrok=true;
            Log.d("ok", "operwrok=true");

            str=str+s;
            dispText.setText(str);
            numon=false;
            Log.d("ok", "Enter: fast value "+str);
            Log.d("ok", "numon=false");

        }
    }


    private void secondvalue() {
            switch (oper) {
                case '+':
                    dispText.setText(str + "+" + str2);
                    break;
                case '-':
                    dispText.setText(str + "-" + str2);
                    break;
                case '*':
                    dispText.setText(str + "*" + str2);
                    break;
                case '/':
                    dispText.setText(str + "/" + str2);
                    break;
            }
            Log.d("ok", "secondvalue() second value used with oper"+str+oper+str2);
    }

    private  void reset(){
        str="";
        str2="";
        oper='q';
        num=0;
        total=0;
        o=false;
        to=false;
        numon=false;
        num2p=0;
        totalp=0;
        po=false;
        operwrok=false;
        dispText.setText("");
        Log.d("ok", "Enter: clear");
    }

   public void preform(String op){
      if(po==true){
          if (to == true) {
              if (numon == true) {
                  str =String.valueOf(totalp);
                  Log.d("ok", "totalp old float value use");
              } else {
                  Log.d("ok", "Enter: nump fast time use float ");
              }
          }
          dispText.setText(str + op);
          x=op;
          Log.d("ok", "x value"+x);
      }
      else {
          if (to == true) {
              if (numon == true) {
                   str=String.valueOf(total);
                  Log.d("ok", "num=total old int value use ");
              } else {
                  Log.d("ok", "Enter: num fast time use int");
              }
          }
          dispText.setText(str + op);
          x=op;
          Log.d("ok", "x value"+x);
      }
       o = true;
       Log.d("ok", "sym use o=true "+str+x);
   }
   public  void calculate() {


       if(str==""||str2==""){
            c = dispText.getText().toString();
            dispText.setText(""+c);
       }else{
           if(po==true){
               try {
                   nump = Float.parseFloat(str);
                   num2p = Float.parseFloat(str2);
                   Log.d("ok","(float) valid input>>>proccess ="+str+x+str2);
               }catch (Exception e){
                   reset();
                   Log.d("ok","not work catch float ="+str+x+str2);
               }
           }
           else {
                 try {
                     num = Integer.parseInt(str);
                     num2 = Integer.parseInt(str2);
                     Log.d("ok", "(int)valid input>>>proccess =" + str + x + str2);
                 }catch (Exception e){
                     reset();
                     Log.d("ok","not work catch int ="+str+x+str2);
                 }
           }
       }

      
       if (po == true) {
           if (oper == '+') {
               totalp = nump + num2p;
           } else if (oper == '-') {
               totalp = nump - num2p;
           } else if (oper == '*') {
               totalp = nump * num2p;
           } else if (oper == '/') {
               totalp = nump / num2p;
           }
           else{
               reset();
               Toast.makeText(this,"invalid input",Toast.LENGTH_LONG).show();
               Log.d("ok", "Enter: float error input");
           }

           dispText.setText("" + totalp);
           Log.d("ok", "Enter: float total");

      }
      else {
           if (oper == '+') {
               total = num + num2;
           } else if (oper == '-') {
               total = num - num2;
           } else if (oper == '*') {
               total = num * num2;
           } else if (oper == '/') {
               total = num / num2;
           }
           else{
               reset();
               Toast.makeText(this, " invalid input",Toast.LENGTH_LONG).show();
               Log.d("ok", "Enter: int error input");
           }
           Log.d("ok", "Enter: int tolat");

           dispText.setText("" + total);
   }

       str="";
       str2="";
       num=0;
       num2=0;
       nump=0.0f;
       num2p=0.0f;

       numon=true;
       o=false;
       to=true;
       Log.d("ok", "Enter: finish"+str==null?"none":"not none");
   }
//===============================================================================================
    public void one1(View view) {
            Enter("1");
        Log.d("ok", "Enter: 1");

    }
    public void two1(View view) {
            Enter("2");
        Log.d("ok", "Enter: 2");
    }
    public void three1(View view) {
            Enter("3");
        Log.d("ok", "Enter: 3");
    }
    public void four1(View view) {
            Enter("4");
        Log.d("ok", "Enter: 4");
    }
    public void five1(View view) {
            Enter("5");
        Log.d("ok", "Enter: 5 ");
    }
    public void six1(View view) {
            Enter("6");
        Log.d("ok", "Enter: 6");
    }
    public void seven1(View view) {
            Enter("7");
        Log.d("ok", "Enter: 7");
    }
    public void eight1(View view) {
            Enter("8");
        Log.d("ok", "Enter: 8");
    }
    public void nine1(View view) {
            Enter("9");
        Log.d("ok", "Enter: 9");
    }
    public void zero1(View view) {
            Enter("0");
        Log.d("ok", "Enter: 0");
    }
    public void ponit1(View view){
        Enter(".");
        po=true;
        Log.d("ok", "Enter: .(point)");
        Log.d("ok", "po=true");
    }


    public void clear1(View view) {
       reset();
        Log.d("ok", "Enter: clear");
    }

    public void divide1(View view) {
       if(operwrok==true) {
           preform("/");
           oper = '/';
           Log.d("ok", "Enter:/");
           Log.d("ok", "oper=/");
           Log.d("ok", "enter : operwrok=ture work");

       }
       else{
           dispText.setText("");
           Log.d("ok", "enter : operwrok=false");
       }
    }
    public void add1(View view) {
        if(operwrok==true) {
            preform("+");
            oper = '+';
            Log.d("ok", "Enter: + ");
            Log.d("ok", "oper=+");
            Log.d("ok", "enter : operwrok=ture work");

        } else{
                dispText.setText("");
                Log.d("ok", "enter : operwrok=false");
            }
    }
    public void mutiply1(View view) {
       if(operwrok==true) {
           preform("*");
           oper = '*';
           Log.d("ok", "Enter: * ");
           Log.d("ok", "oper=*");
           Log.d("ok", "enter : operwrok=ture work");
       }else{
           dispText.setText("");
           Log.d("ok", "enter : operwrok=false");
       }

    }
    public void sub1(View view) {
       if(operwrok==true) {
           preform("-");
           oper = '-';
           Log.d("ok", "Enter: - ");
           Log.d("ok", "oper=*");
           Log.d("ok", "enter : operwrok=ture work");
       }
       else{
           dispText.setText("");
           Log.d("ok", "enter : operwrok=false");
       }
    }

    public void equals1(View view) {
       calculate();
       Log.d("ok", "Enter: =  & call calculate();");
    }
}