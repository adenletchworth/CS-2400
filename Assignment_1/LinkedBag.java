package Assignment_1;

public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }
    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            next = null;
            
        }
        public T getData(){
            return this.data;
        }
        public void setData(T data){
            this.data = data;
        }
        public Node getNextNode(){
            return this.next;
        }
        public void setNextNode(Node next){
            this.next = next;
        }
    }
    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node curNode = firstNode;

        while(!found && curNode != null){
            if(anEntry.equals(curNode.getData())){
                found = true;
            }
            else
            curNode = curNode.getNextNode();
        }
        return curNode;
    }
    public int getCurrentSize(){
        return numberOfEntries;
    }
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;

        return true;
    }
    public T remove(){
        T ret = null;
        if(firstNode != null){
            ret = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return ret;
    }
    public boolean remove(T anEntry){
        boolean ret = false;
        Node temp = getReferenceTo(anEntry);
        if(temp != null){
            temp.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            ret = true;
        }
        return ret;
    }
    public void clear(){
        
        while(!isEmpty()){
        remove();}
    }

    public int getFrequencyOf(T anEntry){
        int count = 0;
        int k = 0;
        Node curr = firstNode;
        while((k < numberOfEntries) && (curr != null)){
            if(anEntry.equals(curr.getClass()))
            count++;

            k++;
            curr = curr.getNextNode();
        }
        return count;
    }
    public boolean contains(T anEntry){
        boolean found = false;
        Node curr = firstNode;

        while(!found && (curr != null)){
            if(anEntry.equals(curr.getData())){
                found = true;
            }else{
                curr = curr.getNextNode();
            }
        }
        return found;
    }
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] ret = (T[])new Object[numberOfEntries];
        int i = 0;
        Node curr = firstNode;
        while((i < numberOfEntries) && (curr != null)){
            ret[i++] = curr.getData();
            curr = curr.getNextNode();
        }
        return ret;
    }
    public LinkedBag<T> union(LinkedBag<T> bag2){
        T[] linkBag = toArray();
        T[] linkBag2 = bag2.toArray();

        LinkedBag<T> ret = new LinkedBag<>();

        for(int i = 0; i < Math.max(linkBag.length,linkBag2.length);i++){
            if(i < linkBag.length)
            ret.add(linkBag[i]);
            if(i < linkBag2.length)
            ret.add(linkBag2[i]);
        }
        return ret;

    }
    public LinkedBag<T> difference(LinkedBag<T> bag2){
        LinkedBag<T> differenceBag = new LinkedBag();
        T[] arrayBag = bag2.toArray();
        T[] arrayBag2 = toArray();
   
        for(int i=0;i<numberOfEntries;i++){
        differenceBag.add(arrayBag2[i]);
        }
        for (int i=0; i<arrayBag.length; i++) {
        if(differenceBag.contains(arrayBag[i])) 
        differenceBag.remove(arrayBag[i]);
        }
        return differenceBag;
 
    }
    public LinkedBag<T> intersection(LinkedBag<T> bag2){
        T[] linkBag = toArray();
        LinkedBag<T> ret = new LinkedBag<>();
        for(int i = 0; i < linkBag.length;i++){
            if(bag2.contains(linkBag[i]))
            ret.add(linkBag[i]);
        }
        return ret;
    }
    
}
