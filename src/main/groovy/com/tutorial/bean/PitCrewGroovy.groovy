package com.tutorial.bean

/**
 * Created by req85404 on 03/20/2017.
 */
class PitCrewGroovy {
    @Delegate DriverGroovy driverGroovy = new DriverGroovy()
    int crewMembersAmt;

    String toString(){ "PitCrewGroovy{ driverGroovy=$driverGroovy, crewMembersAmt=$crewMembersAmt}"}
}
