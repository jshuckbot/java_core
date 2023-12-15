package ru.gb;

import java.util.Arrays;

/**
 * lesson 3
 *
 */
public class Program 
{
    public static void main( String[] args )
    {
        Human[] employee = {
                new Freelancer("Ivan", "Gorutskii", 32, 780),
                new Worker("Vladimir", "Shah", 24, 38809),
                new Freelancer("Stanislav", "Muratov", 45, 400),
                new Worker("Alex", "lozhov", 39, 51033),
        
        };
        showEmployee(employee);
        Arrays.sort(employee);
        showEmployee(employee);
        
        Corporation<Human> corporation = new Corporation<>(employee);
        showEmployeeCorporation(corporation);
        
    }
    
    public static void showEmployee(Human[] humans) {
        for (Human human : humans)
            System.out.println(human);
        System.out.println("-".repeat(100));
    }
    
    public static void showEmployeeCorporation(Corporation<Human> corporation) {
        for (Human human : corporation) {
            System.out.println(human);
        }
      
    }
}

