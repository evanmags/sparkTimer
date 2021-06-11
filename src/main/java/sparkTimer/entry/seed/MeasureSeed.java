package sparkTimer.entry.seed;

import lombok.Data;

@Data
public class MeasureSeed implements Seed<Float> {
    Float value;

    public MeasureSeed(float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Seed<Float> other){
        return value == other.getValue();
    }

    public int compareTo(Seed<Float> other){
        return value.compareTo(other.getValue());
    }
}