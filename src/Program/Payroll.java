package Program;

import java.util.Objects;

import entities.*;
public class Payroll {

    public static void main(String[] args)  {
        try {
            Employee[] employees = {new HourlyEmployee("yair", "miller", 314695888, 40.0f, 40),
                                    new CommissionEmployee("nadave", "neman", 276890834, 5000.0f, 15),
                                    new BasePlusCommisionEmployee("yona", "cohen", 345674353, 6000.0f, 16, 1800.0f)};

        for (Employee x : employees) {
            System.out.println(x.toString());
            if(x.equals(employees[2]))//Adds 10 percent to the salary for an employee whose salary is calculated according to the profits from sales
            System.out.println(x.earnings()+((x.earnings()*10)/100));
            else System.out.println(x.earnings());
        }
        }catch (InvalidValueException e){
            throw new RuntimeException(e);
        }
    }
}
