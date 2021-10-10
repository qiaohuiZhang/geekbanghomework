package week3.homework.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class ResponseFilterImpl implements ResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("content-msg", "this msg was added from response filter。");
    }
}
