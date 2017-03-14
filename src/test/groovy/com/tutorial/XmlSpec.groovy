package com.tutorial

import com.tutorial.bean.DriverGroovy
import groovy.xml.MarkupBuilder
import spock.lang.Specification

/**
 * Created by req85404 on 03/13/2017.
 */
class XmlSpec extends Specification{

    def "xml parser -> read in xml"(){
        given:
            List<DriverGroovy> drivers = new ArrayList<>()
        when:
            def xml = new XmlParser().parse("sample_reader.xml") //parse xml -> turns xml into DOM
            xml.driver.each { driver ->
                def name = driver.name
                def number = Integer.parseInt driver.number.text().trim()
                def averageFinish = Double.parseDouble driver.average_finish.text().trim()
                def careerWins = Integer.parseInt driver.career_wins.text().trim()
                drivers << new DriverGroovy(
                        name: name,
                        number: number,
                        averageFinish: averageFinish,
                        careerWins: careerWins
                )
            }

        then:
            println drivers
            drivers.size() == 2
    }

    def "xml parser with annotations -> read in xml"(){
        given:
            List<DriverGroovy> drivers = new ArrayList<>()
        when:
            def xml = new XmlParser().parse("sample_reader_annotation.xml") //parse xml -> turns xml into DOM
            xml.driver.each { driver ->
                drivers << new DriverGroovy(
                        name: driver.@name,
                        number: Integer.parseInt(driver.@number),
                        averageFinish: Double.parseDouble(driver.@average_finish),
                        careerWins: Integer.parseInt(driver.@career_wins)
                )
            }

        then:
            println drivers
            drivers.size() == 2
    }

    def "xml builder -> create xml file"(){
        given:
            List<DriverGroovy> driversGroovy = new ArrayList<>()
            driversGroovy << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
            driversGroovy << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        when:
            FileWriter fileWriter = new FileWriter("sample_writer.xml")
            MarkupBuilder builder = new MarkupBuilder(fileWriter)
            builder.drivers { //games is not a method but rather here it is a node
                driversGroovy.each { dg ->
                    driver { //creates a game node with the following attributes
                        name("$dg.name")
                        number(dg.number)
                        average_finish(dg.averageFinish)
                        career_wins(dg.careerWins)
                    }
                }
           }
            fileWriter.close()
        then:
            driversGroovy.size() == 2
    }


    def "xml builder with attributes -> create xml file"(){
        given:
            List<DriverGroovy> driversGroovy = new ArrayList<>()
            driversGroovy << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
            driversGroovy << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        when:
            FileWriter fileWriter = new FileWriter("sample_writer_annotation.xml")
            MarkupBuilder builder = new MarkupBuilder(fileWriter)
            builder.drivers { //games is not a method but rather here it is a node
                driversGroovy.each { dg ->
                    driver ( //creates a game node with the following attributes
                        name: "$dg.name",
                        number: dg.number,
                        average_finish: dg.averageFinish,
                        career_wins: dg.careerWins
                    )
                }
            }
            fileWriter.close()
        then:
            driversGroovy.size() == 2
    }
}
