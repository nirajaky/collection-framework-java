package org.example.stringspool;

public class StringPool {

    // Immutable objects are the ones that cannot be changed once they are created
    // This is an object whose internal state will not change once they are created

    // For Security purpose or Thread Safety we need sometimes Immutability behavior of an Object

    public StringPool() {
        String s1 = "Niraj";

        String s2 = "K" + s1.substring(1);

        String s3 = s1;              // Both s1 and s3 is pointing to the same location
        System.out.printf("%s %b%n", "s1 == s3", s1 == s3);
        s3 = s3 + " Kumar";          // Now s3 is pointing to the new address, and s1 remains same
        System.out.printf("%s %b%n", "s1 == s3", s1 == s3);

        System.out.println("S1 " + s1);
        System.out.println("S2 " + s2);
        System.out.println("S3 " + s3);

        /*
            Double equal to (==) compares the memory address
            .equal() method compares the content

            When we define :
            String s1 = "Niraj";

            an intern() method is called which checks weather "Niraj" String is present is String Constant Poop
            If it is already present it just returns the address for that Object
            else it creates new String Object and returns the memory address for the new Object(String) created.

            intern() method is used to manage the String Constant Pool
        */

        String a1 = "Kumar";
        String a2 = new String("Kumar");   // It creates a new String(Object) at new memory space
        System.out.println(a1 == a2);             // False  (Compares the address)
        System.out.println(a1.equals(a2));        // True   (Compares the content)

    }
}
