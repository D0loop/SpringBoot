package pe.D0loop.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

class UtilTest {

    private static final int COLLECTION_SIZE = 10;

    private <E> void setCollection(Collection<E> collection) {
        IntStream.rangeClosed(0, COLLECTION_SIZE)
                .boxed()
                .forEach(i -> collection.add((E) i));
    }


    private <E> List<String> setActualResult(Collection<E> collection) {
        List<String> list = new ArrayList<>();

        list.add(String.format("%-3s  %-10s", "idx", "item"));
        IntStream.rangeClosed(0, COLLECTION_SIZE)
                .boxed()
                .forEach(i -> list.add(String.format("%-3s  %-10s", i, i)));

        return list;
    }


    @Test
    public void string_arraylist_formatting_Test() {

        List<String> actual = setActualResult(new ArrayList<String>());

        List<String> arrayList = new ArrayList();
        setCollection(arrayList);
        List<String> expected = Util.toStringListWithFormat(arrayList);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(arrayList);
    }

    @Test
    public void empty_arraylist_formatting_Test() {

        List<String> actual = new ArrayList<>();

        List<String> arrayList = new ArrayList<>();
        List<String> expected = Util.toStringListWithFormat(arrayList);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(arrayList);
    }

    @Test
    public void integer_arraylist_formatting_Test() {

        List<String> actual = setActualResult(new ArrayList<Integer>());

        List<Integer> arrayList = new ArrayList();
        setCollection(arrayList);
        List<String> expected = Util.toStringListWithFormat(arrayList);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(arrayList);

    }

    @Test
    public void long_arraylist_formatting_Test() {

        List<String> actual = setActualResult(new ArrayList<Long>());

        List<Integer> arrayList = new ArrayList();
        setCollection(arrayList);
        List<String> expected = Util.toStringListWithFormat(arrayList);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(arrayList);

    }

    @Test
    public void string_vector_formatting_Test() {

        List<String> actual = setActualResult(new Vector<String>());

        Vector<String> vector = new Vector<>();
        setCollection(vector);
        List<String> expected = Util.toStringListWithFormat(vector);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(vector);
    }

    @Test
    public void string_linkedList_formatting_Test() {

        List<String> actual = setActualResult(new LinkedList<>());

        List<String> vector = new LinkedList<>();
        setCollection(vector);
        List<String> expected = Util.toStringListWithFormat(vector);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(vector);

    }

    @Test
    public void string_hashset_formatting_Test() {

        List<String> actual = setActualResult(new HashSet<>());

        Set<String> vector = new HashSet<>();
        setCollection(vector);
        List<String> expected = Util.toStringListWithFormat(vector);

        assertThat(actual).isEqualTo(expected);
        Util.printCollectionWithFormat(vector);
    }
}