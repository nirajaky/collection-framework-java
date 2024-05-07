# collection-framework-java

## Collection Framework
- The Java Collection Framework provides various sets of standard utility classes for managing collections/data.
- The core framework is provided in java.util package.
- It has three main parts -> 
    * The core intefaces
    * The implementations of the interfaces( Concret Classes)
    * Static Utility Methods associated with Collections to do certain operations like insertion or deletion

- Collection calls itself as -> I am Iterable. Means if any concret class is implementing an Collection it will have to    implement the methods defined in Iterable( hasNext() & next())

- Collection Interface has the following method ->
    * boolean containsAll(Collection<?> c)
    * boolean addAll(Collection<? extends E> c)
    * boolean removeAll(Collection<?> c)
    * boolean retainAll(Collection<?> c)
    * void clear()

## Lists
- Lists are collections that maintain the order of elements(order of insertion and deletion)
- Elements are positioned based, means starting from index 0
- List Methods ->
    * E get(int index)
    * E set(int index, E element)
    * void add(int index, E element)
    * boolean addAll(int index, Collection<? extends E> c)
    * E remove(int index)

### ListIterator
- Can Iterate in both the direction.
- ListIterator extends Iterater (interface)
- Iterrator has next() and hasNext() method. 
- In addition it has : pervious() and hasPrevious() methods.

## Queue
- Queue interface extends Collection interface with the following methods:
    * boolean add(E element)    // It throws IllegalArgumentException when Queue is full
    * boolean offer(E element)  // If does not throw any Exception, So we use this often instead of add()
    * E remove()
    * E poll()                  // Removes first element without any exceptions, will return null - If no element present
    * E peek()                  // Get the first Element (FIFO), If no items present then null is returned
    * E element()               // Get the first Element (FIFO), If no items present then Exception is thrown

## Deque
- Deque interface extends Queue interface that allows double operation.
- Insertion and Deletion can be done at both the ends.
- Both FIFO and LIFO operation are supported in Deque.
- Methods ->
- Adding Element
    * boolean offerFirst(E element)
    * boolean offerLast(E element)    // Equivalent to offer() of Queue
    * void addFirst(E element)
    * void addLast(E element)         // Equivalent to add() of Queue
    * void push(E element)            // Similar to addFirst()
- Removing Element
    * E pollFirst()
    * E pollLast()
    * E removeFirst()
    * E removeLast()
    * E pop()                          // Similar to removeFirst()
- Examining Element
    * E peekFirst()
    * E peekLast()
    * E getFirst()                     // Equivalent to element() of Queue
    * E getLast()

## peek() = View/Get
## offer() = add
## poll()  = remove

## Generic
- Generic allows only Reference/Wrapper Class, It does not support primitive type
- Means List<int> is wrong
- List<Integer> is correct
- Since Collection Framework has to deal with Reference type Object creation to provide utility classes and methods,
- So, It accepts only Wrapper class as template parameters


