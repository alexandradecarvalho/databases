# Redis



## Programmatic Access

To use Redis in your Java programs, you need to make sure that you have Redis Java driver and Java set up on the machine. 



##### How to get it?

Download the latest build [here](http://github.com/redis/jedis/releases). 

**OR:** Use it as a maven dependency.

To create the project:

```bash
mvn archetype:generate -DgroupId=cbd.lab1 -DartifactId=jedis-usage -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false
```

Change the POM file:

```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.5.1</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```



## Exercise

Base connector class:

```java
public class Forum {
    private Jedis jedis;

    public Forum(){
        this.jedis = new Jedis("localhost");
        System.out.println(jedis.info());
    }

    public static void main(String args[]){
        Forum j = new Forum();
        System.out.println("Server is running: " + j.jedis.ping());
    }
}
```