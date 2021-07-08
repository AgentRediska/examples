package com.example.pattern_factory.trasport

class Truck: Transport {
    override fun deliver() {
        print("The truck")
    }

    fun transportationByRoad(){
        print("The truck is carrying cargo")
    }
}