package com.manuel.androidmasternuevo.imccalculador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.manuel.androidmasternuevo.R
import java.text.DecimalFormat

class imcCalculadorActivity : AppCompatActivity() {
    private lateinit var  viewMale: CardView
    private lateinit var  viewFemale: CardView
    private lateinit var  tvHeight : TextView
    private lateinit var rsHeight : RangeSlider
    private lateinit var btnSubtractWeight : FloatingActionButton
    private lateinit var btnPlusWeight : FloatingActionButton
    private lateinit var tvWeight : TextView
    private lateinit var btnSubtractAge : FloatingActionButton
    private lateinit var btnPlusAge : FloatingActionButton
    private lateinit var tvAge : TextView
    private lateinit var btncalculate : Button

    private var isMaleSelected = true;
    private var isFemaleSelected = false
    private var currentWeight : Int = 60
    private var currentAge : Int = 21
    private var currentHeigth : Int = 120;

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculador)
        initComponents()
        initListeners()
        initUI()
    }
    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemele)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btncalculate = findViewById(R.id.btncalculate)
    }
    private fun initListeners(){
       viewMale.setOnClickListener{
           changeGender()
           setGenderColor()
       }
       viewFemale.setOnClickListener {
           changeGender()
           setGenderColor()
       }
       rsHeight.addOnChangeListener{ _,value,_ ->
           var df = DecimalFormat("#.##")

           currentHeigth = df.format(value).toInt()
           tvHeight.text = "$currentHeigth cm"
       }
        btnPlusWeight.setOnClickListener {
            currentWeight++
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight--
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge++
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge--
            setAge()
        }
        btncalculate.setOnClickListener {

            navigateToResult( caculateIMC())
        }
    }
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isMaleSelected
    }
    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent:Boolean): Int{
        val colorReference = if(isSelectedComponent){
             R.color.background_component_selected
        }
        else
        {
             R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
    private fun initUI(){
        setGenderColor()
        setWeight()
        setAge()
    }
    private fun setWeight(){
        tvWeight.text = currentWeight.toString();
    }
    private fun setAge(){
        println(currentAge.toString())
        tvAge.text = currentAge.toString()
    }
    private fun caculateIMC() : Double{
        val df = DecimalFormat("#.##")
        var imc = (currentWeight / ((currentHeigth.toDouble() / 100) * (currentHeigth.toDouble() / 100)))
        return imc;
    }
    private fun navigateToResult(result: Double){
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
}