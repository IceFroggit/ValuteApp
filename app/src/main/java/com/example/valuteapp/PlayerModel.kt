package com.example.valuteapp

class PlayerModel {
    var name: String? = null
    var country: String? = null
    var city: String? = null
    var id: String? = null

    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }

    fun getCountrys(): String {
        return country.toString()
    }

    fun setCountrys(country: String) {
        this.country = country
    }

    fun getCitys(): String {
        return city.toString()
    }

    fun setCitys(city: String) {
        this.city = city
    }

    fun getids(): String {
        return id.toString()
    }

    fun setids(id: String) {
        this.id = id
    }
}