import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageHandler implements HttpHandler {

    private int count;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        count = count + 1;
        String response = printOmikuji();
        Headers headers = exchange.getResponseHeaders();

        headers.add("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.getBytes().length);

        try(OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private String printOmikuji() {
        int rnd = new Random().nextInt(3);
        String result = "<img src='https://bit.ly/3l1w58F'/>";
        switch(rnd) {
            case 0:
                result = "<img src='https://bit.ly/3l1w58F'/>";
                break;
            case 1:
                result = "<img src='https://bit.ly/349WrOY'/>";
                break;
            case 2:
                result = "<img src='https://bit.ly/3jh7v31'/>";
                break;
        }
        return result;
    }
}
