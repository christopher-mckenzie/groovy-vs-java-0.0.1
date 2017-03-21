package com.tutorial

import com.tutorial.bean.DriverGroovy
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import spock.lang.Specification

/**
 * Created by req85404 on 03/21/2017.
 */
class JsonSpec extends Specification{

    def "write to json"(){
        when:
        List<DriverGroovy> drivers = new ArrayList<>()
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        then:
        FileWriter fileWriter = new FileWriter("driver_groovy_items.json")
        fileWriter.write(new JsonBuilder(drivers).toPrettyString())
        fileWriter.close()

    }
}
