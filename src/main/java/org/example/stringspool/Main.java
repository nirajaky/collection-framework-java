package org.example.stringspool;

/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
class SingleTonClass {
    private static volatile SingleTonClass singleTonClass = null;

    private SingleTonClass() {
        System.out.println("Singleton class");
    }

    public static SingleTonClass getSingletonClass() {
        if (singleTonClass == null) {
            synchronized(SingleTonClass.class) {
                if(singleTonClass == null) {
                    singleTonClass = new SingleTonClass();
                }
            }
        }

        return singleTonClass;
    }
}

public class Main {
    public static void main(String[] args) {

        SingleTonClass s = SingleTonClass.getSingletonClass();
    }
}

