import java.util.*;

class Sort
{
    public static void main(String[] args)
    {        
        int[] a = {256,368,291,64,82,1,23,10,17,3,25,29,15,24};
        System.out.println("unsorted: " + Arrays.toString(a));

        int[] sorted = merge(a,(int)Math.ceil(a.length/2));
        
        System.out.println("sorted: " + Arrays.toString(sorted));
    }
    public static int[] merge(int[] arr, int middle)
    {
        int[] arr1 = new int[middle];
        int[] arr2 = new int[arr.length-middle];

        arr1 = fillArr(arr,0,middle);
        arr2 = fillArr(arr,middle,arr.length-middle);

        // System.out.println("arr1: " + Arrays.toString(arr1) + " arr2: " + Arrays.toString(arr2));

        int arr1Mid = (int)Math.ceil(arr1.length/2);
        int arr2Mid = (int)Math.ceil(arr2.length/2);

        if (arr1.length <= 0 || arr2.length <= 0)
        {
            System.out.println("error, exiting to prevent infinate loop");
            System.exit(0);
        }

        if (arr1.length == 1 && arr2.length == 1) return combineArr(arr1, arr2);
        else if (arr1.length != 1 && arr2.length == 1) return combineArr(merge(arr1,arr1Mid),arr2);
        else if (arr1.length == 1 && arr2.length != 1) return combineArr(arr1,merge(arr2,arr2Mid));
        else return combineArr(merge(arr1,arr1Mid), merge(arr2,arr2Mid));
    }

    public static int[] fillArr(int[] arr, int start, int size)// fills an array with values from another array up to a selected index
    {
        int[] a = new int[size];

        for (int i = start; i < size+start; i++)
        {
            a[i-start] = arr[i];
        }

        return a;
    }
    public static int[] combineArr(int[] arr0, int[] arr1)// combines two arrays
    {
        int[] a = new int[arr0.length+arr1.length];

        int arr0Pos = 0;
        int arr1Pos = 0;

        for (int i = 0; i < a.length; i++)
        {
            if (arr0Pos < arr0.length && arr1Pos < arr1.length)
            {
                if (arr0[arr0Pos] <= arr1[arr1Pos]) 
                {
                    a[i] = arr0[arr0Pos];
                    arr0Pos ++;
                }
                else 
                {
                    a[i] = arr1[arr1Pos];
                    arr1Pos ++;
                }
            }
            else
            {
                if (arr0Pos < arr0.length) 
                {
                    a[i] = arr0[arr0Pos];
                    arr0Pos ++;
                }
                else
                {
                    a[i] = arr1[arr1Pos];
                    arr1Pos ++;
                }
            }
        }

        return a;
    }
}