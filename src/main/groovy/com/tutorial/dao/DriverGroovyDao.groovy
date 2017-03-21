package com.tutorial.dao

import com.tutorial.bean.DriverGroovy
import groovy.sql.Sql

/**
 * Created by req85404 on 03/21/2017.
 */
class DriverGroovyDao {

   def insertDriver(DriverGroovy driverGroovy){
       getDb().execute
            """
            insert into driver_data(name,number,average_finish,career_wins)
            values(${driverGroovy.name},${driverGroovy.number},${driverGroovy.averageFinish},${driverGroovy.careerWins});
            """

   }

    Sql getDb(){
        return Sql.newInstance(
                url: 'jdbc:h2:groovy-vs-java-h2-db/drivers', driver: 'org.h2.Driver')
    }

}
