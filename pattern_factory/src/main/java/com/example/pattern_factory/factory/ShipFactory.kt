package com.example.pattern_factory.factory

import com.example.pattern_factory.trasport.Ship
import com.example.pattern_factory.trasport.Transport

class ShipFactory: Factory() {
    override fun start(): String {
        return "the ship is on its way"
    }
}