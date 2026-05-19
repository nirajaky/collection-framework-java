A Lambda Expression is basically a **short way of providing implementation of a functional interface**.

To understand it properly, first understand:

1. Functional Interface
2. Anonymous Class
3. How lambda replaces anonymous class
4. How JVM internally treats it

---

# 1. Functional Interface

A functional interface contains **only one abstract method**.

Example:

```java id="f7jvww"
interface Greeting {
    void sayHello();
}
```

This interface is saying:

> “Any class/object implementing me must provide logic for `sayHello()`”

---

# 2. Before Lambda (Using Anonymous Class)

Before Java 8, if you wanted to provide implementation quickly without creating a separate class:

```java id="q9jr4j"
Greeting g = new Greeting() {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
};
```

This is called an **anonymous inner class**.

---

# 3. What happens internally?

Java creates an object like:

```java id="vms5zi"
class SomeHiddenClass implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
```

Then:

```java id="k6ec38"
Greeting g = new SomeHiddenClass();
```

So:

* interface reference holds object
* object contains implementation
* method executes via dynamic dispatch

---

# 4. Problem with Anonymous Class

Too much boilerplate:

```java id="sjmqri"
new Greeting() {
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
```

Java 8 realized:

> “If functional interface has only ONE method, why write all this extra code?”

So Lambda was introduced.

---

# 5. Same Thing Using Lambda

```java id="d4cs75"
Greeting g = () -> {
    System.out.println("Hello");
};
```

This means:

> “Provide implementation of sayHello() method”

---

# 6. Full Detailed Example (Single File)

```java id="w7udgd"
interface Calculator {
    int calculate(int a, int b);
}

public class LambdaDeepExplanation {

    public static void main(String[] args) {

        System.out.println("===== WITHOUT LAMBDA =====");

        // Anonymous class object implementing Calculator
        Calculator add1 = new Calculator() {

            @Override
            public int calculate(int a, int b) {

                System.out.println("Inside anonymous class calculate()");

                return a + b;
            }
        };

        // Interface reference calling overridden method
        int result1 = add1.calculate(10, 20);

        System.out.println("Result: " + result1);


        System.out.println("\n===== WITH LAMBDA =====");

        // Lambda providing implementation of calculate()
        Calculator add2 = (a, b) -> {

            System.out.println("Inside lambda calculate()");

            return a + b;
        };

        int result2 = add2.calculate(30, 40);

        System.out.println("Result: " + result2);
    }
}
```

---

# 7. Output

```text id="upg5i4"
===== WITHOUT LAMBDA =====
Inside anonymous class calculate()
Result: 30

===== WITH LAMBDA =====
Inside lambda calculate()
Result: 70
```

---

# 8. How Lambda is Captured by Functional Interface

This is the MOST IMPORTANT concept.

When Java sees:

```java id="ojc0xj"
Calculator add2 = (a, b) -> a + b;
```

Java understands:

* Left side type = `Calculator`
* Calculator has ONE abstract method:

```java id="w31y16"
int calculate(int a, int b);
```

So Java maps lambda to that method automatically.

Equivalent thinking:

```java id="b0hksv"
Calculator add2 = new SomeHiddenClass();
```

where hidden class contains:

```java id="rmr6fr"
public int calculate(int a, int b) {
    return a + b;
}
```

---

# 9. How Method Call Works

This line:

```java id="brdh0x"
add2.calculate(30, 40);
```

calls:

```java id="u9f8ir"
return a + b;
```

inside lambda.

So lambda body becomes method implementation.

---

# 10. Why Functional Interface is Mandatory

Suppose interface had 2 methods:

```java id="ff3ykr"
interface Test {
    void m1();
    void m2();
}
```

Now lambda becomes confusing:

```java id="x9a3d6"
() -> System.out.println("Hello")
```

Which method is this for?

* m1?
* m2?

Impossible to decide.

That’s why lambda ONLY works with one abstract method.

---

# 11. Parameter Mapping

Lambda:

```java id="zy4r9e"
(a, b) -> a + b
```

gets mapped automatically to:

```java id="rbr0v6"
int calculate(int a, int b)
```

So:

* `a` → first int
* `b` → second int
* return value → int

---

# 12. Types are Inferred

You can write:

```java id="nnjm6n"
(int a, int b) -> a + b
```

or shorter:

```java id="5i3oyq"
(a, b) -> a + b
```

because compiler already knows method signature from functional interface.

---

# 13. Lambda is NOT Exactly Anonymous Class

Important interview point.

Anonymous class:

* creates separate class file/object structure

Lambda:

* JVM uses `invokedynamic`
* more optimized
* lightweight

So lambda is NOT just syntax sugar internally.

---

# 14. Real Internal Flow

When compiler sees:

```java id="2d2q1f"
Calculator c = (a, b) -> a + b;
```

Compiler roughly creates:

* functional interface target
* method reference internally
* JVM dynamically links implementation

This is why lambdas are faster and lighter than anonymous classes.

---

# 15. Memory View Concept

Without Lambda:

```text id="mbng98"
Calculator ref
      ↓
Anonymous Object
      ↓
calculate() implementation
```

With Lambda:

```text id="kzqt5o"
Calculator ref
      ↓
Lambda implementation target
      ↓
calculate() body
```

---

# 16. Another Real Example (Runnable)

Without Lambda:

```java id="31q0z6"
Runnable r = new Runnable() {

    @Override
    public void run() {
        System.out.println("Thread running");
    }
};
```

With Lambda:

```java id="eg1t2n"
Runnable r = () -> System.out.println("Thread running");
```

Because Runnable has only one method:

```java id="sllvga"
void run();
```

---

# 17. Key Interview Line

> Lambda expression is a concise way to provide implementation of a functional interface using anonymous function syntax.

---

# 18. Final Summary

| Anonymous Class         | Lambda                |
| ----------------------- | --------------------- |
| Verbose                 | Short                 |
| Creates class structure | Lightweight           |
| Explicit override       | Direct implementation |
| Java 7 style            | Java 8 style          |
| More boilerplate        | Cleaner               |

---

# 19. Most Important Understanding

This line:

```java id="f9m9t8"
Calculator c = (a, b) -> a + b;
```

DOES NOT mean:

* function stored directly like JavaScript

It means:

* Java creates implementation compatible with functional interface method.

Java still works through interfaces + objects.
