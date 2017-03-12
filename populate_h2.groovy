package com.tutorial

import com.tutorial.bean.DriverGroovy
import groovy.sql.Sql

/**
 * Created by cmcke on 3/12/2017.
 */

def init() {
    def drivers = []
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)
    drivers << new DriverGroovy(name: 'Dale Enhardt Jr', number: 88, averageFinish: 13.2, careerWins: 98)

    Sql db = Sql.newInstance(
            url: 'jdbc:h2:8090/drivers', driver: 'org.h2.Driver')

    db.execute "drop table if exists driver_data;"
    db.execute '''
    create table driver_data(
        id int not null auto_increment,
        name varchar(50) not null,
        number int not null,
        average_finish double,
        career_wins int,
        primary key(id)
    );
'''

    drivers.each { driver ->
        println driver
        db.execute """
        insert into driver_data(name,number,average_finish,career_wins)
        values(${driver.name},${driver.number},${driver.averageFinish},${driver.careerWins});
    """
    }

    assert db.rows('select * from driver_data').size() == drivers.size()
}