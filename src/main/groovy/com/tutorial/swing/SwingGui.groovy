package com.tutorial.swing

import com.tutorial.bean.DriverGroovy
import com.tutorial.dao.DriverGroovyDao
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.BorderLayout

/**
 * Created by req85404 on 03/21/2017.
 */
class SwingGui {

    def static void main(def args){
        def driver = new DriverGroovy()
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
                    button text: 'save', actionPerformed: {
                        def nameFinal = nameField.text
                        def numFinal = Integer.parseInt numberField.text
                        def averageFinal = Double.parseDouble averageFinishField.text
                        def careerFinal = Integer.parseInt careerWinsField.text
                        driver = new DriverGroovy(name: nameFinal, number: numFinal, averageFinish: averageFinal, careerWins: careerFinal)
                        new DriverGroovyDao().insertDriver(driver)
                        println driver
                    }
                }
            }
        }
    }
}
