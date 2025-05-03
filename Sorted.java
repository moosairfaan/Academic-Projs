import java.util.Random;

public class Sorted {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 1000000, 10000000};

        for (int size : sizes) {
            System.out.println("Testing with sorted array of size " + size);
            Sorted sortedArray = new Sorted(size + 6); // a bit extra room for inserts

            // Insert `size` random elements
            Random rand = new Random();
            long lastInsertedVal = 0;
            for (int i = 0; i < size; i++) {
                long val = rand.nextInt(10000000);
                sortedArray.insert(val);
                if (i == size - 1) {
                    lastInsertedVal = val; // save the last inserted for fetch/delete test
                }
            }

            long startTime = System.currentTimeMillis();
            int index = sortedArray.find(lastInsertedVal);
            long endTime = System.currentTimeMillis();
            System.out.println("Fetch time: " + (endTime - startTime) + " ms, Index found: " + index);

            // INSERT
            long newVal = rand.nextInt(10000000);
            startTime = System.currentTimeMillis();
            sortedArray.insert(newVal);
            endTime = System.currentTimeMillis();
            System.out.println("Insert time: " + (endTime - startTime) + " ms");

            // DELETE
            startTime = System.currentTimeMillis();
            boolean deleted = sortedArray.delete(lastInsertedVal);
            endTime = System.currentTimeMillis();
            System.out.println("Delete time: " + (endTime - startTime) + " ms, Deleted: " + deleted);

        }
    }

    private long[] a;
    private int nElems;

    public Sorted(int max){
        
        a = new long[max];
        nElems = 0;
    
    }
    
    public int find(long searchKey){
    
        int lowerbound = 0;
        int upperbound = nElems-1;
        int CurIn;
    
        while(true){
            CurIn = (lowerbound+upperbound)/2;
    
            //if statement nested in while loop
            if (a[CurIn] == searchKey){
                return CurIn;
            }
            else if (lowerbound > upperbound){
                return nElems;
            }
            else {
                if (a[CurIn] < searchKey){
                    lowerbound = CurIn + 1;
                }
                else {
                    upperbound = CurIn - 1;
                }
            }
        }
    }

    public void insert(long value){
        int j;
        
        for (j=0; j<nElems; j++){
            if(a[j] > value){
                break;
            }
        }
        for (int k=nElems; k>j; k--){
            a[k] = a[k-1];
        }
        a[j] = value;
        nElems++;
    } //end insert()
    
    public boolean delete(long value){
        int j = find(value);
        if (j == nElems){
            return false;
        }
        else {
            for (int k=j; k<nElems; k++){
                a[k] = a[k+1];
            }
            nElems--;
                return true;
        }
    } //end delete
}