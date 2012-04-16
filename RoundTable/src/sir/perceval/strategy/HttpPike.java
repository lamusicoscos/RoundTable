package sir.perceval.strategy;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

/**
 * 信息职能系统 Perceval 系统的 HTTP 信息来源通道。
 * @author Aiden S. Zouliu
 *
 */
public class HttpPike implements Pike {
	
	private static final int DEFAULT_PORT = 9090;
	
	private final Server server;
	
	private HttpPike(final int port) {
		checkValidPort(port);
		
		server = new Server();
		
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(port);
		connector.setMaxIdleTime(30000);
		
		server.setConnectors(new Connector[] { connector });
		server.setHandler(new TestHandler());
	}
	
	public static final HttpPike of(final int port) {
		return new HttpPike(port);
	}
	
	public static final HttpPike of() {
		return new HttpPike(DEFAULT_PORT);
	}
	
	private void checkValidPort(int port) {
		if (port < 1024 || port > 65535) {
			throw new IllegalArgumentException("Port=" + port + ", Valid port must be within [1024, 65535]");
		}
	}
	
	@Override
	public void function() throws Exception {
		final Thread t = new Thread() {
			@Override
			public void run() {
				try {
					server.start();
					server.join();
				} catch (final Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		t.start();
		t.join();
	}
	
	@Override
	public void dismantle() throws Exception {
		server.stop();
	}
	
}
