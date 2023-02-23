package entities;

import java.util.Objects;

public class CommissionEmployee extends Employee {//A class representing the profit percentage of an employee according to his sales
   private float grossSales;
   private int commision;
   public CommissionEmployee(){
       grossSales = commision = 0;
   }

    public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision) throws InvalidValueException {
        super(firstName, lastName, id);
        setGrossSales(grossSales);
        setCommision(commision);
    }

    public float getGrossSales() {
        return grossSales;
    }

    public int getCommision() {
        return commision;
    }

    public void setGrossSales(float grossSales) throws InvalidValueException {
        if(grossSales<0){
            throw new InvalidValueException("The weekly profit is less than 0 and it cannot be");
        }
       this.grossSales = grossSales;
    }

    public void setCommision(int commision) throws InvalidValueException {
       if(commision<=5){
           throw new InvalidValueException("The employee's percentage gains do not make sense");
       }
        this.commision = commision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommissionEmployee that = (CommissionEmployee) o;
        return Float.compare(that.grossSales, grossSales) == 0 && commision == that.commision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grossSales, commision);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "CommissionEmployee{" +
                "grossSales=" + grossSales +
                ", commision=" + commision +
                '}';
    }
    @Override
    public double earnings() {
        return (grossSales*commision)/100;
    }
}
