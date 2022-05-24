package lt.vu.usecases;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Model
public class AsyncTask implements Serializable {
    private CompletableFuture<String> asyncTask = null;

    public String longTask() {
        asyncTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Task done";
        });

        return  "/index.xhtml?faces-redirect=true";
    }

    public boolean isAsyncTaskRunning() {
        return asyncTask != null && !asyncTask.isDone();
    }

    public String getAsyncTaskStatus() throws ExecutionException, InterruptedException {
        if (asyncTask == null) {
            return null;
        } else if (isAsyncTaskRunning()) {
            return "Task in progress";
        }
        return "Task result: " + asyncTask.get();
    }
}
