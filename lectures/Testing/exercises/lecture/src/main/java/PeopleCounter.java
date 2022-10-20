public class PeopleCounter {
    // EXERCISE: Design a "people counter" with TDD.
    // The counter:
    // - starts at 0
    // - has a configurable max
    // - can increment (+1)
    // - can reset (=0)
    int counter, max;

    public PeopleCounter(int counter, int max) {
        if(counter != 0) throw new IllegalArgumentException("counter should start at 0");
        this.counter = counter;
        this.max = max;
    }

    public void increment(){
        counter +=1;
    }

    public void reset(){
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public int getMax() {
        return max;
    }
}
