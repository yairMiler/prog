package entities;

import java.util.Objects;

public class BasePlusCommisionEmployee extends CommissionEmployee{//Class representing an employee with a salary to which a percentage of the profit from sales is added
    private float baseSalary;

    public BasePlusCommisionEmployee(){
        baseSalary=0;
    }
    public BasePlusCommisionEmployee(String firstName, String lastName, int id, float grossSales, int commision, float baseSalary) throws InvalidValueException {
        super(firstName, lastName, id, grossSales, commision);
        setBaseSalary(baseSalary);
    }

    public void setBaseSalary(float baseSalary) throws InvalidValueException {
        if(baseSalary <= 1000){
            throw new InvalidValueException("The weekly wage is lower than the minimum wage");
        }
        this.baseSalary = baseSalary;
    }

    public float getBaseSalary() {
        return baseSalary;
    }
    public double earnings() {
        return ((super.getCommision()*super.getGrossSales())/100)+baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BasePlusCommisionEmployee that = (BasePlusCommisionEmployee) o;
        return Float.compare(that.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "BasePlusCommisionEmployee{" +
                "baseSalary=" + baseSalary +
                '}';
    }
}
