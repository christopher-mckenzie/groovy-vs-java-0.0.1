package com.tutorial

import spock.lang.Specification

/**
 * Created by cmcke on 3/27/2017.
 */
class ClosuresSpec extends Specification{

    def 'closure as an object'(){
        given:
            def closure = {a -> "${a}s"}
            def args = ['a','b','c']
        when:
            args = args.collect closure
        then:
            println args
    }

    def 'closure as an object 2.0'(){
        given:
        def closure = {a, v -> "$a=$v"}
        def args = [1:'a',2:'b',3:'c']
        when:
        args = args.collect closure
        then:
        println args
    }
}
