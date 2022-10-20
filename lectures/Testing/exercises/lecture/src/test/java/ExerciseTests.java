import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class ExerciseTests {
    @Test
    void onePlusOneIsTwo() {
        assertThat(1 + 1, is(2));
    }

    // TODO: tests!
    // Remember "assertThat" with matchers (see the documentation!)
    // and "assertThrows" to assert an exception is thrown
    @Test void splitWithMiddleSeparator() {
        assertThat(
                Functions.splitString("a b", ' '),
                contains("a", "b")
        );
    }

    @Test void testFibonacci1Is1() {
        assertThat(Functions.fibonacci(1), is(1));
    }
    @Test void testFibonacci10Is55() {
        assertThat(Functions.fibonacci(10), is(55));
    }
    @Test void testFibonacciMinusOneThrows() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Functions.fibonacci(-1)
        );
    }

    @Test void testShuffleSmallArrayShuffles() {
        // Arrange
        var vals = new String[]{"a", "b", "c"};
        // Act
        Functions.shuffle(vals);
        // Assert
        assertThat(vals,
                arrayContainingInAnyOrder("a", "b", "c"));
    }

    @Test void counterShouldNotStartBelowZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PeopleCounter(-1, 10));
    }

    @Test void counterShouldNotStartAboveZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PeopleCounter(1, 10));
    }

    @Test void peopleCounterCanBeReset(){
        var pc = new PeopleCounter(0, 10);
        pc.increment();
        pc.reset();
        assertThat(pc.getCounter(), is(0));
    }

    @Test void peopleCounterCanBeIncremented(){
        var pc = new PeopleCounter(0, 10);
        pc.increment();
        assertThat(pc.getCounter(), is(1));
    }

    @Test void peopleCounterHasAConfigurableMax(){
        var pc = new PeopleCounter(0, 10);
        assertThat(pc.getMax(), is(10));
    }
}
