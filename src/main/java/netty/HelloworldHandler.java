package netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: 徐森
 * @CreateDate: 2020/1/19
 * @Description:
 */
public class HelloworldHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead...");
        System.out.println(ctx.channel().remoteAddress()+"->Server:"+msg.toString());
        ctx.write("server write:"+msg);
        ctx.flush();
    }
}
