package sparkTimer.entry;

import lombok.EqualsAndHashCode;
import sparkTimer.athlete.Athlete;
import sparkTimer.entry.seed.TimeSeed;

import java.time.Duration;

@EqualsAndHashCode(callSuper = false)
public class RaceEntry extends Entry<Duration> {
    public RaceEntry(Athlete a, String seedTime) {
        athleteId = a.getId();
        seed = new TimeSeed(
            parseDurationStamp(
                    normalizeSeed(seedTime)
            )
        );
    }

    private String normalizeSeed(String seed) {
           if (!seed.matches("\\d\\d:\\d\\d:\\d\\d.\\d{1,2}")) {
               if (!seed.contains(".")) {
                   seed = seed + ".00";
               }
               if (seed.chars().filter((c) -> c == ':').count() == 2) {
                   seed = "00:" + seed;
               }
           }
           return seed;
    }

    private Duration parseDurationStamp(String seedTime) {
        String[] values = seedTime.split("\\.");
        Duration tmpSeed = Duration.ofMillis(Integer.parseInt(values[1]));

        values = values[0].split(":");
        tmpSeed = tmpSeed.plusHours(Integer.parseInt(values[0]));
        tmpSeed = tmpSeed.plusHours(Integer.parseInt(values[1]));
        tmpSeed = tmpSeed.plusHours(Integer.parseInt(values[2]));

        return tmpSeed;
    }
}
