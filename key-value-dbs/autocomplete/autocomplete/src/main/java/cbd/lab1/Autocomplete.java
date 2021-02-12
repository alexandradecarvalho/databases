package cbd.lab1;

import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Autocomplete {
    private Jedis jedis;

    public Autocomplete(){
        this.jedis = new Jedis("localhost");
        System.out.println(jedis.info());
    }

    private void populate(String filename){
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            int i = 0;
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                this.jedis.zadd("nameset",i, data);
                i += 1;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not Found");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Autocomplete j = new Autocomplete();
        System.out.println("Server is running: " + j.jedis.ping());
        j.populate("female-names.txt");

        Scanner sc = new Scanner(System.in);
        String name;
        do {
            System.out.println("Search for ('Enter' for quit): ");
            name = sc.nextLine();
            String min = "[" + name;
            String max = "[" + name + "\\xff";
            if(!name.equals("")){
                j.jedis.zrangeByLex("nameset",min, max).stream().forEach(System.out::println);
            }
        }while(!name.equals(""));
        sc.close();

    }
}
