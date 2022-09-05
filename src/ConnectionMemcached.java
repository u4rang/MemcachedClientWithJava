import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;

public class ConnectionMemcached {

    public static void main(String[] args) {
        try {
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Disconnect from Memcached
            mcc.shutdown();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
