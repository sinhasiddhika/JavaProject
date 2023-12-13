// manager.Manager class
package manager;

import employee.Employee;

import java.io.*;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int basic, int hra, int da, int ma, int pf, int insurance, int bonus) {
        super(name, basic, hra, da, ma, pf, insurance);
        this.bonus = bonus;
    }
//  @Override
    public void calculateSalary() {
        super.calculateSalary();
        gross += bonus;
        net = gross - pf - insurance;
    }

   
    // File handling methods for saving and loading manager data
    public static void saveManagerData(String filename, Manager[] managers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(managers);
            System.out.println("Manager data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Manager[] loadManagerData(String filename) {
        Manager[] managers = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            managers = (Manager[]) ois.readObject();
            System.out.println("Manager data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing manager data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return managers != null ? managers : new Manager[0];
    }
}
