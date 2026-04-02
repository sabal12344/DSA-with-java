public class LinearSearch{
    int linearSearch(int[]arr, int key){

        for(int i=0;i<arr.length;i++){
            if(arr[i]==key)
            return i;
        }
        return -1;

    }
    public static void main(){
        LinearSearch ls = new LinearSearch();
        int arr[] = {44,55,77,88,60,80,50,43};
        System.out.println(ls.linearSearch(arr,43));
        System.out.println(ls.linearSearch(arr,77));
        System.out.println(ls.linearSearch(arr,2));


    }
}

/*
7
2
-1
 */
