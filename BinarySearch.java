

public class BinarySearch{
    int binarySearch(int[]arr, int key){

        int left = 0;
        int mid, right = arr.length - 1;
        
        while(left<=right){
            mid = (right+left)/2;
            if(key<arr[mid]){
                right = mid-1;

            }
            else if(key>arr[mid]){
                left = mid+1;

            }
            else 
            return mid;
        }
        return -1;

        

    }
    public static void main(){
        BinarySearch ls = new BinarySearch();
        int arr[] = {10,19,25,69,80,90,900,1001};
        System.out.println(ls.binarySearch(arr,25));
        System.out.println(ls.binarySearch(arr,900));
        System.out.println(ls.binarySearch(arr,10));
        System.out.println(ls.binarySearch(arr,11));
        


    }
}

/*
2
6
0
-1
 */
