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

## Generic
- Generic allows only Reference/Wrapper Class, It does not support primitive type
- Means List<int> is wrong
- List<Integer> is correct
- Since Collection Framework has to deal with Reference type Object creation to provide utility classes and methods,
- So, It accepts only Wrapper class as template parameters


