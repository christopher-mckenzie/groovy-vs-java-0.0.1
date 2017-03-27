package com.tutorial.swing

import com.tutorial.bean.DriverGroovy
import com.tutorial.dao.DriverGroovyDao
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout

/**
 * Created by req85404 on 03/21/2017.
 * Example of creating a swing ui - created to play around with
 * main method will load drivers from json then present a ui to add new ones, then on save writes entire list to file for preservation
 * possible use case- easy way to insert data into a file
 */
class SwingGui {
    static List<DriverGroovy> drivers;
    def static void main(def args){
        drivers = new DriverGroovyDao().loadDrivers()
        new SwingBuilder().edt {
            lookAndFeel 'nimbus'
            frame(title: 'test-data', defaultCloseOperation: JFrame.EXIT_ON_CLOSE, size: [400, 450],locationRelativeTo: null, show: true) {
                borderLayout(vgap: 5)

                panel(constraints: BorderLayout.CENTER, border: compoundBorder([emptyBorder(10), titledBorder('Enter driver test data:')])) {
                    tableLayout {
                        tr {
                            td { label 'Name:' }
                            td { textField text: 'Richard Petty', id: 'nameField', columns: 20 }
                        }
                        tr {
                            td { label 'Number:' }
                            td { textField text: '43', id: 'numberField', columns: 2 }
                        }
                        tr {
                            td { label 'Average Finish:' }
                            td { textField text: '0.0', id: 'averageFinishField', columns: 5 }
                        }
                        tr {
                            td { label 'Career Wins:' }
                            td { textField text: '0', id: 'careerWinsField', columns: 3 }
                        }
                    }
                }
                panel(constraints: BorderLayout.SOUTH) {
                    button text: 'next', actionPerformed: {
                        addDriver nameField.text, Integer.parseInt(numberField.text), Double.parseDouble(averageFinishField.text), Integer.parseInt(careerWinsField.text)

                    }
                    button text: 'save', actionPerformed: {
                        saveDrivers()
                    }
                }
            }
        }
    }
    def static addDriver(String name, int number, double averageFinish, int careerWins){
        drivers << new DriverGroovy(name: name, number: number, averageFinish: averageFinish, careerWins: careerWins)
        println "driver added: ${drivers.get(drivers.size() - 1)}"
    }
    def static saveDrivers(){
        new DriverGroovyDao().insertDrivers drivers
    }

}
