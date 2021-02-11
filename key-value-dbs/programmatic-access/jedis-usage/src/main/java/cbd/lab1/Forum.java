package cbd.lab1;

import redis.clients.jedis.Jedis;

public class Forum {
    private Jedis jedis;

    public Forum(){
        this.jedis = new Jedis("localhost");
        System.out.println(jedis.info());
    }

    public void main(String args[]){
        new Forum();
        System.out.println("Server is running: " + jedis.ping());
    }
}
