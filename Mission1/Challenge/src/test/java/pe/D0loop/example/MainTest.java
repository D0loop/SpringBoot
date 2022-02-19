package pe.D0loop.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author D0Loop
 * @since 2022-02-02 [2022.2월.02]
 */

class MainTest {

    @Test
    public void ArrayList_테스트() {

        Collection<String> arraylist = new ArrayList();

        arraylist.add("Item 1");
        arraylist.add("Item 2");
        arraylist.add("Item 3");
        arraylist.add("Item 4");

        assertThat(arraylist.size()).isEqualTo(4);

    }

    @Test
    public void test() {
        Collection linkedList = new LinkedList();
        Collection vector = new Vector();
        Collection HashSet = new HashSet();
    }

}