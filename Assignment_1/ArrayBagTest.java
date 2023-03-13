package Assignment_1;

import java.util.Arrays;

public class ArrayBagTest{
    public static void main(String[] args){
        ResizableArrayBag<String> bag1 = new ResizableArrayBag<String>(10);
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(10);

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        BagInterface<String> everything = bag1.union(bag2);
        System.out.println(Arrays.toString(everything.toArray()));

        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.println(Arrays.toString(commonItems.toArray()));

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        System.out.println(Arrays.toString(leftOver1.toArray()));

        BagInterface<String> leftOver2 = bag2.difference(bag1);
        System.out.println(Arrays.toString(leftOver2.toArray()));
    }
   
}
