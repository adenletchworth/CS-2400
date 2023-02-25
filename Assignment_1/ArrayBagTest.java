package Assignment_1;

public class ArrayBagTest {
   
    public <T> T[] union(T[] bag1, T[] bag2){

        T[] unionBag = new T[bag1.length+bag2.length];
        int curr = 0; 
        for(int i = 0; i < bag1.length;i++){
            unionBag[curr++] = bag1[i];
        }

        for(int i = 0; i < bag2.length;i++){
            unionBag[curr++] = bag2[i];
        }

        return unionBag;
    }
}
