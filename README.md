# Example for Memcached

## Purpose

-----

> This project is to understand how to use Memcached Client by spymemcached. <br>
> And I try to write down to make easy understand. <br>
> If you have any problem, please contact me. <br>

## 

## Environment

-----

- Java 1.8
- memcached 1.4.5
- spymemcached 2.8.4

This is the basic step for example.

```java

    // 1. Connect to Memcached
    
    MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
    
    System.out.println("Connection to server successful.");

    // ...
    
    // 9. Disconnect from Memcached

    mcc.shutdown();

```

## ConnectionMemcached.java

-----

This is for connection between Server and Client.

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Disconnect from Memcached
            mcc.shutdown();
```

## SetNGetCmdMemcached.java

-----

This is basic operation of Cache service.

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 4. Disconnect from Memcached
            mcc.shutdown();
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue
```


## AddCmdMemcached.java

-----

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE1);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 4. Add cache at Memcached
            fo = mcc.add(MY_KEY, 900, MY_VALUE2);

            System.out.println("add status : " + fo.get());

            // 5. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 6. Add cache at Memcached
            fo = mcc.add(MY_KEY, 900, MY_VALUE3);

            System.out.println("add status : " + fo.get());

            // 7. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 8. Disconnect from Memcached
            mcc.shutdown();
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue1
add status : false
mykey's value in cache : myvalue1
add status : false
mykey's value in cache : myvalue1
```

## DeleteCmdMemCached.java

-----

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 4. Delete cache from Memcached
            fo = mcc.delete(MY_KEY);

            System.out.println("delete status : " + fo.get());

            // 5. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 6. Disconnect from Memcached
            mcc.shutdown();
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue
delete status : true
mykey's value in cache : null
```

## AppendCmdMemcached.java

-----

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE1);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 4. Append cache at Memcached
            fo = mcc.append(0, MY_KEY, MY_VALUE2);

            System.out.println("append status : " + fo.get());

            // 5. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 6. Append cache at Memcached
            fo = mcc.append(0, MY_KEY, MY_VALUE3);

            System.out.println("append status : " + fo.get());

            // 7. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 8. Disconnect from Memcached
            mcc.shutdown();
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue1
append status : true
mykey's value in cache : myvalue1myvalue2
append status : true
mykey's value in cache : myvalue1myvalue2myvalue3
```

## PrependCmdMemcached.java

-----

```java
            // 1. Connect to Memcached
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 2. Store cache at Memcached
            Future fo = mcc.set(MY_KEY, 900, MY_VALUE1);

            System.out.println("set status : " + fo.get());

            // 3. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));


            // 4. Prepend cache at Memcached
            fo = mcc.prepend(0, MY_KEY, MY_VALUE2);

            System.out.println("prepend status : " + fo.get());

            // 5. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 6. Prepend cache at Memcached
            fo = mcc.prepend(0, MY_KEY, MY_VALUE3);

            System.out.println("prepend status : " + fo.get());

            // 7. Retrieve cache at Memcached
            System.out.println(MY_KEY + "'s value in cache : " + mcc.get(MY_KEY));

            // 8. Disconnect from Memcached
            mcc.shutdown();
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue1
prepend status : true
mykey's value in cache : myvalue2myvalue1
prepend status : true
mykey's value in cache : myvalue3myvalue2myvalue1
```

## ReplaceCmdMemcached.java

-----

```java
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
```

This is the result you expected.
```
Connection to server successful.
set status : true
mykey's value in cache : myvalue1
replace status : true
mykey's value in cache : myvalue2
replace status : true
mykey's value in cache : myvalue3

```

## IncrNDecrCmdMemcached.java

-----

```java
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
```

This is the result you expected.
```
Connection to server successful.
set status : true
mynum's value in cache : 100
mynum's value in cache after Incr : 101
mynum's value in cache after Decr : 97
```
## Writer

-----
> email : u4rang@gmail.com <br>
> Github : https://github.com/u4rang