package org.example.queues.UserDefinedClass;

public class StudentMarks implements Comparable<StudentMarks> {

    private int maths;
    private int physics;

    public StudentMarks(int maths, int physics) {
        this.maths = maths;
        this.physics = physics;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "maths=" + maths +
                ", physics=" + physics +
                '}';
    }

    @Override
    public int compareTo(StudentMarks o) {
        /*
               current object < other object
                return -1
               current object > other object
                return 1
               current object == other object
                return 0
         */

        // o ~ other , Other object will come before current object => Descending Order
        return o.maths - this.maths;
    }
}
