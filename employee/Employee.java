


package employee;

import java.util.Random;

 interface Payable {
    void calculateSalary();
}

public class Employee implements Payable {

    public static int nextEmployeeId = 1000;

    public int empId;
    public String name;
    public int basic, hra, da, ma;
    public int pf, insurance;
    public float gross, net;

    public Employee() {
        this.empId = generateEmployeeId();
    }

    public Employee(String name, int basic, int hra, int da, int ma, int pf, int insurance) {
        this.empId = generateEmployeeId();
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.da = da;
        this.ma = ma;
        this.pf = pf;
        this.insurance = insurance;
    }

    private int generateEmployeeId() {
        return nextEmployeeId++;
    }


    public void calculateSalary() {
        gross = basic + (hra * basic) / 100 + (da * basic) / 100 + (ma * basic) / 100;
        net = gross - (pf + insurance);
    }

    public int generateRandomEmployeeId() {
    Random random = new Random();
    return  1000 + random.nextInt(9000); // Random 4-digit employee ID starting from 1000
    }
}
