package org.example.stringspool;

import java.util.HashSet;
import java.util.Set;

public final class ImmutableClass {

    /*
        1. For a class to be Immutable, It should not extend any other class. So, we use final keyword.
        2. We cannot change any entities of Immutable class from outside. So, all the entries should be private.
        3. In Immutable class, once the data is set, we cannot change it. So, we don't need any setter method,
           and it has to be final
    */

    private final int id;
    private final String name;             // Primitive Data Types and Wrapper classes are Immutable itself, So deep copy is not needed
    private final Set<Integer> sets;       // Since classes of Set Interface are mutable, We need to create a deep copy

    public ImmutableClass(int id, String name, Set<Integer> sets) {
        this.id = id;
        this.name = name;
        this.sets = new HashSet<>(sets);    // Create a deep copy, so that it cannot be muted from constructor class
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Integer> getSets() {
        return new HashSet<>(sets);       // Create a deep copy, so that it cannot be muted from outside class
    }
}
