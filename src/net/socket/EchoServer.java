package net.socket;

import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.io.IOException;
import java.util.logging.*;

public class EchoServer {
	
	public static int DEFAULT_PORT = 7;
	private final static Logger auditLogger = Logger.getLogger("requests");
	private final static Logger errorLogger = Logger.getLogger("errors");
	public static void main( String[] args ){
		int port;
		try{
			port = Integer.parseInt("299");
		}catch(RuntimeException ex ){
			port = DEFAULT_PORT;
			auditLogger.log(Level.SEVERE, "default port", ex);
		}
		System.out.println("Listening for connection on port " + port );
		
		ServerSocketChannel serverChannel;
		Selector selector = null;
		try{
			serverChannel = ServerSocketChannel.open();
			ServerSocket ss = serverChannel.socket();
			InetSocketAddress address = new InetSocketAddress( port );
			ss.bind(address);
			serverChannel.configureBlocking(false);
			selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT );
		}catch( IOException ex ){
			ex.printStackTrace();
			return;
		}
		
		while( true ){
			try{
				selector.select();
			}catch(IOException ex ){
				ex.printStackTrace();
				break;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			
			while( iterator.hasNext() ){
				SelectionKey key  = iterator.next();
				iterator.remove();
				try{
					if( key.isAcceptable() ){
						ServerSocketChannel server = (ServerSocketChannel)key.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection form " + client);
						client.configureBlocking(false );
						SelectionKey clientKey = client.register(selector, SelectionKey.OP_WRITE|SelectionKey.OP_READ );
						ByteBuffer buffer = ByteBuffer.allocate(100);
						clientKey.attach(buffer);
					}
					if( key.isReadable()){
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer output = (ByteBuffer) key.attachment();
						client.read(output);
					}
					if( key.isWritable()){
						SocketChannel client = (SocketChannel)key.channel();
						ByteBuffer output = (ByteBuffer)key.attachment();
						output.flip();
						client.write(output);
						output.compact();
					}
				}catch(IOException ex ){
					key.cancel();
					try{
						key.channel().close();
					}catch( IOException cex ){}
				}
			}
		}
		
	}
}







