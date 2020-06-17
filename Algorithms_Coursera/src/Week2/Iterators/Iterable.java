package Week2.Iterators;

/*
        this two interface should be implemented to make a structure iterable
 */

// generate a iterator
interface Iterable<Item> {
    Iterator<Item> iterator();
}


// iterator contains hasNext() and next()
interface Iterator<Item> {
    boolean hasNext();

    Item next();

    // void remove();
}
