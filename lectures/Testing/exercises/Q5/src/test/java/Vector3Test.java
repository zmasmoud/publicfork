import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

final class Vector3Test {

    @Test
    public void sampleTest() {
        assertThat(1, is(1));
    }

    @Test
    public void checkThatAVectorIsTheNullVectorIsCorrect(){
        Vector3 v = new Vector3(new ArrayList<>());
        Assertions.assertTrue(v.checkNull());
    }

    @Test
    public void dotProductIsCorrect(){
        Vector3 v = new Vector3(new ArrayList<>(){1, 2, 3});
        assertThat(v.dotProduct(v) = is(14));
    }

    @Test
    public void crossProductIsCorrect(){
        Vector3 v = new Vector3(new ArrayList<>());
        v.list.add(1);
        v.list.add(2);
        v.list.add(3);
        assertThat(v.crossProduct(v),
                is(0));
    }
}
