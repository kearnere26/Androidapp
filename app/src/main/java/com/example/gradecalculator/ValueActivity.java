package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

public class ValueActivity extends AppCompatActivity {

    double totalA = 0; int counterA = 0;
    double totalE = 0; int counterE = 0;
    double totalP = 0; int counterP = 0;
    double totalQ = 0; int counterQ = 0;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
    }

    public void storeValueA (View s) {
        if (s.getId() == R.id.pushNumberA) {
            counterA++;
            TextView showAmountA = findViewById(R.id.addedNumA);
            String assign = ((EditText)findViewById(R.id.numToCalculateA)).getText().toString();
            totalA += Double.parseDouble(assign);
            showValue(totalA, showAmountA);
            ((EditText) findViewById(R.id.numToCalculateA)).getText().clear();

        } else if (s.getId() == R.id.pushNumberE) {
            counterE++;
            String exam = ((EditText) findViewById(R.id.numToCalculateE)).getText().toString();
            TextView showAmountE = findViewById(R.id.addedNumE);
            totalE += Double.parseDouble(exam);
            showValue(totalE, showAmountE);
            ((EditText) findViewById(R.id.numToCalculateE)).getText().clear();

        } else if (s.getId() == R.id.pushNumberP) {
            counterP++;
            String project = ((EditText) findViewById(R.id.numToCalculateP)).getText().toString();
            TextView showAmountP = findViewById(R.id.addedNumP);
            totalP += Double.parseDouble(project);
            showValue(totalP, showAmountP);
            ((EditText) findViewById(R.id.numToCalculateP)).getText().clear();

        } else if (s.getId() == R.id.pushNumberQ) {
            counterQ++;
            String quiz = ((EditText) findViewById(R.id.numToCalculateQ)).getText().toString();
            TextView showAmountQ = findViewById(R.id.addedNumQ);
            totalQ += Double.parseDouble(quiz);
            showValue(totalQ, showAmountQ);
            ((EditText) findViewById(R.id.numToCalculateQ)).getText().clear();
        }

    }


    public void showValue(double t, TextView v){
        String s = Double.toString(t);
        v.setText(s);

    }

    public void clearData(View c) {

        if (c.getId() == R.id.clrValuesA) {
            totalA = 0;
            TextView showAmountA = findViewById(R.id.addedNumA);
            showValue(totalA, showAmountA);

        } else if (c.getId() == R.id.clrValuesE) {
            totalE = 0;
            TextView showAmountE = findViewById(R.id.addedNumE);
            showValue(totalE, showAmountE);

        } else if (c.getId() == R.id.clrValuesP){
            totalP = 0;
            TextView showAmountP = findViewById(R.id.addedNumP);
            showValue(totalP, showAmountP);

        }
        else if(c.getId() == R.id.clrValuesQ){
            totalQ = 0;
            TextView showAmountQ = findViewById(R.id.addedNumQ);
            showValue(totalQ, showAmountQ);
        }
    }
    public void compareTotal(View comp){
        String aMaxPoints = ((EditText)findViewById(R.id.maxPointsA)).getText().toString();
        String pMaxPoints= ((EditText)findViewById(R.id.maxPointsP)).getText().toString();
        String eMaxPoints = ((EditText)findViewById(R.id.maxPointsE)).getText().toString();
        String qMaxPoints = ((EditText)findViewById(R.id.maxPointsQ)).getText().toString();
        TextView showGrade = findViewById(R.id.letterGrade);
        TextView showGradePercentage = findViewById(R.id.gradePercentage);

        if(comp.getId() == R.id.doTheMagic){
            double totalGradePoints = totalA+totalP+totalQ+totalE;
            double totalMaxPoints = Double.parseDouble(aMaxPoints)+Double.parseDouble(pMaxPoints)+
                    Double.parseDouble(eMaxPoints)+Double.parseDouble(qMaxPoints);
            double gradePercent = (totalGradePoints/totalMaxPoints) * 100;
            LetterGrade(gradePercent, showGrade);
            renderGradePercentage(showGradePercentage, gradePercent);
        }
        else if(comp.getId() == R.id.doTheMagicAsPercent){
            double GradePoints = ((totalA/counterA) * Double.parseDouble(aMaxPoints) )+
                    (( totalP/counterP) * Double.parseDouble(pMaxPoints))+
                    ((totalQ/counterQ) * Double.parseDouble(qMaxPoints))
                    +((totalE/counterE) * Double.parseDouble(eMaxPoints));
            LetterGrade(GradePoints, showGrade);
            renderGradePercentage(showGradePercentage, Double.parseDouble(df.format(GradePoints)));
        }
    }
    public void renderGradePercentage(TextView c, double d){
        String b = Double.toString(d);
        c.setText(b);
    }
    public void LetterGrade(double dle, TextView show){
        if(dle >= 90){
            show.setText("A");
        }
        else if(dle >=80 && dle < 90) {
            show.setText("B");
        }
        else if(dle >=70 && dle < 80) {
            show.setText("C");
        }
        else if(dle >= 60 && dle < 70) {
            show.setText("D");
        }
        else{
            show.setText("F");
        }
    }

}





