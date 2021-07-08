package com.example.pattern_factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.translationMatrix
import com.example.pattern_factory.databinding.ActivityMainBinding
import com.example.pattern_factory.factory.Factory
import com.example.pattern_factory.factory.ShipFactory
import com.example.pattern_factory.factory.TruckFactory
import com.example.pattern_factory.trasport.Ship
import com.example.pattern_factory.trasport.Transport
import com.example.pattern_factory.trasport.Truck

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: Factory
    private lateinit var flag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDeliveryByTruck.setOnClickListener {
            flag="Truck"
            startTransaction()
        }

        binding.btnDeliveryByShip.setOnClickListener {
         flag="Ship"
            startTransaction()
        }
    }

    private fun startTransaction(){
        factory.initializeFactoryType(flag)
        setTextDeliveryMethod(factory.start())
    }

    private fun setTextDeliveryMethod(transportType: String){
        binding.textDeliveryMethod.text= transportType
    }

}