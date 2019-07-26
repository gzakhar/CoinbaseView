package util;

public class Operations<T> {


    public T[] reverse(T[] array) {

        for (int n = 0; n < (array.length / 2); n++) {

            T temp = array[n];
            array[n] = array[array.length - n - 1];
            array[array.length - n - 1] = temp;
        }
        return array;
    }
}
