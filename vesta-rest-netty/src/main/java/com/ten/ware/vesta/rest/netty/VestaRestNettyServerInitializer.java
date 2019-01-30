package com.ten.ware.vesta.rest.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class VestaRestNettyServerInitializer extends
        ChannelInitializer<SocketChannel> {
    /**
     * handler
     */
    private com.ten.ware.vesta.rest.netty.VestaRestNettyServerHandler handler = new com.ten.ware.vesta.rest.netty.VestaRestNettyServerHandler();

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();

        p.addLast("codec", new HttpServerCodec());
        p.addLast("handler", handler);
    }
}
