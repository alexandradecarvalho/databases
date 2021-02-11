# Redis



## Introduction

**Redis** (**RE**mote **DI**ctionary **S**ervice) was developed in 2009 and is one of the most popular key-value repositories. It can be used as a database, as a data cache, or as a messaging system (message broker). It is an open source, advanced solution for building high performance, scalable web applications.



##### Advantages

- Very fast 
- Supports rich data types 
- Atomic operations
- Multi-utility tool 



##### How to get it?

Download [here](https://redis.io/). 

Run the server:

```bash
$ redis-server
```

![image-20210211112452333](/home/alexis/snap/typora/33/.config/Typora/typora-user-images/image-20210211112452333.png)

Open the command-line interface:

```bash
$ redis-cli
```



##### [[1](https://www.tutorialspoint.com/redis/redis_quick_guide.htm)]Explore the Commands

Test the installation

```bash
127.0.0.1:6379> ping
PONG
```

Go through its configurations

```bash
127.0.0.1:6379> CONFIG GET *
  1) "dbfilename"
  2) "dump.rdb"
  3) "requirepass"
  4) ""
  5) "masterauth"
  6) ""
  7) "cluster-announce-ip"
  8) ""
  9) "unixsocket"
 10) ""
 11) "logfile"
 12) "/var/log/redis/redis-server.log"
 13) "pidfile"
 14) "/var/run/redis/redis-server.pid"
 15) "slave-announce-ip"
 16) ""
 17) "replica-announce-ip"
 18) ""
 19) "maxmemory"
 20) "0"
 21) "proto-max-bulk-len"
 22) "536870912"
 23) "client-query-buffer-limit"
 24) "1073741824"
 25) "maxmemory-samples"
 26) "5"
 27) "lfu-log-factor"
 28) "10"
 29) "lfu-decay-time"
 30) "1"
 31) "timeout"
 32) "0"
 33) "active-defrag-threshold-lower"
 34) "10"
 35) "active-defrag-threshold-upper"
 36) "100"
 37) "active-defrag-ignore-bytes"
 38) "104857600"
 39) "active-defrag-cycle-min"
 40) "5"
 41) "active-defrag-cycle-max"
 42) "75"
 43) "active-defrag-max-scan-fields"
 44) "1000"
 45) "auto-aof-rewrite-percentage"
 46) "100"
 47) "auto-aof-rewrite-min-size"
 48) "67108864"
 49) "hash-max-ziplist-entries"
 50) "512"
 51) "hash-max-ziplist-value"
 52) "64"
 53) "stream-node-max-bytes"
 54) "4096"
 55) "stream-node-max-entries"
 56) "100"
 57) "list-max-ziplist-size"
 58) "-2"
 59) "list-compress-depth"
 60) "0"
 61) "set-max-intset-entries"
 62) "512"
 63) "zset-max-ziplist-entries"
 64) "128"
 65) "zset-max-ziplist-value"
 66) "64"
 67) "hll-sparse-max-bytes"
 68) "3000"
 69) "lua-time-limit"
 70) "5000"
 71) "slowlog-log-slower-than"
 72) "10000"
 73) "latency-monitor-threshold"
 74) "0"
 75) "slowlog-max-len"
 76) "128"
 77) "port"
 78) "6379"
 79) "cluster-announce-port"
 80) "0"
 81) "cluster-announce-bus-port"
 82) "0"
 83) "tcp-backlog"
 84) "511"
 85) "databases"
 86) "16"
 87) "repl-ping-slave-period"
 88) "10"
 89) "repl-ping-replica-period"
 90) "10"
 91) "repl-timeout"
 92) "60"
 93) "repl-backlog-size"
 94) "1048576"
 95) "repl-backlog-ttl"
 96) "3600"
 97) "maxclients"
 98) "10000"
 99) "watchdog-period"
100) "0"
101) "slave-priority"
102) "100"
103) "replica-priority"
104) "100"
105) "slave-announce-port"
106) "0"
107) "replica-announce-port"
108) "0"
109) "min-slaves-to-write"
110) "0"
111) "min-replicas-to-write"
112) "0"
113) "min-slaves-max-lag"
114) "10"
115) "min-replicas-max-lag"
116) "10"
117) "hz"
118) "10"
119) "cluster-node-timeout"
120) "15000"
121) "cluster-migration-barrier"
122) "1"
123) "cluster-slave-validity-factor"
124) "10"
125) "cluster-replica-validity-factor"
126) "10"
127) "repl-diskless-sync-delay"
128) "5"
129) "tcp-keepalive"
130) "300"
131) "cluster-require-full-coverage"
132) "yes"
133) "cluster-slave-no-failover"
134) "no"
135) "cluster-replica-no-failover"
136) "no"
137) "no-appendfsync-on-rewrite"
138) "no"
139) "slave-serve-stale-data"
140) "yes"
141) "replica-serve-stale-data"
142) "yes"
143) "slave-read-only"
144) "yes"
145) "replica-read-only"
146) "yes"
147) "slave-ignore-maxmemory"
148) "yes"
149) "replica-ignore-maxmemory"
150) "yes"
151) "stop-writes-on-bgsave-error"
152) "yes"
153) "daemonize"
154) "yes"
155) "rdbcompression"
156) "yes"
157) "rdbchecksum"
158) "yes"
159) "activerehashing"
160) "yes"
161) "activedefrag"
162) "no"
163) "protected-mode"
164) "yes"
165) "repl-disable-tcp-nodelay"
166) "no"
167) "repl-diskless-sync"
168) "no"
169) "aof-rewrite-incremental-fsync"
170) "yes"
171) "rdb-save-incremental-fsync"
172) "yes"
173) "aof-load-truncated"
174) "yes"
175) "aof-use-rdb-preamble"
176) "yes"
177) "lazyfree-lazy-eviction"
178) "no"
179) "lazyfree-lazy-expire"
180) "no"
181) "lazyfree-lazy-server-del"
182) "no"
183) "slave-lazy-flush"
184) "no"
185) "replica-lazy-flush"
186) "no"
187) "dynamic-hz"
188) "yes"
189) "maxmemory-policy"
190) "noeviction"
191) "loglevel"
192) "notice"
193) "supervised"
194) "no"
195) "appendfsync"
196) "everysec"
197) "syslog-facility"
198) "local0"
199) "appendonly"
200) "no"
201) "dir"
202) "/var/lib/redis"
203) "save"
204) "900 1 300 10 60 10000"
205) "client-output-buffer-limit"
206) "normal 0 0 0 slave 268435456 67108864 60 pubsub 33554432 8388608 60"
207) "unixsocketperm"
208) "0"
209) "slaveof"
210) ""
211) "notify-keyspace-events"
212) ""
213) "bind"
214) "127.0.0.1 ::1"
```

Store a String value = "hello" in the key = "testkey":

```bash
127.0.0.1:6379> SET testkey "hello"
OK
```

 Retrieve the value stored in "testkey":

```bash
127.0.0.1:6379> GET testkey
"hello"
```

Check for the existence of a key named "testkey" (1=exists; 0=doesn't exist):

```bash
127.0.0.1:6379> EXISTS testkey
(integer) 1
```

Check the type of variable of the key:

```bash
127.0.0.1:6379> TYPE testkey
string
```

Retrieve all keys:

```bash
127.0.0.1:6379> KEYS *
1) "testkey"
```

Delete the created key (returns 1=succeeded; 0=failed) :

```bash
127.0.0.1:6379> DEL testkey
(integer) 1
```



In Redis, a Strings are serialized characters in C. Integers are stored in Redis as a String.

Set and retrieve another String value and an Integer one:

```bash
127.0.0.1:6379> SET Book:1 "Infinite Jest"
OK
127.0.0.1:6379> GET Book:1
"Infinite Jest"
127.0.0.1:6379> SET Book:1:ReadAction 1
OK
127.0.0.1:6379> GET Book:1:ReadAction
"1"
```

Increase the Integer value by 1, and then by 5. Then, decrease it again by 2, then by 1.

```bash
127.0.0.1:6379> INCR Book:1:ReadAction
(integer) 2
127.0.0.1:6379> GET Book:1:ReadAction
"2"
127.0.0.1:6379> INCRBY Book:1:ReadAction 5
(integer) 7
127.0.0.1:6379> GET Book:1:ReadAction
"7"
127.0.0.1:6379> DECRBY Book:1:ReadAction 2
(integer) 5
127.0.0.1:6379> GET Book:1:ReadAction
"5"
127.0.0.1:6379> DECR Book:1:ReadAction
(integer) 4
127.0.0.1:6379> GET Book:1:ReadAction
"4"
```

The last set of commands only works with Integer values:

```bash
127.0.0.1:6379> INCR Book:1 "Infinite Jest"
(error) ERR wrong number of arguments for 'incr' command
```

Defining and retrieving of multiple key value pairs can be done at once:

```bash
127.0.0.1:6379> MSET Person:2 "Kurt Vonnegut" Person:3 "Jane Austen" Person:4 "Mark Twain"
OK
127.0.0.1:6379> MGET Person:2 Person:3 Person:4
1) "Kurt Vonnegut"
2) "Jane Austen"
3) "Mark Twain"  
```



Lists in Redis are ordered collections that allow duplicates values. Because they are implemented as linked-lists, adding an item to the front or to the end of the list are relatively inexpensive operations that are performed in constant time of O(1).

When adding elements to a list value, it can be done at its beginning (head) or at its end (tail). Also, a range of values' positions can be retrieved from a list:

```bash
127.0.0.1:6379> LPUSH Book:1:comment "This was a fun read"
(integer) 1
127.0.0.1:6379> LRANGE Book:1:comment 0 -1
1) "This was a fun read"
127.0.0.1:6379> LPUSH Book:1:comment "Way too long!"
(integer) 2
127.0.0.1:6379> LRANGE Book:1:comment 0 -1
1) "Way too long!"
2) "This was a fun read"
127.0.0.1:6379> RPUSH Book:1:comment "Tennis anyone?"
(integer) 3
127.0.0.1:6379> LRANGE Book:1:comment 0 -1
1) "Way too long!"
2) "This was a fun read"
3) "Tennis anyone?"
```

Pop the last element from the list, then, the first one:

```bash
127.0.0.1:6379> RPOP Book:1:comment
"Tennis anyone?"
127.0.0.1:6379> LRANGE Book:1:comment 0 -1
1) "Way too long!"
2) "This was a fun read"
127.0.0.1:6379> LPOP Book:1:comment
"Way too long!"
127.0.0.1:6379> LRANGE Book:1:comment 0 -1
1) "This was a fun read"
```

Create a new list, then, remove its last element without using LPOP:

```bash
(....)
127.0.0.1:6379> LRANGE Organization:1:members 0 -1
1) "Person:1"
2) "Person:2"
3) "Person:2"
4) "Person:3"
5) "Person:4"
127.0.0.1:6379> LTRIM Organization:1:members 0 3
OK
127.0.0.1:6379> LRANGE Organization:1:members 0 -1
1) "Person:1"
2) "Person:2"
3) "Person:2"
4) "Person:3"
```



A Redis hash is a collection of key value pairs. Hence, they are used to represent objects. Every hash can store up to 232 - 1 field-value pairs (more than 4 billion).

Set a value of a single field for the Hash key **Book:3**:

```bash
127.0.0.1:6379> HSET Book:3 name "Cats Cradle"
(integer) 1
127.0.0.1:6379> HGET Book:3 name
"Cats Cradle"
```

To the same key, there can also be set and retrieved multiple pairs and, in the case of retrieving, all of them:

```bash
127.0.0.1:6379> HMSET Book:4 name "Slaughterhouse-Five" author "Kurt Vonnegut" copyrightYear 1969 ISBN 29960763
OK
127.0.0.1:6379> HMGET Book:4 author ISBN
1) "Kurt Vonnegut"
2) "29960763"
127.0.0.1:6379> HGETALL Book:4
1) "name"
2) "Slaughterhouse-Five"
3) "author"
4) "Kurt Vonnegut"
5) "copyrightYear"
6) "1969"
7) "ISBN"
8) "29960763"
```

Check if a field exists for a given key, and get the number its fields:

```bash
127.0.0.1:6379> HEXISTS Book:4 copyrightYear
(integer) 1
127.0.0.1:6379> HEXISTS Book:4 barcode
(integer) 0
127.0.0.1:6379> HLEN Book:4
(integer) 4
```

Retrieve all the field names and then all the field values for a Hash key:

```bash
127.0.0.1:6379> HKEYS Book:4
1) "name"
2) "author"
3) "copyrightYear"
4) "ISBN"
127.0.0.1:6379> HVALS Book:4
1) "Slaughterhouse-Five"
2) "Kurt Vonnegut"
3) "1969"
4) "29960763"
```

Delete a field from the Hash key, and insert a new "Integer" one, to increase its value by 20:

```bash
127.0.0.1:6379> HDEL Book:4 copyrightYear
(integer) 1
127.0.0.1:6379> HGETALL Book:4
1) "name"
2) "Slaughterhouse-Five"
3) "author"
4) "Kurt Vonnegut"
5) "ISBN"
6) "29960763"
127.0.0.1:6379> HSET Book:4 copyrightYear 1968
(integer) 1
127.0.0.1:6379> HGET Book:4 copyrightYear
"1968"
127.0.0.1:6379> HINCRBY Book:4 copyrightYear 20
(integer) 1988
127.0.0.1:6379> HGET Book:4 copyrightYear
"1988"
```



A set is a collection of unique, unordered String members. Redis sets also implement union, intersection, and difference set semantics.

Add one or more elements to a set and display them:

```bash
127.0.0.1:6379> SET Organization:5 "Beatles"
OK
127.0.0.1:6379> SADD Organization:5:member Paul John Ringo George
(integer) 0
127.0.0.1:6379> SMEMBERS Organization:5:member
1) "George"
2) "Ringo"
3) "John"
4) "Paul"
```

Determine whether John and Ralph are members of the set and verify how many members it has:

```bash
127.0.0.1:6379> SISMEMBER Organization:5:member "John"
(integer) 1
127.0.0.1:6379> SISMEMBER Organization:5:member "Ralph"
(integer) 0
127.0.0.1:6379> SCARD Organization:5:member
(integer) 4
```



## The Log File

Redis automatically stores a log file with all the commands ran:

```bash
cd ~
ls -a
cp .rediscli_history Desktop/rediscli_history
```



