/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.util.Iterator;

/**
 *
 * @author user
 */

public interface QueueInterface<T>{
    public void enqueue(T newEntry);
    public void enqueueAll(T[] newEntries);
    public T dequeue();
    public T getFront();
    public T getRear();
    public boolean replace(int position, T newEntry);
    public boolean remove(T entry);
    public T removeAt(int position);
    public void clear();
    public boolean isEmpty();
    public int count();
    public int getCurrentPosition(T entry);
    public boolean contains(T entry);
    public T[] toArray();
    public String toString();
    public Iterator<T> getIterator();
}
