package Assignment_1;

public interface BagInterface<T>{
   
   public Bag<T> intersection(Bag<T> bag2);

   public Bag<T> union(Bag<T> bag2);

   public Bag<T> difference(Bag<T> bag2);

   public boolean isEmpty();

   public boolean add(T anEntry);

   public T remove();

   public boolean remove(T anEntry);

   public int getCurrentSize();

   public int getFrequencyOf(T anEntry);

   public boolean contains(T anEntry);

   public T[] toArray();
    
}
