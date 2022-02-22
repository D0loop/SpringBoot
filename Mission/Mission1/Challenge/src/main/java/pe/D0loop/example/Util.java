package pe.D0loop.example;

import java.util.Collection;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

public class Util {

    private static final String printFormat = "%-3s  %-10s";


    public static <E> List<String> toStringListWithFormat(Collection<E> collection) {
        CommonCollection commonCollection = CommonCollection.of(collection);
        return commonCollection.toItemListWithFormat();
    }

    public static <E> void printCollectionWithFormat(Collection<E> collection) {
        CommonCollection commonCollection = CommonCollection.of(collection);
        commonCollection.printItemsWithFormat();
    }
}
