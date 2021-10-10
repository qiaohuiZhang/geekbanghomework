package week3.homework.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class RequestFilterImpl implements RequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        System.out.println("进了请求filter");
        String modURI = fullRequest.uri().replace("test", "123");
        fullRequest.setUri(modURI);
        System.out.println(fullRequest.uri());
    }
}
