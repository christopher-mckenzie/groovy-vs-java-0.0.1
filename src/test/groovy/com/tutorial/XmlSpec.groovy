package com.tutorial

import com.tutorial.bean.DriverGroovy
import spock.lang.Specification

/**
 * Created by req85404 on 03/13/2017.
 */
class XmlSpec extends Specification{

    def "xml slurper -> read in xml"(){
        given:
            List<DriverGroovy> drivers = new ArrayList<>()
        when:
        def xml = new XmlParser().parse("sample.xml") //parse xml -> turns xml into DOM
        //def driversXml = xml.driver
        xml.driver.each { driver ->
            def name = driver.name
            def number = Integer.parseInt driver.number.text().trim()
            def averageFinish = Double.parseDouble driver.average_finish.text().trim()
            def careerWins = Integer.parseInt driver.career_wins.text().trim()
            drivers << new DriverGroovy(name: name, number: number, averageFinish: averageFinish, careerWins: careerWins)
        }

        then:
            drivers.size() == 2
    }
}
