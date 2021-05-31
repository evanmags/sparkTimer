package sparkTimer;

import sparkTimer.meet.MeetApi;
import sparkTimer.team.TeamApi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static spark.Spark.*;

public class Application {

    public static MeetApi meetApi;
    public static TeamApi teamApi;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sparkTimer.jpa");

        meetApi = new MeetApi(entityManagerFactory);
        teamApi = new TeamApi(entityManagerFactory);


        staticFiles.location("/public");


        path("/api", () -> {
            before("*", (request, response) -> {
                if (request.pathInfo().endsWith("/")) {
                    response.redirect(request.pathInfo().replaceAll("/$", ""));
                }
            });

            path("/teams", () -> {
                get("", teamApi.getAll);
                post("", teamApi.create);

                path("/:id", () -> {
                    get("", teamApi.getOne);
                    put("", teamApi.update);
                    delete("", teamApi.delete);

                });
            });

            path("/athletes", () -> {});

            path("/events", () -> {} );

            path("/meets", () -> {
                get("", meetApi.getAll);
                post("", meetApi.create);

                path("/:id", () -> {
                    get("", meetApi.getOne);
                    put("", meetApi.update);
                    delete("", meetApi.delete);

                });
            });

            after((request, response) -> {
                response.header("Content-Type", "application/json");
            });
        });
    }
}
