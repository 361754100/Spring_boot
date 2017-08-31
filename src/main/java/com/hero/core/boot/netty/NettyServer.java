package com.hero.core.boot.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Netty 服务端单例
 */
public class NettyServer {

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);
    private static NettyServer instance = null;

    //Netty组件
    private Channel channel = null;
    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workerGroup = null;
    private ServerBootstrap serverBoot = null;

    private NettyServer(){}

    private static class HolderClass{
        private static NettyServer server = new NettyServer();
    }

    public static NettyServer getInstance(){
        if(instance == null) {
            instance = HolderClass.server;
        }
        return instance;
    }

    public synchronized void start() {
        if(bossGroup != null || workerGroup != null) {
            return;
        }
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        serverBoot = new ServerBootstrap();
        serverBoot.group(bossGroup, workerGroup);

    }

}
