package com.hunau.springboot.nettyserver;

import com.hunau.springboot.domain.Humiture;
import com.hunau.springboot.service.IHumitureService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * @author cx
 * @Time 2020/6/29 22:23
 * @Description 服务端业务处理
 */
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**获取实例化对象*/
    @Autowired
    protected IHumitureService humitureService;

    private static NettyServerHandler serverHandler;

    /**配合@Component注解获取service层的bean*/
    @PostConstruct
    public void init(){
        serverHandler = this;
        serverHandler.humitureService = this.humitureService;
    }

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端发起连接！！！！");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**获取客户端的IP*/
        InetSocketAddress insocket = (InetSocketAddress)ctx.channel().remoteAddress();
        String ip = insocket.getAddress().getHostAddress();
        /**将温湿度数据处理*/
        String tem = msg.toString();
        String[] arr = tem.split(",");
        Humiture  humiture = new Humiture();
        humiture.setTemp(arr[0]);
        humiture.setHumidity(arr[1]);
        humiture.setIp(ip);
        /**调用业务层方法将数据写入数据库*/
        serverHandler.humitureService.insertData(humiture);
        System.out.println("服务器接收到客户端的温度，湿度---"+msg.toString());
        System.out.println("温湿度写入数据库成功！！！！");
        ctx.write("receive OK!");
        ctx.flush();
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

