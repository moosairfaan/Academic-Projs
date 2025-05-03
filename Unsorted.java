import java.util.Random;

public class Unsorted {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 1000000, 10000000};

        Random rand = new Random();

        for (int size : sizes){
            System.out.println("Testing with array size " + size);

            int[] arr = new int[size + 6];
            int n = size;
            for (int i = 0; i<n; i++){
                arr[i] = rand.nextInt(10000000);
            }
            
            for (int i = 0; i<6; i++){
                n = insertUns(arr, rand.nextInt(10000000), n);
            }

            int newValToInsert = rand.nextInt(10000000);

            int lastInsertedVal = arr[n-1];

            //Fetch
            long startTime = System.currentTimeMillis();
            int fetchIterations = fetchUns(arr, lastInsertedVal);
            long endTime = System.currentTimeMillis();

            System.out.println("Fetched last inserted value (" 
            + lastInsertedVal + ") in " + fetchIterations + " iterations.");

            System.out.println("Fetch time: " + (endTime-startTime) + " ms.");

            //Insert
            long startTime1 = System.currentTimeMillis();
            n = insertUns(arr, newValToInsert, n);
            long endTime1 = System.currentTimeMillis();

            System.out.println("Inserted val: " + newValToInsert);
            System.out.println("Insert time: " + (endTime1-startTime1) + " ms.");

            //Delete
            long startTime2 = System.currentTimeMillis();
            int deleteIterations = deleteUns(arr, lastInsertedVal, n);
            long endTime2 = System.currentTimeMillis();

            System.out.println("Deleted value (" + lastInsertedVal + 
            ") in " + deleteIterations + " iterations.");

            System.out.println("Delete time: " + (endTime2-startTime) + " ms.");
        
        }
    }

    public static int fetchUns(int arr[], int key){
        for (int i = 0; i<arr.length; i++){
            if (arr[i] == key){
                return i+1;
            }
        }
        return -1;
    }
    
    public static int insertUns(int arr[], int key, int n){
        if (n >= arr.length){
            System.out.println("Array is full, cannot insert.");
            return n;
        }
        arr[n] = key;
        return n+1;
    }

    public static int deleteUns(int[] arr, int key, int n){
        //find position
        for(int i = 0; i<n; i++){
            if (arr[i] == key){
                for(int j=i; j<n-1; j++){
                    arr[j] = arr[j+1];
                }
                return i+1;
            }   
        }
        return -1;
    }
}