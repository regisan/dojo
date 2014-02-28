import static org.junit.Assert.assertArrayEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class FilaCircularTest {

    @Test
    public void testAppend() {
        FilaCircular buffer = new FilaCircular(1);

        String[] result = new String[] { "A" };

        buffer.append("A");

        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testAppend2() {
        FilaCircular buffer = new FilaCircular(2);
        String[] result = new String[] { "A", "B" };
        buffer.append("A");
        buffer.append("B");
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testAppend3() {
        FilaCircular buffer = new FilaCircular(2);
        String[] result = new String[] { "B", "C" };
        buffer.append("A");
        buffer.append("B");
        buffer.append("C");
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testAppend4() {
        FilaCircular buffer = new FilaCircular(2);
        String[] result = new String[] { "C", "D" };
        buffer.append("A");
        buffer.append("B");
        buffer.append("C");
        buffer.append("D");
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testAppend10() {
        FilaCircular buffer = new FilaCircular(10);
        String[] result = new String[10];
        result[0] = "A";
        result[1] = "B";

        buffer.append("A");
        buffer.append("B");
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testRemove() {
        FilaCircular buffer = new FilaCircular(10);
        String[] result = new String[10];

        buffer.append("0");
        buffer.remove(1);
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testRemove2() {
        FilaCircular buffer = new FilaCircular(10);
        String[] result = new String[10];
        result[0] = "A";

        buffer.append("0");
        buffer.append("A");
        buffer.remove(1);
        assertArrayEquals(result, buffer.list());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveBufferVazio() {
        FilaCircular buffer = new FilaCircular(3);
        buffer.remove(1);
    }

    @Test
    public void testRemove3() {
        FilaCircular buffer = new FilaCircular(3);
        String[] result = new String[3];
        result[0] = "B";
        result[1] = "C";

        buffer.append("0");
        buffer.append("A");
        buffer.append("B");
        buffer.append("C");
        buffer.remove(1);
        assertArrayEquals(result, buffer.list());
    }

    @Test
    public void testRemoveAll() {
        FilaCircular buffer = new FilaCircular(3);
        String[] result = new String[3];

        buffer.append("0");
        buffer.append("A");
        buffer.append("B");
        buffer.append("C");
        buffer.remove(3);
        assertArrayEquals(result, buffer.list());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveMoreThanBufferLength() {
        FilaCircular buffer = new FilaCircular(3);
        buffer.append("0");
        buffer.append("A");
        buffer.append("B");
        buffer.append("C");
        buffer.remove(10);
    }

}
