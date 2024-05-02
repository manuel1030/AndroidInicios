package com.manuel.androidmasternuevo.exercises


/*
* variables numericas
*
 */
fun main(){

    showMyAge()
    variablesNumericas()
    showMyName("jose")
   val resultado = subtract(8,7)
    println(resultado)
    /**
     * variables Alfanuméricas
     */

    variablesChar()
    variableString()
    variabesBolean()
}

fun showMyName(name:String){
    println("Me llamo $name")
}
fun showMyAge(currentAge:Int = 30){
    println("Tengo $currentAge años")
}
fun add(firstNumber:Int, secondNumber: Number){
    println(firstNumber + firstNumber)
}
fun  subtract(firstNumber:Int, secondNumber: Int):Int{
    return (firstNumber - secondNumber)
}
fun  subtractCool(firstNumber:Int, secondNumber: Int) = (firstNumber - secondNumber)

fun variablesChar(){
    //Char

    val charExample1:Char = 'A'
    val charExample2:Char = '2'
    val charExample3:Char = '@'
}
fun variableString(){
    //String

    val stringExaple:String = "Hola";
}
fun variabesBolean(){
    /**
     * variables boleanos
     */
    //Boleanos

    val booleanExample:Boolean = true
    val booleanExample2:Boolean= false
}
fun variablesNumericas(){
    //int
    val age: Int = 30
    var age2: Int = 38;
    //long
    val examepleLong: Long = 30

    //float
    val floatExample: Float = 30.5f

    //double
    val doubleExaple:Double= 213.3434
    println("restar: ")
    println(age - age2)
}