package com.example.pattern_factory.factory

import com.example.pattern_factory.trasport.Transport

abstract class Factory {

  abstract  fun createTransport(): Transport

}