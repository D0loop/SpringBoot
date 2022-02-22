package pe.D0loop.example;

import java.util.*;

/**
 * @author D0Loop
 * @since 2022-02-06 [2022.2월.06]
 */

public class CommonCollection {

    private static final String PRINT_FORMAT = "%-3s  %-10s";
    private static final String INDEX_TITLE = "idx";
    private static final String ITEM_TITLE = "item";
    private static final String NO_ELEMENTS = "No Elements";

    private Iterator iterator;
    private List<String> resultList;

    public static <E> CommonCollection of(Collection<E> collection) {
        return new CommonCollection(collection);
    }

    private <E> CommonCollection(Collection<E> collection) {
        this.iterator = collection.iterator();
        this.resultList = new ArrayList<>();
        setPrintFormat();
    }

    private void setPrintFormat() {
        if(!iterator.hasNext()) return;

        setPrintTitle();
        setPrintItem();
    }

    private void setPrintTitle() {
        resultList.add(setIndexAndTitleWithFormat(INDEX_TITLE, ITEM_TITLE));
    }

    private String setIndexAndTitleWithFormat(String index, String item) {
        return String.format(PRINT_FORMAT, index, item);
    }

    private void setPrintItem() {
        int index = 0;
        while (iterator.hasNext()) {
            String indexString = String.valueOf(index);
            String itemString = String.valueOf(iterator.next());
            resultList.add(setIndexAndTitleWithFormat(indexString, itemString));
            index++;
        }
    }

    public List<String> toItemListWithFormat() {
        return Collections.unmodifiableList(resultList);
    }

    public void printItemsWithFormat() {
        if(resultList.size() <= 0) {
            System.out.println(NO_ELEMENTS);
            return;
        }
        resultList.forEach(System.out::println);
    }


}
