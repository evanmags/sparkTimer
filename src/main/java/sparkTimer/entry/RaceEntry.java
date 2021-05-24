package sparkTimer.entry;

import sparkTimer.athlete.Athlete;

import java.time.Duration;

public class RaceEntry extends Entry{
    Duration seed;

    public RaceEntry(Athlete a, String seedTime) {
        athlete = a;
        parseDurationStamp(normalizeSeed(seedTime));
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

    private void parseDurationStamp(String seedTime) {
        String[] values = seedTime.split("\\.");
        seed = Duration.ofMillis(Integer.parseInt(values[1]));

        values = values[0].split(":");
        seed = seed.plusHours(Integer.parseInt(values[0]));
        seed = seed.plusHours(Integer.parseInt(values[1]));
        seed = seed.plusHours(Integer.parseInt(values[2]));
    }
}
