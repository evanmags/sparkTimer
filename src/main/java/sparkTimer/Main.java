package sparkTimer;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFiles.location("/public");

        path("/api", () -> {
            path("/teams", () -> {
                // return all teams
                get("", (req, res) -> null);
                // create team
                post("", (req, res) -> null);
                // return 1 team
                get("/:id", (req, res) -> null);
                //
                get("/", (req, res) -> null);
            });
        });
    }
}
