package com.tutorial

import groovy.transform.BaseScript
import spock.lang.Specification

/**
 * Created by cmcke on 3/12/2017.
 */
class DbSpec extends Specification{

//example of how to call a groovy script within code
    def "configure db test"(){
        when:
        GroovyShell shell = new GroovyShell()
        def script = shell.parse(new File('populate_h2_code.groovy'))
        script.init()

        then:
            assert true

    }
}
