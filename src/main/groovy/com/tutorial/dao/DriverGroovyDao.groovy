package com.tutorial.dao

import com.tutorial.bean.DriverGroovy
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.sql.Sql

/**
 * Created by req85404 on 03/21/2017.
 */
class DriverGroovyDao {

    String JSON_FILE = 'driver-groovy-items.json'

    def insertDrivers(List<DriverGroovy> drivers){
        FileWriter fileWriter = new FileWriter(JSON_FILE)
        new JsonBuilder(drivers).writeTo fileWriter
        fileWriter.close()
        println "successfully wrote ${drivers.size()} records to $JSON_FILE"
   }

    def loadDrivers(){
        List<DriverGroovy> drivers = new JsonSlurper().parse(new File(JSON_FILE)) as List<DriverGroovy>
        println "successfully pulled ${drivers.size()} records from $JSON_FILE"
        return drivers
    }

}
