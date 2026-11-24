package com.bits;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        String env = System.getenv().getOrDefault("APP_ENV", "dev");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            LeaveCalculator calculator = new LeaveCalculator();
            int balance = calculator.getLeaveBalance("EMP001");
            int encashment = calculator.getLeaveEncashment("EMP001");
            byte[] body = ("Leave Service [" + env + "] Balance = " + balance + ", Encashment = " + encashment).getBytes();
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
        System.out.println("Leave Service started, env=" + env);
    }
}

