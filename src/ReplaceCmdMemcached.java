import java.net.InetSocketAddress;
import java.util.concurrent.Future;
import net.spy.memcached.MemcachedClient;

public class ReplaceCmdMemcached {
    public static final String MY_KEY = "mykey";
    public static final String MY_VALUE1 = "myvalue1";
    public static final String MY_VALUE2 = "myvalue2";
    public static final String MY_VALUE3 = "myvalue3";

    public static void main(String[] args) {
        try {
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE1);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 4. Replace cache at Memcached
            fo = mcc.replace(MY_KEY, 900, MY_VALUE2);

            System.out.println("replace status : " + fo.get());

            // 5. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 6. Replace cache at Memcached
            fo = mcc.replace(MY_KEY, 900, MY_VALUE3);

            System.out.println("replace status : " + fo.get());

            // 7. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 8. Disconnect from Memcached
            mcc.shutdown();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
