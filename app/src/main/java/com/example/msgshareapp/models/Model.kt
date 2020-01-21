package com.example.msgshareapp.models

//The hobby class holds data for hobbies
data class Hobby(var title:String)

//The object variable makes this class: Supplier a singleton class. Meaning, only one instance of the class can be instantiated
object Supplier{
    val hobbies = mutableListOf(
        Hobby("Swimming"),
        Hobby("Reading"),
        Hobby("Walking"),
        Hobby("Sleeping"),
        Hobby("Gaming"),
        Hobby("Programming"),
        Hobby("Talking"),
        Hobby("Reading 1"),
        Hobby("Reading 2"),
        Hobby("Reading 3"),
        Hobby("Reading 4"),
        Hobby("Reading 5")
    )

    fun addHobby(hobby: String) = hobbies.add(Hobby(hobby))
}