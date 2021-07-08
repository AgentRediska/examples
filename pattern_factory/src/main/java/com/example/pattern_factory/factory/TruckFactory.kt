package com.example.pattern_factory.factory

import com.example.pattern_factory.trasport.Transport
import com.example.pattern_factory.trasport.Truck

class TruckFactory : Factory() {
    override fun start(): String {
        return "the truck is on its way"
    }
}