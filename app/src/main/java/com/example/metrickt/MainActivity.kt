package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        var convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbDlrToYen = findViewById<RadioButton>(R.id.idRBDlrToYen)
        val rbYenToDlr = findViewById<RadioButton>(R.id.idRBYenToDlr)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat("#.#")
            var dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 110
            var convertMeasureNum: Double

            if (rbDlrToYen.isChecked) {
                if (dblMeasure <= 10000) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = "¥" + tenth.format(convertMeasureNum)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Dollar entry must be less than 10,000 dollars.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            if (rbYenToDlr.isChecked) {
                if (dblMeasure <= 1100000) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = "$" + tenth.format(convertMeasureNum)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Yen entry must be less than an 1.1 million Yen.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}