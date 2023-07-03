import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import Methods.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Method - 1");
        List<Integer> list1 = List.of(2, 5, 6, 1);
        System.out.println(Methods.average(list1));
        System.out.println();

        System.out.println("Method - 2");
        List<String> list2 = List.of("AaaA", "Bbbb", "cccc", "DDDd");
        System.out.println(Methods.strToUpperNew(list2));
        System.out.println();

        System.out.println("Method - 3");
        List<Integer> list3 = List.of(1, 2, 3, 1, 5, 4, 9, 4);
        System.out.println(Methods.uniqSquares(list3));
        System.out.println();

        System.out.println("Method - 4");
        List<String> list4 = List.of("abcdefg", "cdef", "azwxy", "abcdefg", "cdef", "afffzwxy", "abcdefasdhhg");
        System.out.println(Methods.firstLetterStrSort(list4, 'a'));
        System.out.println();

        System.out.println("Method - 5");
        List<Integer> list5 = List.of(1861, 1865, 888, 78498, 5);
        List<String> emptyList = new ArrayList<>();
        try {
            System.out.println(Methods.lastElement(list5));
            System.out.println(Methods.lastElement(emptyList));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Method - 6");
        int[] arrayFirst = {1, 2, 3, 4, 5};
        System.out.println(Methods.numsEven(arrayFirst));
        arrayFirst = new int[]{1, 3, 5};
        System.out.println(Methods.numsEven(arrayFirst));
        System.out.println();

        System.out.println("Method - 7");
        List<String> list7 = List.of("Abcdefg", "qwerty", "asdfghkj");
        System.out.println(Methods.stringToMap(list7));

    }
}