package sparkTimer.entry;

import spark.Route;

public class EntryApi {
    public static Route createEntry = (req, resp) -> "Created Entry";

    public static Route updateEntry = (req, resp) -> "Updated Entry";

    public static Route deleteEntry = (req, resp) -> "Deleted Entry";
}
