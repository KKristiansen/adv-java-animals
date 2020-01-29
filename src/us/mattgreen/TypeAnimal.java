package us.mattgreen;

import java.util.Scanner;

public class TypeAnimal {

    public String type;

    public String getAnimalType() {
        Scanner kb = new Scanner(System.in);
        System.out.print("What type of animal do you want to create: ");
        type=kb.nextLine();
        return type;
    }


}
