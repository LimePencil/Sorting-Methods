import java.util.Random;
public class SortingMethods {
    private final static int number_of_elements = 1000000;
    public static void main(String[] args) {
        SortingMethods sort =  new SortingMethods();
        Random rand = new Random();
        int[] a = new int[number_of_elements];
        for(int i =0;i<a.length;i++){
            a[i] = rand.nextInt(number_of_elements);
        }
        long startTime = System.nanoTime();
        sort.quickSort(a);
        long elapsedTime = System.nanoTime()-startTime;
        System.out.println("Total execution time to sort "+number_of_elements+" integers using quicksort in "+ elapsedTime/1000000 +" millisecond.");
        for(int i =0;i<a.length;i++){
            a[i] = rand.nextInt(number_of_elements);
        }
        startTime = System.nanoTime();
        sort.insertionSort(a);
        elapsedTime = System.nanoTime()-startTime;
        System.out.println("Total execution time to sort "+number_of_elements+" integers using insertion sort in "+ elapsedTime/1000000+" millisecond.");
    }
    public void insertionSort(int[] a){
        for(int i=1; i<a.length;i++){
            int key = a[i];
            int j = i-1;
            while(j>= 0&&key<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }


    public void quickSort(int[] a){
        quickSort(a,0,a.length-1);
        
    }
    private void quickSort(int[] a, int low, int high){
        if(low<high+1){
            int p = partition(a,low,high);
            quickSort(a,low,p-1);
            quickSort(a,p+1,high);
        }
    }
    private void swap(int[] a, int in1,int in2){
        int temp =a[in1];
        a[in1] = a[in2];
        a[in2] = temp;
    }
    private int partition(int[] a,int low,int high){
        swap(a,low,getP(low,high));
        int border = low+1;
        for(int i = border;i<=high;i++){
            if(a[i]<a[low]){
                swap(a,i,border++);
            }
            
        }
        swap(a,low,border-1);
        return border -1;
    }
    private int getP(int low,int high){
        Random rand = new Random();
        return rand.nextInt(high-low+1)+low;
    }
}
