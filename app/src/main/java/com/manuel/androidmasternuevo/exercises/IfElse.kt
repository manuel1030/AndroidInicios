package com.manuel.androidmasternuevo.exercises

fun main(){
    ifbasico()
    ifAnimado();
}
fun ifBoolean(){
    var soyFeliz = true;
    if(soyFeliz){

    }
}
fun ifAnimado(){
    var animal = "dog"
    if(animal == "dog"){
        println("Es un perrito!")
    }
    else if(animal == "gat"){
        println("Es un gato")
    }
    else{
        println("No es un animal")
    }

}
fun ifbasico(){
    val name : String = "manuel";
    if (name == "Manuel"){
        println("Hola")
    }
    else{
        println("No eres pepe")
    }
}