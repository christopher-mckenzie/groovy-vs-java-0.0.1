package com.tutorial.bean;

/**
 * Created by cmcke on 3/11/2017.
 * Sample to show differences between a POGO and a POJO
 */
public class DriverJava {
    private String name;
    private int number;
    private double averageFinish;
    private int careerWins;

    public DriverJava() {
        super();
    }

    public DriverJava(int  number){
        super();
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAverageFinish() {
        return averageFinish;
    }

    public void setAverageFinish(double averageFinish) {
        this.averageFinish = averageFinish;
    }

    public int getCareerWins() {
        return careerWins;
    }

    public void setCareerWins(int careerWins) {
        this.careerWins = careerWins;
    }

    @Override
    public String toString() {
        return "DriverJava{" + "name='" + name + ", number=" + number + ", averageFinish=" + averageFinish + ", careerWins=" + careerWins + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverJava that = (DriverJava) o;

        if (number != that.number) return false;
        if (Double.compare(that.averageFinish, averageFinish) != 0) return false;
        if (careerWins != that.careerWins) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + number;
        temp = Double.doubleToLongBits(averageFinish);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + careerWins;
        return result;
    }
}
