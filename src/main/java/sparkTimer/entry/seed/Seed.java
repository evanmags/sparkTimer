package sparkTimer.entry.seed;

public interface Seed<T> {
    public T getValue();
    public boolean equals(Seed<T> other);
    public int compareTo(Seed<T> other);
}
