package com.mohanad.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.mohanad.mycalculator.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<String> op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        op = new ArrayList<>();
        binding.zero.setOnClickListener(e->binding.text1.append("0"));
        binding.one.setOnClickListener(e->binding.text1.append("1"));
        binding.two.setOnClickListener(e->binding.text1.append("2"));
        binding.three.setOnClickListener(e->binding.text1.append("3"));
        binding.four.setOnClickListener(e->binding.text1.append("4"));
        binding.five.setOnClickListener(e->binding.text1.append("5"));
        binding.six.setOnClickListener(e->binding.text1.append("6"));
        binding.seven.setOnClickListener(e->binding.text1.append("7"));
        binding.eight.setOnClickListener(e->binding.text1.append("8"));
        binding.nine.setOnClickListener(e->binding.text1.append("9"));
        binding.clear.setOnClickListener(e->{
            binding.text1.setText("");
            binding.res.setText("");
            op.clear();
        });
        binding.plus.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append("+");
                op.add("\\+");
            }
        });
        binding.subtract.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append("-");
                op.add("-");
            }
        });
        binding.multiply.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append("x");
                op.add("x");
            }
        });
        binding.division.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append("/");
                op.add("/");
            }
        });
        binding.modulus.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append("%");
                op.add("%");
            }
        });
        binding.dot.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else{
                binding.text1.append(".");
            }
        });
        binding.equal.setOnClickListener(e->{
            if(binding.text1.getText().equals("")){
                Toast.makeText(this,"Please Enter Number",Toast.LENGTH_SHORT).show();
            }
            else if(!binding.text1.getText().toString().contains("+")&&
                    !binding.text1.getText().toString().contains("-")&&
                    !binding.text1.getText().toString().contains("x")&&
                    !binding.text1.getText().toString().contains("/")&&
                    !binding.text1.getText().toString().contains("%")){
                Toast.makeText(this,"Please Enter Operation",Toast.LENGTH_SHORT).show();
            }
            else{
                String txt = binding.text1.getText().toString();
                String newString = "";
                int length = binding.text1.getText().toString().length();
                int numOfOp = op.size();
                double res;
                for(int i = 0 ; i < length ; i++){
                    if(txt.charAt(i) == '+'||txt.charAt(i)=='-'||txt.charAt(i)=='x'||txt.charAt(i)=='/'||txt.charAt(i)=='%'){
                        newString += " ";
                    }
                    else{
                        newString += txt.charAt(i);
                    }
                }
                String [] nums = newString.split(" ");
                for(int i = 0 ; i < numOfOp; i++){
                    res = calculate(nums[i],op.get(i),nums[i+1]);
                    nums[i+1] = String.valueOf(res);
                }
                binding.res.setText(nums[nums.length-1]);
            }
        });
    }
    private double calculate(String num1 , String op , String num2){
        double result = 0;
        switch (op){
            case "\\+":
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case"-":
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "x":
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "/":
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
            case "%":
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                break;
        }
        return result;
    }
}