package com.example.pattern_factory.factory

import com.example.pattern_factory.trasport.Transport

abstract class Factory {

   fun initializeFactoryType(flag: String):Factory{
     return if(flag=="Truck"){
       TruckFactory()
     }else ShipFactory()
  }

  abstract  fun start(): String

}