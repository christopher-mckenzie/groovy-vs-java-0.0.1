package com.tutorial

import com.tutorial.bean.DriverGroovy
import com.tutorial.bean.DriverJava
import com.tutorial.bean.ImmutableGroovy
import com.tutorial.bean.PitCrewGroovy
import spock.lang.Specification

/**
 * Created by cmcke on 3/11/2017.
 */
class PogoSpec extends Specification{
    /**
     * ****************************************************************************
     * DriverGroovy(name: 'Dale Enhardt', number: 88, averageFinish: 13.2, careerWins: 98)
     * map based constructor -> no need to define constructor
     * ****************************************************************************
     * << add to a list or even def
     * ****************************************************************************
     * <=> spaceship operator, same as using the following (sorts in ascending order
     * int compare(a, b) {
     * if (a < b) {
     * return -1;
     * } else if (a > b) {
     * return 1;
     * } else {
     * return 0;
     * }
     * }
     * ****************************************************************************
     */
    def "groovy magic with groovy ojects"(){
        given:
        List<DriverGroovy> driverGroovy = new ArrayList<>();
        driverGroovy << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        driverGroovy << new DriverGroovy(name: 'Jimmie Johnson', number: 48, averageFinish: 9.8, careerWins: 112)
        driverGroovy << new DriverGroovy(name: 'Martin Truex Jr.', number: 78, averageFinish: 15.3, careerWins: 32)
        when:
        driverGroovy.each { dg ->
            dg.name +='s'
        }.sort { d1,d2 ->
                d1.number <=> d2.number
        }
        //other sorting options
        //Collections.sort(driverGroovy, {d1,d2 -> d1.number <=> d2.number} as Comparator)
        //driverGroovy.sort {-it?.number } //descending order by number

        then:
        println 'Driver Groovy: '
        driverGroovy.each { dg ->
            println dg
        }

    }

    /**
     * can use groovy style with POJO -> for map based constructor must have empty super constructor
     * sort changed to descending
     */
    def "groovy magic with java object"(){
        given:
        List<DriverJava> driverJava = new ArrayList<>();
        driverJava << new DriverJava(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
        driverJava << new DriverJava(name: 'Jimmie Johnson', number: 48, averageFinish: 9.8, careerWins: 112)
        driverJava << new DriverJava(name: 'Martin Truex Jr.', number: 78, averageFinish: 15.3, careerWins: 32)
        when:
        driverJava.each { dj ->
            dj.name +='s'
        }.sort { d1,d2 ->
            d2.number <=> d1.number
        }

        then:
        println 'Driver Java: '
        driverJava.each { dj ->
            println dj
        }
    }

    def "def immutable -> can not change values of groovy class after set use @Immutable"(){
        given:
        ImmutableGroovy immutableGroovy = new ImmutableGroovy(value:1, description:'test')

        when:
        immutableGroovy.value = 1

        then:
        thrown(ReadOnlyPropertyException)
    }

    def "groovy inheritence through @Delegate"(){
        when:
        PitCrewGroovy pitCrewGroovy = new PitCrewGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98, crewMembersAmt: 8)
        then:
        println pitCrewGroovy
    }

}
