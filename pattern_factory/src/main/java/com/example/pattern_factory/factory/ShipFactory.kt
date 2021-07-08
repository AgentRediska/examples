package com.example.pattern_factory.factory

import com.example.pattern_factory.trasport.Ship
import com.example.pattern_factory.trasport.Transport

class ShipFactory: Factory() {
    override fun createTransport(): Transport {
        return Ship()
    }
}