package us.mattgreen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserList {
    private ArrayList<Talkable> zoo;

    public GetUserList(ArrayList<Talkable> zoo) {
        Scanner kb = new Scanner(System.in);
        String type, name, choice;
        Object data;

        //Ask user for Animal types
        do {
            do {
                System.out.print("Enter Animal Type to Add: ");
                try {
                    type = checkType(kb.nextLine());
                } catch (InputTypeVerifier e) {
                    System.out.println(e.getMessage());
                    type = "";
                }
            } while (type == "");
            System.out.print("Enter " + type + "'s name: ");
            name = kb.nextLine();
            data= null;
            if (type.equals("cat")) {
                System.out.print("Enter mouse killed: ");
                do {
                    try {
                        data = kb.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("Please enter a number for mouse killed: ");
                    }
                    kb.nextLine(); //process next line from nextInt called
                } while (data ==  null);
                //add Cat
                zoo.add(new Cat((int)data, name));
            } else if(type.equals("dog")) {
                System.out.print("Is the dog friendly (Y/N)? ");
                choice = kb.nextLine();
                data = choice.equalsIgnoreCase("y");
                //add Dog
                zoo.add(new Dog((boolean)data, name));
            } else if(type.equals("teacher")) {
                System.out.print("Enter age: ");
                do {
                    try {
                        data = kb.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.print("Please enter a number for age: ");
                    }
                    kb.nextLine(); //process next line from nextInt called
                } while (data == null);
                //add Teacher
                zoo.add(new Teacher((int)data, name));
            } else System.out.println("Nothing added.");
            System.out.print("Add More (Y/N)? ");
            choice = kb.nextLine();
        } while (choice.equalsIgnoreCase("y"));
        this.zoo = zoo;
    }

    private String checkType(String type) throws InputTypeVerifier {
        type = type.toLowerCase();
        if (!type.equals("cat") && !type.equals("dog") && !type.equals("teacher")) {
            InputTypeVerifier e = new InputTypeVerifier(type);
            throw e;
        }
        return type;
    }

    public ArrayList<Talkable> getZoo() {
        return zoo;
    }
}
