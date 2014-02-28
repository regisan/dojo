

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    
    private Solution subset;

    @Before
    public void setUp() {
        subset = new Solution();
    }
    
    @Test
    public void testSubset() {
        long[] result = new long[] {3, 2};
        assertArrayEquals(result, subset.calcular(new long[] {2, 3}));
    }
    
    @Test
    public void testSubsetSite() {
        long[] result = new long[] {12, 30, 30, 20};
        assertArrayEquals(result, subset.calcular(new long[] {5, 2, 2, 3}));
    }
    
    @Test
    public void testSubsetZero() {
        long[] result = new long[] {0, 18, 0, 0};
        assertArrayEquals(result, subset.calcular(new long[] {2, 0, 3, 3}));
    }
    
    @Test
    public void testSubsetAllZero() {
        long[] result = new long[] {0, 0, 0, 0};
        assertArrayEquals(result, subset.calcular(new long[] {0, 0, 0, 0}));
    }
    
    @Test
    public void testSubsetAllOne() {
        long[] result = new long[] {1, 1, 1, 1};
        assertArrayEquals(result, subset.calcular(new long[] {1, 1, 1, 1}));
    }
    
    @Test
    public void testSubsetOneElementNegative() {
        long[] result = new long[] {-1, -1, 1, -1};
        assertArrayEquals(result, subset.calcular(new long[] {1, 1, -1, 1}));
    }
    
    @Test
    public void testSubsetTwoElementsNegativeOddArray() {
        long[] result = new long[] {1, 1, -1, -1};
        assertArrayEquals(result, subset.calcular(new long[] {1, 1, -1, -1}));
    }
    
    @Test
    public void testSubsetAllNegativesEvenArray() {
        long[] result = new long[] {1, 1, 1};
        assertArrayEquals(result, subset.calcular(new long[] {-1, -1, -1}));
    }
    
    @Test
    public void testSubsetAllNegativesButNoNumberOne() {
        long[] result = new long[] {-12, -30, -30, -20};
        assertArrayEquals(result, subset.calcular(new long[] {-5, -2, -2, -3}));
    }
    
    @Test
    public void testSubsetAllNegativesEvenArrayButNoNumberOne() {
        long[] result = new long[] {4, 10, 10};
        assertArrayEquals(result, subset.calcular(new long[] {-5, -2, -2}));
    }
    
    @Test
    public void testSubsetNegativesAndOnePositive() {
        long[] result = new long[] {12, -30, 30, 20};
        assertArrayEquals(result, subset.calcular(new long[] {-5, 2, -2, -3}));
    }
}
