package com.tutorial.bean

/**
 * Created by req85404 on 03/20/2017.
 * Example to use @Delegate - used to basically extend a class - can of course still use extends
 */
class PitCrewGroovy {
    @Delegate DriverGroovy driverGroovy = new DriverGroovy()
    int crewMembersAmt;

    String toString(){ "PitCrewGroovy{ driverGroovy=$driverGroovy, crewMembersAmt=$crewMembersAmt}"}
}
