package com.hero.core.boot.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        //自定义的逻辑Handler

        // 以("\n")为结尾分割的 解码器
//        18         pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//        19
//        20         // 字符串解码 和 编码
//        21         pipeline.addLast("decoder", new StringDecoder());
//        22         pipeline.addLast("encoder", new StringEncoder());
//        23
//        24         // 自己的逻辑Handler
//        25         pipeline.addLast("handler", new HelloServerHandler());

    }
}
