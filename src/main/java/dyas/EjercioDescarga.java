package dyas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjercioDescarga {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Crea un pool de 3 hilos

        // Simula la descarga de archivos desde diferentes URLs
        Callable<String> downloadTask1 = () -> downloadFile("http://example.com/file1");
        Callable<String> downloadTask2 = () -> downloadFile("http://example.com/file2");
        Callable<String> downloadTask3 = () -> downloadFile("http://example.com/file3");

        Future<String> future1 = executor.submit(downloadTask1); // Envía la tarea y recibe un Future
        Future<String> future2 = executor.submit(downloadTask2);
        Future<String> future3 = executor.submit(downloadTask3);

        try {
            // Obtiene los resultados de las tareas
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown(); // Finaliza el pool de hilos
    }

    // Método simulado para descargar un archivo
    public static String downloadFile(String url) {
        try {
            Thread.sleep(2000); // Simula el tiempo de descarga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Downloaded: " + url;
    }
}
