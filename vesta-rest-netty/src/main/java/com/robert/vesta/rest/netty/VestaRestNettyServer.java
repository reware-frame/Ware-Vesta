package com.robert.vesta.rest.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Properties;
import java.util.stream.Stream;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VestaRestNettyServer {
    private static final Log log = LogFactory
            .getLog(VestaRestNettyServer.class);

    private final int port;

    public VestaRestNettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new VestaRestNettyServerInitializer());

            Channel ch = b.bind(new InetSocketAddress("0.0.0.0",port)).sync().channel();

            if (log.isDebugEnabled())
                log.debug("VestaRestNettyServer is started.");

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * 加载配置文件
     * @return
     * @throws IOException
     */
    public static Properties loadConf() throws IOException {
        InputStream resourceAsStream = VestaRestNettyServer.class.getClassLoader()
                .getResourceAsStream("spring/vesta-rest-netty.properties");
//        new FileInputStream(new File(System.getProperty("user.dir")+File.separator+""))
        System.out.println(System.getProperty("user.dir"));
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        return properties;
    }

    public static void main(String[] args) throws Exception {
        Properties properties=loadConf();
        String portStr=properties.getProperty("vesta.port");
        int port=8080;
        if(!StringUtils.isBlank(portStr)&&StringUtils.isNumeric(portStr)){
            port = Integer.valueOf(portStr);
        }
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        new VestaRestNettyServer(port).run();
    }
}
