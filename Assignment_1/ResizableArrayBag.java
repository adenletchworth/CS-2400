package Assignment_1;
public class ResizableArrayBag<T> implements BagInterface<T> {
    
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ResizableArrayBag(){
        this(DEFAULT_CAPACITY);
    }
    public ResizableArrayBag(int capacity){
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[capacity];
        bag = temp;
        numberOfEntries = 0;
    }
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    public boolean add(T entry){
        if(isArrayFull())
        resize();

        bag[numberOfEntries++] = entry;
        return true;
    }
    public T remove(){
        if(isEmpty())
        return null;

        T temp = bag[numberOfEntries-1];
        bag[numberOfEntries-1] = null;
        numberOfEntries--;
        return temp;
    }
    public boolean remove(T anEntry){
        if(isEmpty())
        return false;

        int remove = getIndexOf(anEntry);
        bag[remove] = bag[numberOfEntries-1];
        numberOfEntries--;
        return true;
    }
    private void resize(){
        @SuppressWarnings("unchecked")
        T[] temp = (T[])new Object[numberOfEntries*2];
        for(int i = 0; i < numberOfEntries;i++){
            temp[i] = bag[i];
        }
        bag = temp;
    }
    public int getCurrentSize(){
        return numberOfEntries;
    }
    public int getFrequencyOf(T anEntry){
        int ret = 0;
        for(int i = 0; i < numberOfEntries;i++){
            if(bag[i].equals(anEntry))
            ret++;
        }
        return ret;
    }
    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }
    public boolean contains(T anEntry){
        if(isEmpty())
        return false;

        for(int i = 0; i < numberOfEntries;i++){
            if(bag[i].equals(anEntry))
            return true;
        }
        return false;
    }
    public T[] toArray(){

        @SuppressWarnings("unchecked")
        T[] ret = (T[]) new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries;i++){
            ret[i] = bag[i];
        }
        return ret;
    }
    private boolean isArrayFull(){
        return numberOfEntries >= bag.length;
    }
    private int getIndexOf(T anEntry){        
        if(isEmpty())
        return -1;

        for(int i = 0; i < numberOfEntries;i++){
            if(anEntry.equals(bag[i]))
            return i;
        }
        return -1;

    }
    public ResizableArrayBag<T> union(ResizableArrayBag<T> bag2){
        ResizableArrayBag<T> unionBag = new ResizableArrayBag<T>();
        T[] arrayBag = bag2.toArray();
        for(int i = 0; i < numberOfEntries; i++){
            unionBag.add(bag[i]);
        }
        for(int i = 0;i < arrayBag.length; i++){
            unionBag.add(arrayBag[i]);
        }
        return unionBag;  
    }
    public ResizableArrayBag<T> intersection(ResizableArrayBag<T> bag2){
        ResizableArrayBag<T> intersectBag = new ResizableArrayBag<T>();
        for(int i = 0; i < numberOfEntries;i++){
            if(bag2.contains(bag[i]))
            intersectBag.add(bag[i]);
        }
        return intersectBag;
    }
    public ResizableArrayBag<T> difference(ResizableArrayBag<T> bag2){
        ResizableArrayBag<T> differenceBag = new ResizableArrayBag();
        T[] arrayBag = bag2.toArray();
   
        for(int i=0;i<numberOfEntries;i++){
        differenceBag.add(bag[i]);
        }
        for (int i=0; i<arrayBag.length; i++) {
        if(differenceBag.contains(arrayBag[i])) 
        differenceBag.remove(arrayBag[i]);
        }
        return differenceBag;
    }
}
