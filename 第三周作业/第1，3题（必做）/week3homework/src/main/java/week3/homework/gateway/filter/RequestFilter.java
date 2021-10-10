package week3.homework.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface RequestFilter {
    
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
    
}
