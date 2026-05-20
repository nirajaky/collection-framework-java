# As Hash Set stores null why tree sets cannot store null?

Great interview question in Java.

---

# 🔹 Why HashSet can store null?

Because `HashSet` internally uses:

```text id="tn1"
HashMap
```

And `HashMap` can handle:

```text id="tn2"
null key
```

---

# 🔹 Important Point

`HashSet` does NOT need comparison/sorting.

It only uses:

* `hashCode()`
* `equals()`

For `null`:

* Java gives special handling internally
* no comparison needed

So:

```java id="tn3"
HashSet<Integer> set =
        new HashSet<>();

set.add(null);
```

✔ Valid.

---

# 🔹 Why TreeSet cannot store null?

Because `TreeSet` internally uses:

```text id="tn4"
TreeMap (Red-Black Tree)
```

And TreeSet must:

```text id="tn5"
compare elements
```

using:

* `compareTo()`
  OR
* `Comparator`

---

# 🔹 Problem with null

Suppose:

```java id="tn6"
TreeSet<Integer> set =
        new TreeSet<>();

set.add(null);
```

Now TreeSet tries to place `null` in sorted order.

It internally does something like:

```java id="tn7"
null.compareTo(other)
```

OR

```java id="tn8"
comparator.compare(null, other)
```

But:

```text id="tn9"
null has no methods
```

So:
❌ `NullPointerException`

---

# 🔹 Important Difference

| Collection | Needs Comparison? | null allowed? |
| ---------- | ----------------- | ------------- |
| HashSet    | ❌ No              | ✔ Yes         |
| TreeSet    | ✔ Yes             | ❌ No          |

---

# 🔹 Historical Note

In very old Java versions:

* empty TreeSet could sometimes accept one null
* later insertion failed

Modern Java:

```text id="tn10"
TreeSet generally does NOT allow null
```

---

# 🔹 Can TreeSet store null with custom Comparator?

Technically:
✔ YES, if comparator explicitly handles null.

Example:

```java id="tn11"
TreeSet<Integer> set =
    new TreeSet<>(
        Comparator.nullsFirst(
            Integer::compareTo
        )
    );

set.add(null);
set.add(10);
set.add(5);

System.out.println(set);
```

Output:

```text id="tn12"
[null, 5, 10]
```

---

# 🔥 Tricky Interview Question

### Q. Why HashSet allows null but TreeSet does not?

✅ Correct answer:

```text id="tn13"
HashSet uses hashing only.
TreeSet requires comparison for sorting.
null cannot be compared.
```

---

# 🔥 Final Answer

👉 `HashSet` allows null because no sorting/comparison is needed.
👉 `TreeSet` normally rejects null because it must compare elements for ordering, and `null` cannot participate in comparison operations.
