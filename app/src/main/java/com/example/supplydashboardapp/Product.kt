package com.example.supplydashboardapp

import java.util.Date

data class Product(val name: String, val bestBeforeDate: Date, val category: String){
    override fun toString(): String = name + bestBeforeDate + category
}
