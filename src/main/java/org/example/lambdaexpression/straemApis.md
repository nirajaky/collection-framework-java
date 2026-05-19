
## Short Answer

Most Stream API methods accept **functional interfaces** as parameters.

Since lambdas provide implementation of functional interfaces, we can directly pass lambdas into stream methods.

---

# 1. Example

```java id="42ag9w"
List<Integer> nums = Arrays.asList(1, 2, 3, 4);

nums.stream()
    .filter(n -> n % 2 == 0)
    .forEach(n -> System.out.println(n));
```

Here:

* `n -> n % 2 == 0`
* `n -> System.out.println(n)`

are lambda expressions.

---

# 2. Why does this work?

Because:

## `filter()` expects a Predicate

Signature:

```java id="cq1kfs"
Stream<T> filter(Predicate<? super T> predicate)
```

And `Predicate` is a functional interface:

```java id="9xyol5"
interface Predicate<T> {
    boolean test(T t);
}
```

So this lambda:

```java id="a9femv"
n -> n % 2 == 0
```

gets converted into implementation of:

```java id="3hixp2"
boolean test(Integer n)
```

---

# 3. forEach() also uses Functional Interface

Signature:

```java id="nt06h6"
void forEach(Consumer<? super T> action)
```

Consumer:

```java id="vlt6to"
interface Consumer<T> {
    void accept(T t);
}
```

Lambda:

```java id="rd2lqm"
n -> System.out.println(n)
```

becomes implementation of:

```java id="3w3j5n"
void accept(Integer n)
```

---

# 4. Stream API is Built Around Functional Interfaces

Almost every stream method accepts one.

| Stream Method | Functional Interface |
| ------------- | -------------------- |
| `filter()`    | `Predicate`          |
| `map()`       | `Function`           |
| `forEach()`   | `Consumer`           |
| `sorted()`    | `Comparator`         |
| `reduce()`    | `BinaryOperator`     |

---

# 5. Example of Each

## filter → Predicate

```java id="hry9zs"
.filter(x -> x > 10)
```

Means:

```java id="jlwm2r"
boolean test(Integer x)
```

---

## map → Function

```java id="we7zzq"
.map(x -> x * 2)
```

Means:

```java id="r0t5ae"
Integer apply(Integer x)
```

---

## forEach → Consumer

```java id="lyj06n"
.forEach(x -> System.out.println(x))
```

Means:

```java id="a64i4v"
void accept(Integer x)
```

---

# 6. Without Lambda (Anonymous Class)

This:

```java id="9b4c8v"
.filter(x -> x % 2 == 0)
```

is actually equivalent to:

```java id="nxtsz0"
.filter(new Predicate<Integer>() {

    @Override
    public boolean test(Integer x) {
        return x % 2 == 0;
    }
})
```

Lambda removes the boilerplate.

---

# 7. Full Example with Both Styles

```java id="pw0v5o"
import java.util.*;
import java.util.function.Predicate;

public class StreamLambdaDemo {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);

        System.out.println("===== WITHOUT LAMBDA =====");

        nums.stream()
            .filter(new Predicate<Integer>() {

                @Override
                public boolean test(Integer n) {
                    return n % 2 == 0;
                }
            })
            .forEach(System.out::println);


        System.out.println("\n===== WITH LAMBDA =====");

        nums.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.println(n));
    }
}
```

---

# 8. Important Deep Understanding

Stream API itself is NOT lambda.

Instead:

```text id="yjz89e"
Stream API
    +
Functional Interfaces
    +
Lambda Expressions
=
Functional Programming Style in Java
```

---

# 9. Why Stream API Needed Lambdas

Imagine writing this everywhere:

```java id="o0s27m"
new Predicate<Integer>() {
    @Override
    public boolean test(Integer n) {
        return n % 2 == 0;
    }
}
```

Streams would become unreadable.

So lambdas made Stream API practical.

---

# 10. Key Interview Statement

> Stream API methods accept functional interfaces, and lambda expressions provide concise implementations of those functional interfaces.
