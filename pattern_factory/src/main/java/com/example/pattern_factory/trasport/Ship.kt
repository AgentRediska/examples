package com.example.pattern_factory.trasport

class Ship: Transport {
    override fun deliver() {
        print("The ship")
    }

     fun transportationByRiver(){
        print("The ship is carrying cargo")
    }
}