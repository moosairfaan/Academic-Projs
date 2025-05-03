import java.util.Random;

public class Unsorted_Optimized{
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
                n = insertUnsOpt(arr, rand.nextInt(10000000), n);
            }

            int lastInsertedVal = arr[n-1];
            int newValToInsert = rand.nextInt(10000000);


            //Fetch
            long startTime = System.currentTimeMillis();
            int fetchIterations = fetchUnsOpt(arr, lastInsertedVal, n);
            long endTime = System.currentTimeMillis();

            System.out.println("Fetched last inserted value (" 
            + lastInsertedVal + ") in " + fetchIterations + " iterations.");

            System.out.println("Fetch time: " + (endTime-startTime) + " ms.");

            //Insert
            long startTime1 = System.currentTimeMillis();
            n = insertUnsOpt(arr, newValToInsert, n);
            long endTime1 = System.currentTimeMillis();

            System.out.println("Inserted val: " + newValToInsert);
            System.out.println("Insert time: " + (endTime1-startTime1) + " ms.");

            //Delete
            long startTime2 = System.currentTimeMillis();
            int deleteIterations = deleteUnsOpt(arr, lastInsertedVal, n);
            if (deleteIterations != -1) n--;
            long endTime2 = System.currentTimeMillis();

            System.out.println("Deleted value (" + lastInsertedVal + 
            ") in " + deleteIterations + " iterations.");

            System.out.println("Delete time: " + (endTime2-startTime) + " ms.");
        
        }
    }

    public static int fetchUnsOpt(int arr[], int key, int n){
        for (int i = 0; i<n; i++){
            if (arr[i] == key){
                return i+1;
            }
        }
        return -1;
    }
    
    public static int insertUnsOpt(int arr[], int key, int n){
        if (n >= arr.length){
            System.out.println("Array is full, cannot insert.");
            return n;
        }
        arr[n] = key;
        return n+1;
    }

    public static int deleteUnsOpt(int[] arr, int key, int n){
        //find position
        for(int i = 0; i<n; i++){
            if (arr[i] == key){
                arr[i] = arr[n-1];
                return i+1;
            }
        }
        return -1;
    }
}