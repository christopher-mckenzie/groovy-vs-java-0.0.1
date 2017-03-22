package com.tutorial.dao

import com.tutorial.bean.DriverGroovy
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.sql.Sql

/**
 * Created by req85404 on 03/21/2017.
 */
class DriverGroovyDao {
   private static List<DriverGroovy> drivers;

    def static insertDrivers(List<DriverGroovy> drivers){
       FileWriter fileWriter = new FileWriter("driver-groovy-items.json")
       new JsonBuilder(drivers).writeTo fileWriter
       fileWriter.close()
   }

    Sql getDb(){
        return Sql.newInstance(
                url: 'jdbc:h2:groovy-vs-java-h2-db/drivers', driver: 'org.h2.Driver')
    }

    def static loadDrivers(){
        drivers = new JsonSlurper().parse(new File('driver-groovy-items.json')) as List<DriverGroovy>
    }

}
