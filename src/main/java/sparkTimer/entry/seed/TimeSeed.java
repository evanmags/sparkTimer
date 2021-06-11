package sparkTimer.entry.seed;

import lombok.Data;

import java.time.Duration;

@Data
public class TimeSeed implements Seed<Duration> {
    Duration value;

    public TimeSeed(Duration value) {
        this.value = value;
    }

    @Override
    public boolean equals(Seed<Duration> other){
        return value.equals(other.getValue());
    }

    public int compareTo(Seed<Duration> other){
        return value.compareTo(other.getValue());
    }
}
