import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class IncrNDecrCmdMemcached {
    public static final String MY_NUM = "mynum";

    public static void main(String[] args) {
        try {
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_NUM, 900, "100");

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_NUM + "'s value in cache : " + mcc.get(MY_NUM));

            // 4. Incr cache at Memcached
            System.out.println(MY_NUM + "'s value in cache after Incr : " + mcc.incr(MY_NUM, 1));

            // 5. Decr cache at Memcached
            System.out.println(MY_NUM + "'s value in cache after Decr : " + mcc.decr(MY_NUM, 4));

            // 6. Disconnect from Memcached
            mcc.shutdown();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
