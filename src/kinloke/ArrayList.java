package kinloke;

public class ArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int number;
    private static final int DEFAULT_CAPACITY = 5;
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int size) {
        number = 0;
        array = (T[]) new Object[size]; 
    }
    
    @Override
    public boolean add(T newEntry) {
        if (number == array.length)
            extendArray();
        
        array[number] = newEntry;
        number++;
        return true;
    }

    @Override
    public boolean add(T newEntry, int newPosition) {
        if (number == array.length)
            extendArray();
        
        boolean isSuccessful = true;
        
        if (newPosition >= 1 && newPosition <= (number+1)) {
            makeRoom(newPosition);
            array[newPosition - 1]= newEntry;
            number++;
        } else {
            isSuccessful = false;
        }
        
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        
        if (givenPosition >= 1 && givenPosition <= number) {
            result = array[givenPosition - 1];
            removeGap(givenPosition);
            number--;
        }
        
        return result;
    }
    
    @Override
    public T getFirst() {
        if (number > 0) {
            return array[0];
        } else {
            return null;
        }
    }

    @Override
    public T getLast() {
        if (number > 0) {
            return array[number - 1];
        } else {
            return null;
        }
    }

    @Override
    public void clear() {
        number = 0;
        array = (T[]) new Object[array.length];
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        
        if (givenPosition >= 1 && givenPosition <= number)
            array[givenPosition - 1] = newEntry;
        else 
            return false;
        
        return true;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition >= 1 && givenPosition <= number)
            return array[givenPosition - 1];
        else
            return null;
    }

    @Override
    public boolean contains(T entry) {
        boolean found = false;
        for (int index = 0; index < number; index++) {
            if (entry.equals(array[index])) {
                found = true;
                break;
            }
        }
        
        return found;
    }

    @Override
    public int size() {
        return number;
    }
    
    @Override
    public T[] toArray() {
        T[] resultArray = (T[]) new Object[size()]; 
        
        for (int index = 0; index < number; index++) {
            resultArray[index] = array[index];
        }
        
        return resultArray;
    }

    @Override
    public boolean isEmpty() {
        return number == 0;
    }
    
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = number - 1;
        
        for (int index = lastIndex; index >= newIndex; index--) 
            array[index + 1] = array[index];
    }
    
    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = number - 1;
        
        for (int index = removedIndex; index < lastIndex; index++)
            array[index] = array[index + 1];
    }
    
    private void extendArray() {
        T[] newArray = (T[]) new Object[array.length*2];
        
        for (int i = 0; i < array.length; i++) 
            newArray[i] = array[i];
        
        array = newArray;
    }

}
