# Complete Java Collection Framework Guide + Interview Questions + Tricky Concepts

---

# 1. What is Collection Framework?

Java Collection Framework is a set of:

* interfaces
* classes
* algorithms

used to store and manipulate groups of objects dynamically.

---

# 🔹 Main Hierarchy

```text id="cf1"
Iterable
   ↓
Collection
   ├── List
   ├── Set
   └── Queue

Map (separate hierarchy)
```

---

# 2. Iterable Interface

Root interface for enhanced for-loop.

```java id="cf2"
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

---

# 🔹 Important Point

`Iterator<T> iterator();`

is:

* NOT an abstract interface declaration
* it is an abstract method returning Iterator object

---

# 🔹 for-each internally uses Iterator

```java id="cf3"
for(String s : list)
```

Internally:

```java id="cf4"
Iterator<String> it = list.iterator();

while(it.hasNext()) {
    System.out.println(it.next());
}
```

---

# 🔥 Tricky Interview Questions

### Q1. Is Iterator interface abstract inside Iterable?

❌ No.

Only:

```java id="cf5"
iterator()
```

method is abstract.

---

### Q2. Why Iterable needed?

To support:

```text id="cf6"
enhanced for-loop
```

---

# 3. Iterator Interface

Methods:

```java id="cf7"
hasNext()
next()
remove()
```

---

# 🔹 hasNext()

Returns:

```text id="cf8"
boolean
```

telling whether next element exists.

---

# 🔹 Important

Methods inside interface are implicitly:

```text id="cf9"
public abstract
```

So implementing class must implement them.

---

# 🔥 Tricky Questions

### Q. Difference between Iterator and ListIterator?

| Iterator        | ListIterator    |
| --------------- | --------------- |
| Forward only    | Both directions |
| All collections | List only       |

---

# 4. List Interface

Features:

* ordered
* indexed
* duplicates allowed

Implementations:

* ArrayList
* LinkedList
* Vector
* Stack

---

# 5. ArrayList

Internal DS:

```text id="cf10"
Dynamic Array
```

---

# 🔹 Features

✔ Fast random access
✔ Maintains insertion order
✔ Allows duplicates
✔ Allows nulls

---

# 🔹 Complexity

| Operation     | Complexity     |
| ------------- | -------------- |
| get()         | O(1)           |
| add()         | O(1) amortized |
| insert middle | O(n)           |
| remove middle | O(n)           |

---

# 🔹 Why ArrayList fast?

Because internally:

```text id="cf11"
continuous memory array
```

---

# 🔹 Copy Constructor

```java id="cf12"
List<Integer> list2 =
    new ArrayList<>(list1);
```

Can take:

* List
* Set
* Queue
* any Collection

---

# 🔹 subList()

```java id="cf13"
List<Integer> sub =
    list.subList(1,3);
```

⚠️ It is:

```text id="cf14"
view/shallow copy
```

Changes reflect in original list.

---

# 🔹 Avoid subList side effects

```java id="cf15"
List<Integer> copy =
    new ArrayList<>(list.subList(1,3));
```

Now independent copy.

---

# 🔥 Tricky Questions

### Q1. Is ArrayList thread-safe?

❌ No.

---

### Q2. Why ArrayList faster than LinkedList for get()?

Because direct indexing possible.

---

### Q3. Why insertion in middle costly?

Because shifting required.

---

# 6. LinkedList

Internal DS:

```text id="cf16"
Doubly Linked List
```

---

# 🔹 Features

✔ Fast insertion/deletion
❌ Slow random access

---

# 🔹 Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| get(index)    | O(n)       |
| insert/delete | O(1)       |

---

# 🔹 LinkedList implements

```text id="cf17"
List + Deque + Queue
```

---

# 🔹 Queue Methods

## offer()

Adds element safely.

```java id="cf18"
queue.offer(10);
```

---

## poll()

Removes head.

```java id="cf19"
queue.poll();
```

Returns:

* removed element
* null if empty

---

## peek()

Returns head without removal.

---

# 🔥 Tricky Questions

### Q1. Difference between add() and offer()

| add               | offer         |
| ----------------- | ------------- |
| Exception if fail | false if fail |

---

### Q2. Difference between remove() and poll()

| remove             | poll          |
| ------------------ | ------------- |
| Exception if empty | null if empty |

---

# 7. Vector

Same as ArrayList but:

```text id="cf20"
thread-safe
```

because methods synchronized.

---

# 🔹 Thread-safe Meaning

Only one thread executes method at a time.

---

# 🔹 Why slower?

Locking overhead.

---

# 🔥 Tricky Questions

### Q1. Difference between ArrayList and Vector?

| ArrayList        | Vector       |
| ---------------- | ------------ |
| Not synchronized | Synchronized |
| Faster           | Slower       |

---

# 8. Stack

LIFO structure.

Methods:

```java id="cf21"
push()
pop()
peek()
```

---

# 🔥 Tricky Questions

### Q. Why Stack legacy?

Modern Java prefers:

```text id="cf22"
Deque
```

---

# 9. Set Interface

Features:

* no duplicates
* not indexed

Implementations:

* HashSet
* LinkedHashSet
* TreeSet

---

# 10. HashSet

Internal DS:

```text id="cf23"
HashMap
```

Internally:

```text id="cf24"
element → key
dummy object → value
```

---

# 🔹 Same dummy object

All elements use same value object:

```java id="cf25"
private static final Object PRESENT
```

---

# 🔹 Duplicate detection

Uses:

```text id="cf26"
hashCode + equals
```

---

# 🔹 Important

Custom objects should override:

```java id="cf27"
equals()
hashCode()
```

---

# 🔹 Default behavior

Inherited from Object:

```java id="cf28"
equals() → reference comparison
hashCode() → identity based
```

---

# 🔹 Mutable key problem

If hashCode changes after insertion:

```text id="cf29"
element becomes unreachable
```

---

# 🔹 Why HashSet sometimes looks sorted?

Coincidence due to hashing.

❌ No sorting guarantee.

---

# 🔥 Tricky Questions

### Q1. Will HashSet work without equals/hashCode override?

✔ Yes
❌ Logical duplicate detection fails

---

### Q2. Why duplicates not allowed?

Because HashMap keys unique.

---

### Q3. Can HashSet store null?

✔ One null allowed.

---

# 11. LinkedHashSet

HashSet + insertion order.

Internal:

```text id="cf30"
HashMap + Linked List
```

---

# 🔥 Tricky Questions

### Q. Difference HashSet vs LinkedHashSet?

| HashSet  | LinkedHashSet   |
| -------- | --------------- |
| No order | Insertion order |

---

# 12. TreeSet

Internal DS:

```text id="cf31"
TreeMap (Red Black Tree)
```

---

# 🔹 Sorting

Requires:

* Comparable
  OR
* Comparator

---

# 🔹 TreeSet uses

```text id="cf32"
compareTo()/compare()
```

NOT:

```text id="cf33"
hashCode()
```

---

# 🔹 Duplicate logic

Duplicate if:

```java id="cf34"
compareTo() == 0
```

---

# 🔥 Tricky Questions

### Q1. Will TreeSet work for custom class by default?

❌ No.

Throws:

```text id="cf35"
ClassCastException
```

---

### Q2. Does TreeSet use equals()?

❌ No.

Uses comparison only.

---

### Q3. Can TreeSet store null?

Usually ❌ No.

---

# 13. Comparable vs Comparator

---

# 🔹 Comparable

Inside class.

```java id="cf36"
compareTo()
```

Natural ordering.

---

# 🔹 Comparator

Outside class.

```java id="cf37"
compare()
```

Custom ordering.

---

# 🔹 Why called natural ordering?

Because class itself defines default sorting logic.

---

# 🔥 Tricky Questions

### Q1. Which has precedence?

Comparator overrides Comparable.

---

### Q2. Can class implement both?

✔ Yes.

---

# 14. Queue Interface

FIFO structure.

Implementations:

* PriorityQueue
* LinkedList
* ArrayDeque

---

# 15. PriorityQueue

Internal DS:

```text id="cf38"
Binary Heap
```

---

# 🔹 Ordering

Default:

```text id="cf39"
min heap
```

---

# 🔹 Why not fully sorted?

Only heap property maintained.

---

# 🔹 Custom descending order

```java id="cf40"
PriorityQueue<Integer> pq =
    new PriorityQueue<>(
        Collections.reverseOrder()
    );
```

---

# 🔹 What is reverseOrder()?

Returns Comparator object.

---

# 🔹 Custom compare method

```java id="cf41"
PriorityQueue<Integer> pq =
    new PriorityQueue<>(
        (a,b) -> b-a
    );
```

---

# 🔥 Tricky Questions

### Q1. Does PriorityQueue need Comparable?

✔ Yes unless Comparator supplied.

---

### Q2. Why PQ print not sorted?

Heap structure only.

---

# 16. Map Interface

Separate hierarchy.

Stores:

```text id="cf42"
key-value pairs
```

---

# 🔹 Common Maps

* HashMap
* LinkedHashMap
* TreeMap
* Hashtable

---

# 17. HashMap

Internal:

```text id="cf43"
Array of buckets
```

Each bucket:

* LinkedList (Java 7)
* Tree after threshold (Java 8)

---

# 🔹 put()

Returns:

* old value
* null if new key

---

# 🔹 get()

Returns:

* value
* null if absent

---

# 🔹 remove()

Returns:

* removed value
* null if absent

---

# 🔹 Null handling

| Feature    | Allowed |
| ---------- | ------- |
| null key   | one     |
| null value | many    |

---

# 🔹 Uses hashCode + equals

---

# 🔹 HashMap working

```text id="cf44"
1. hashCode
2. bucket selection
3. equals
4. insert/search
```

---

# 🔥 Tricky Questions

### Q1. Why equals and hashCode both needed?

hashCode:

```text id="cf45"
bucket finding
```

equals:

```text id="cf46"
duplicate checking
```

---

### Q2. What if only equals overridden?

Duplicates possible.

---

### Q3. What if mutable key used?

Retrieval may fail.

---

# 18. LinkedHashMap

Maintains insertion order.

Internal:

```text id="cf47"
HashMap + Linked List
```

---

# 🔥 Tricky Questions

### Q. Difference HashMap vs LinkedHashMap?

| HashMap      | LinkedHashMap   |
| ------------ | --------------- |
| Random order | Insertion order |

---

# 19. TreeMap

Internal:

```text id="cf48"
Red Black Tree
```

Sorted map.

---

# 🔹 Requires

Comparable OR Comparator.

---

# 🔹 Complexity

```text id="cf49"
O(log n)
```

---

# 🔥 Tricky Questions

### Q1. Does TreeMap use hashCode?

❌ No.

---

### Q2. Can TreeMap have null key?

Usually ❌ No.

---

# 20. Generics

---

# 🔹 Important Rule

Generics accept:

```text id="cf50"
reference types only
```

---

# 🔹 Allowed

✔ String
✔ Integer
✔ Custom class

---

# 🔹 Not allowed

❌ int
❌ double

Use wrappers.

---

# 🔹 Why wrappers?

Generics internally use:

```text id="cf51"
Object references
```

via type erasure.

---

# 🔥 Tricky Questions

### Q1. Can generics use primitives?

❌ No.

---

### Q2. Can collections store Object?

✔ Yes.

```java id="cf52"
List<Object>
```

---

# 21. Wrapper Classes

All wrappers override:

```java id="cf53"
equals()
hashCode()
```

and implement:

```java id="cf54"
Comparable
```

---

# 🔥 Tricky Questions

### Q. Why Integer works automatically in TreeSet?

Because Integer implements Comparable.

---

# 22. Object Class Methods

Common methods:

```java id="cf55"
toString()
equals()
hashCode()
getClass()
clone()
finalize()
wait()
notify()
notifyAll()
```

---

# 🔹 Why println(object) calls toString()?

Because println internally does:

```java id="cf56"
String.valueOf(obj)
```

which calls:

```java id="cf57"
obj.toString()
```

---

# 🔹 Default toString()

```text id="cf58"
ClassName@hexHashCode
```

---

# 🔥 Tricky Questions

### Q. If toString not overridden what prints?

```text id="cf59"
ClassName@hashcode
```

---

# 23. Immutable vs Mutable

---

# 🔹 Mutable class

Object state can change.

Example:

```java id="cf60"
ArrayList
Student
StringBuilder
```

---

# 🔹 Immutable

Cannot change after creation.

Example:

```java id="cf61"
String
Integer
```

---

# 🔥 Tricky Questions

### Q. Is Java class mutable by default?

✔ Yes unless designed immutable.

---

# 24. Fail-fast Iterator

Collections track modification count.

If modified during iteration:

```text id="cf62"
ConcurrentModificationException
```

---

# 🔥 Tricky Questions

### Q. Why fail-fast?

To detect unsafe concurrent modification.

---

# 25. Time Complexity Cheat Sheet

| Collection    | Search   | Insert   | Sorted  |
| ------------- | -------- | -------- | ------- |
| ArrayList     | O(n)     | O(1)     | ❌       |
| LinkedList    | O(n)     | O(1)     | ❌       |
| HashSet       | O(1)     | O(1)     | ❌       |
| TreeSet       | O(log n) | O(log n) | ✔       |
| HashMap       | O(1)     | O(1)     | ❌       |
| TreeMap       | O(log n) | O(log n) | ✔       |
| PriorityQueue | O(log n) | O(log n) | Partial |

---

# 🔥 MOST IMPORTANT INTERVIEW TOPICS

Focus heavily on:

1. HashMap internal working
2. equals vs hashCode
3. Comparable vs Comparator
4. HashSet vs TreeSet
5. ArrayList vs LinkedList
6. PriorityQueue internals
7. Mutable keys
8. fail-fast iterator
9. Thread safety
10. Time complexities
11. TreeMap vs HashMap
12. Why Map not part of Collection
13. Why TreeSet needs Comparable
14. Why HashSet sometimes appears sorted
15. Generics and type erasure

These are among the most repeatedly asked questions in Java interviews.
