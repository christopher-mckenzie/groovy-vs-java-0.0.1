package com.tutorial

import com.tutorial.bean.DriverGroovy
import spock.lang.Specification

/**
 * Created by req85404 on 03/13/2017.
 */
class XmlSpec extends Specification{

    def "xml parser -> read in xml"(){
        given:
            List<DriverGroovy> drivers = new ArrayList<>()
        when:
            def xml = new XmlParser().parse("sample.xml") //parse xml -> turns xml into DOM
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
            drivers.size() == 2
    }

    def "xml parser with attributes -> read in xml"(){

    }
    def "xml builder -> create xml file"(){
//                MarkupBuilder builder = new MarkupBuilder()
//        builder.games { //games is not a method but rather here it is a node
//            results.each { g ->
//                game ( //creates a game node with the following attributes
//                        outcome:"$g.away $g.aScore, $g.home $g.hScore",
//                        lat:g.stadium.latitude,
//                        lng:g.stadium.longitude
//                )
//            }
//        }
        /** sample output
         * <games>
         *     <game outcome='Boston Red Sox 4, Colorado Rockies 3'
         *       lat='39.7564956' lng='-104.9940163'/>
         * </games>
         */
    }
}
