package sparkTimer.util;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;

public abstract class CrudApi<T> {
        protected static Gson gson = new Gson();
        protected CrudDao<T> dao;
        protected Type entityType;

        public CrudApi(EntityManagerFactory emf, Type entityType) {
            this.entityType = entityType;
            try {
                Class<CrudDao<T>> cls = (Class<CrudDao<T>>) Class.forName(
                        String.format("%sDao", entityType.getTypeName())
                );
                dao = cls.getDeclaredConstructor(EntityManagerFactory.class, Type.class)
                        .newInstance(emf, entityType);
            } catch (ClassNotFoundException |
                    NoSuchMethodException |
                    InvocationTargetException |
                    InstantiationException |
                    IllegalAccessException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }


        public Route getAll = (Request request, Response response) -> {
            List<T> entityList = dao.get();
            return gson.toJson(entityList);
        };

        public Route create = (Request request, Response response) -> {
            String body = request.body();
            if (body.equals("")) {
                response.status(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }
            T entity = dao.create(gson.fromJson(request.body(), entityType));
            return gson.toJson(entity);
        };

        public Route getOne = (Request request, Response response) -> {
            int id = Integer.parseInt(request.params(":id"));
            Object entity = dao.get(id);
            return gson.toJson(entity);
        };

        public Route update = (Request request, Response response) -> {
            int id = Integer.parseInt(request.params(":id"));
            String body = request.body();
            if (body.equals("")) {
                response.status(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }
            CrudEntity mergeEntity = gson.fromJson(request.body(), entityType);
            mergeEntity.setId(id);
            T entity = dao.update((T) mergeEntity);
            return gson.toJson(entity);
        };

        public Route delete = (Request request, Response response) -> {
            int deleteId = Integer.parseInt(request.params(":id"));
            T entity = dao.get(deleteId);
            dao.delete(entity);
            response.status(HttpServletResponse.SC_NO_CONTENT);
            return "";
        };
}
