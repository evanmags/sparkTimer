package sparkTimer.entry;

import spark.Route;

public class EntryApi {
    public static Route createEntry = (req, resp) -> {
        return "Created Entry";
    };

    public static Route updateEntry = (req, resp) -> {
        return "Updated Entry";
    };

    public static Route deleteEntry = (req, resp) -> {
        return "Deleted Entry";
    };
}
