package com.example.callls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.callls.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn0.setOnClickListener{setTextFields("0")}
        binding.btn1.setOnClickListener{setTextFields("1")}
        binding.btn2.setOnClickListener{setTextFields("2")}
        binding.btn3.setOnClickListener{setTextFields("3")}
        binding.btn4.setOnClickListener{setTextFields("4")}
        binding.btn5.setOnClickListener{setTextFields("5")}
        binding.btn6.setOnClickListener{setTextFields("6")}
        binding.btn7.setOnClickListener{setTextFields("7")}
        binding.btn8.setOnClickListener{setTextFields("8")}
        binding.btn9.setOnClickListener{setTextFields("9")}
        binding.btnMinus.setOnClickListener{setTextFields("-")}
        binding.btnPlus.setOnClickListener{setTextFields("+")}
        binding.btnMult.setOnClickListener{setTextFields("*")}
        binding.btnDiv.setOnClickListener{setTextFields("/")}
        binding.btnScL.setOnClickListener{setTextFields("(")}
        binding.btnScR.setOnClickListener{setTextFields(")")}
        binding.btnClear.setOnClickListener{binding.mathOperation.text = ""}
        binding.btnBack.setOnClickListener{
            val str = binding.mathOperation.text.toString()
            if(str.isNotEmpty())
            {
                binding.mathOperation.text = str.substring(0,str.length - 1)
            }
            binding.resultText.text = ""
        }
        binding.btnResult.setOnClickListener{
            try {
                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val longres = result.toLong()
                if(result == longres.toDouble()){binding.resultText.text = longres.toString()}
                else{binding.resultText.text = result.toString()}

            } catch (e:Exception){
                Log.d("Ошибка ага ","сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str:String)
    {
        if(binding.resultText.text != "")
        {
            binding.mathOperation.text = binding.resultText.text
            binding.resultText.text = ""
        }
        binding.mathOperation.append(str)
    }


}