import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMyArrays {
    static int[] emptyArr;
    static int[] arrayNotHaveFour;
    static int[] oneFourArray;
    static int[] manyFoursArray;

    @BeforeAll
    public static void init() {
        emptyArr = new int[0];
        arrayNotHaveFour = new int[]{1, 3, 7, 2, 6, 1, 6, 7, 8};
        oneFourArray = new int[]{1, 3, 4, 2, 6, 1, 6, 7, 8};
        manyFoursArray = new int[]{1, 3, 4, 2, 4, 1, 4, 7, 8};
    }


    @Test
    public void test_array_is_empty() {
        Assertions.assertThrows(RuntimeException.class, () -> MyArrays.cutOnLastFour(emptyArr));
    }

    @Test
    public void test_array_is_not_have_four() {
        Assertions.assertThrows(RuntimeException.class, () -> MyArrays.cutOnLastFour(arrayNotHaveFour));
    }

    @Test
    public void test_array_have_one_four() {
        Assertions.assertArrayEquals(new int[]{2, 6, 1, 6, 7, 8}, MyArrays.cutOnLastFour(oneFourArray));
    }

    @Test
    public void test_array_have_many_fours() {
        Assertions.assertArrayEquals(new int[]{7, 8}, MyArrays.cutOnLastFour(manyFoursArray));
    }

    @AfterAll
    public static void testEnd() {
        emptyArr = null;
        arrayNotHaveFour = null;
        oneFourArray = null;
        manyFoursArray = null;
    }

    @ParameterizedTest
    @MethodSource("dataForTest")
    public void test_one_four_array(int[] arr, boolean result) {
        Assertions.assertEquals(result, MyArrays.checkArray(arr));
    }

    public static Stream<Arguments> dataForTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{4, 1, 4, 1, 4, 6, 1, 4, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 1, 1, 1, 1}, true));
        return out.stream();
    }
}
