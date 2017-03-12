package com.tutorial

import groovy.transform.BaseScript
import spock.lang.Specification

/**
 * Created by cmcke on 3/12/2017.
 */
class DbSpec extends Specification{


    def "configure db test"(){
        given:
            def a = 'lo'
        when:
        GroovyShell shell = new GroovyShell()
        def script = shell.parse(new File('populate_h2.groovy'))
        script.init()

        then:
            2 == a.size()

    }
}
