package entities;
import java.util.Objects;
public class HourlyEmployee extends Employee {//Class representing an employee who works by the hour
    private float wage;
    private int hours;

    public HourlyEmployee(String firstName, String lastName, int id, float wage, int hours) throws InvalidValueException {
        super(firstName, lastName, id);
        setWage(wage);
        setHours(hours);
    }

    public HourlyEmployee() {
        //super();
       wage = hours = 0;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) throws InvalidValueException {
        if(wage <=0)
            throw new InvalidValueException("wage cannot be < = 0");
        this.wage = wage;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws InvalidValueException {
        if(hours < 0 )
            throw new InvalidValueException("hours  cannot be equal or less than zero");
        this.hours = hours;
    }

    @Override
    public double earnings() {
        return wage * hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return Float.compare(that.wage, wage) == 0 && hours == that.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wage, hours);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "HourlyEmployee{" +
                "wage=" + wage +
                ", hours=" + hours +
                '}';
    }
}
