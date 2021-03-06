import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {

    public static void main(String[] args) {
        try {
            InetSocketAddress address = new InetSocketAddress(8080);
            HttpServer httpServer = HttpServer.create(address, 0);

            SimpleHandler simpleHandler = new SimpleHandler();
            OmikujiHandler omikujiHandler = new OmikujiHandler();
            ImageHandler imageHandler = new ImageHandler();
            DynamicHandler dynamicHandler = new DynamicHandler();

            httpServer.createContext("/hello", simpleHandler);
            httpServer.createContext("/omikuji", omikujiHandler);
            httpServer.createContext("/image", imageHandler);
            httpServer.createContext("/dynamic", dynamicHandler);

            httpServer.start();
            System.out.println("Server is started!");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
