
class MyCollection {
    private int[] arr;
    private int size = 0;

    MyCollection(){
        arr = new int[0];
    }

    MyCollection(int size){
        arr = new int[size];
        this.size = size;
    }

    private boolean checkBounds(int index){
        return (index < arr.length && index >= 0);
    }

    public int getSize() {
        return size;
    }

    public void add(int value){
        ++size;
        int[] buffer = new int[size];
        System.arraycopy(arr,0,buffer,0,size-1);
        buffer[buffer.length-1] = value;
        arr = buffer;
    }

    // return index of element
    public int searchByValue(int value){
        for (int i = 0; i < arr.length; ++i){
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    //return value of element
    public int searchByIndex(int index){
        if (index < arr.length && index > 0)
            return arr[index];
        throw new ArrayIndexOutOfBoundsException();
    }


    public void deleteByIndex(int index){
        int[] buffer = new int[--size];
        if (!checkBounds(index))
            throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < index; ++i)
            buffer[i] = arr[i];
        for (int i = index; i < buffer.length; ++i)
            buffer[i] = arr[i+1];
        arr = buffer;
    }

    public void deleteByValue(int value){
        int index = searchByValue(value);
        deleteByIndex(index);
    }

    public int max(){
        if (arr.length == 0)
            throw new NullPointerException();
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i){
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int min(){
        if (arr.length == 0)
            throw new NullPointerException();
        int min = arr[0];
        for (int i = 1; i < arr.length; ++i){
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public double allAverage(){
        if (arr.length == 0)
            throw new NullPointerException();
        int sum = 0;
        for (int item :
                arr) {
            sum+=item;
        }
        return (double)sum/arr.length;
    }
}

public class Test {
    public static void main(String[] args) {
        MyCollection arr = new MyCollection();
        arr.add(3);
        arr.add(6);
        arr.add(4);
        arr.add(8);
        arr.add(9);
        // 3 6 4 8 9
        System.out.println(arr.max()); // 9
        System.out.println(arr.min()); // 3
        System.out.println(arr.allAverage()); // 6.0
        System.out.println(arr.searchByIndex(2)); // 4
        arr.deleteByIndex(2); // ok
        System.out.println(arr.searchByIndex(2)); // 8
        System.out.println(arr.searchByValue(3)); // 0
    }
}