package com.hunau.springboot;

import com.hunau.springboot.nettyserver.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
@MapperScan("com.hunau.springboot.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        /**启动服务端*/
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1",8087));
    }
}
