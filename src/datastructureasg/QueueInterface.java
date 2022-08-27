/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureasg;

/**
 *
 * @author user
 */
public interface QueueInterface<T> {
    public void enqueue(T newEntry);
    public void enqueueAll(T[] newEntries);
    public T dequeue();
    public T getFront();
    public T 
}
