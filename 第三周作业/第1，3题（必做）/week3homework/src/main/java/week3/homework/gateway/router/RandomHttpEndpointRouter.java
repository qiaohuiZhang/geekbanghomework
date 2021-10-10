package week3.homework.gateway.router;

import java.util.List;
import java.util.Random;

public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        return urls.get(new Random().nextInt(urls.size()));
    }
}
