/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinloke;

/**
 *
 * @author user
 */
public interface ListInterface<T> {
    public boolean add(T newEntry);
    public boolean add(T newEntry, int newPosition);
    public T remove(int givenPosition);
    public T getFront();
    public T getRear();
    public void clear();
    public boolean replace(int givenPosition, T newEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T entry);
    public int size();
    public T[] toArray();
    public boolean isEmpty();
}
