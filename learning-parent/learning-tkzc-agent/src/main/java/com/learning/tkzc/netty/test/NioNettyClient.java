package com.learning.tkzc.netty.test;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 *
 *
 * @author tangjx
 * @date 2020/8/12 11:39
 */
public class NioNettyClient {

    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    }

}
