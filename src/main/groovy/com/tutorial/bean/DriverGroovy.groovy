package com.tutorial.bean

import groovy.transform.EqualsAndHashCode

/**
 * Created by cmcke on 3/11/2017.
 * Plain old groovy obect.
 * @EqualsAndHashCode - generate override methods for equals  and hash code
 * Auto generates getters and setters for attributes. Attributes themselves are  private
 */
@EqualsAndHashCode
class DriverGroovy {
    String name;
    int number;
    double averageFinish;
    int careerWins;

    String toString(){ "DriverGroovy{ name=$name, number=$number, averageFinish=$averageFinish, careerWins=$careerWins}"}
}
