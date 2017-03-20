package com.tutorial.bean

import groovy.transform.Immutable

/**
 * Created by req85404 on 03/20/2017.
 */
@Immutable
class ImmutableGroovy {
    int value;
    String description;

    String toString(){ "ImmutableGroovy{ value=$value, description=$description}"}
}
