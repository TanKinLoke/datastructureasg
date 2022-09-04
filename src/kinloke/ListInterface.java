package kinloke;

public interface ListInterface<T> {
    public boolean add(T newEntry);
    public boolean add(T newEntry, int newPosition);
    public T remove(int givenPosition);
    public T getFirst();
    public T getLast();
    public void clear();
    public boolean replace(int givenPosition, T newEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T entry);
    public int size();
    public T[] toArray();
    public boolean isEmpty();
}
