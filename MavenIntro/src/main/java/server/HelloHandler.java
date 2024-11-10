package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String res = "I am inside in the Hello handler with the thread name "+ Thread.currentThread().getName();
        exchange.sendResponseHeaders(200,res.length());
        OutputStream o = exchange.getResponseBody();
        o.write(res.getBytes());
        o.flush();
        o.close();
    }
}
