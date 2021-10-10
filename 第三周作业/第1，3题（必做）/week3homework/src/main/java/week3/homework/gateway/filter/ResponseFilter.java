package week3.homework.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface ResponseFilter {

    void filter(FullHttpResponse response);

}
