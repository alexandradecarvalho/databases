package cbd.lab1;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class Forum {
    private Jedis jedis;

    public Forum(){
        this.jedis = new Jedis("localhost");
        System.out.println(jedis.info());
    }

    public static void main(String args[]){
        Forum j = new Forum();
        System.out.println("Server is running: " + j.jedis.ping());

        int choice = 0;
        String book = null;
        int start;
        int finish;
        String attribute = null;
        String value = null;
        Map<String, String> register = new HashMap<String,String>();

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\n\n### REDIS INTERACTION -- BOOK STORE ###");
            System.out.println("                  ===============================\n");
            System.out.println("                  |     1 - Add Best Seller To Top             |");
            System.out.println("                  |     2 - Add Best Seller To Bottom          |");
            System.out.println("                  |     3 - List Best Sellers                  |");
            System.out.println("                  |     4 - Remove Top Best Seller             |");
            System.out.println("                  |     5 - Remove Bottom Best Seller          |");
            System.out.println("                  |     6 - Extract Sublist                    |");
            System.out.println("                  |     7 - Add Book's Attribute               |");
            System.out.println("                  |     8 - Get Book's Attribute               |");
            System.out.println("                  |     9 - Add Books's Many Attributes        |");
            System.out.println("                  |    10 - Check If We Have The Info You Want |");
            System.out.println("                  |    11 - Check How Many Info Fields We Have |");
            System.out.println("                  |    12 - List All Book's Fields of Info     |");
            System.out.println("                  |    13 - List All Book's Information        |");
            System.out.println("                  |    14 - Delete a Book's Field of Info      |");
            System.out.println("                  |     0 - Exit                               |");
            System.out.println("                  ===============================\n");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n > Please, insert the name of the book");
                    book = sc.nextLine();
                    j.jedis.lpush("TopList", book);
                    System.out.println("\n Updated TopList:");
                    j.jedis.lrange("TopList",0,-1).stream().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("\n > Please, insert the name of the book");
                    book = sc.nextLine();
                    j.jedis.rpush("TopList", book);
                    System.out.println("\n Updated TopList:");
                    j.jedis.lrange("TopList",0,-1).stream().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("\n TopList:");
                    j.jedis.lrange("TopList",0,-1).stream().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println(j.jedis.lpop("TopList"));
                    break;

                case 5:
                    System.out.println(j.jedis.rpop("TopList"));
                    break;

                case 6:

                    System.out.println("\n Please, insert the first and then the last indexes of the range of the current list you want to keep (starts at 0)");

                    try{
                        start = Integer.parseInt(sc.nextLine());
                        finish = Integer.parseInt(sc.nextLine());
                    }catch (NumberFormatException e){
                        System.out.println("Sorry! At least one of the inserted values wasn't a number. Please Try Again...");
                        break;
                    }

                    j.jedis.ltrim("TopList", start, finish);
                    System.out.println("\n Updated TopList:");
                    j.jedis.lrange("TopList",0,-1).stream().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();
                    System.out.println("> Please, insert the name of the attribute");
                    attribute = sc.nextLine();
                    System.out.println("> Please, insert the value of the attribute");
                    value = sc.nextLine();

                    j.jedis.hset(book, attribute, value);
                    System.out.println("\n Book Register:");
                    System.out.println("name: " + book);

                    register = j.jedis.hgetAll(book);

                    Iterator it = register.entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        System.out.println(pair.getKey() + ": " + pair.getValue());
                        it.remove();
                    }
                    register.clear();
                    break;

                case 8:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();
                    System.out.println("> Please, insert the name of the attribute");
                    attribute = sc.nextLine();

                    System.out.println(book + ": " + attribute + "=" + j.jedis.hget(book, attribute));
                    break;

                case 9:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();

                    do {
                        System.out.println("> Please, insert the name of the attribute (q to finish)");
                        attribute = sc.nextLine();
                        if(!attribute.equals("q")){
                            System.out.println("> Please, insert the value of the attribute");
                            value = sc.nextLine();
                            register.put(attribute,value);
                        }
                    } while(!attribute.equals("q"));

                    j.jedis.hmset(book, register);
                    register.clear();
                    System.out.println("\n Book Register:");
                    System.out.println("name: " + book);

                    register = j.jedis.hgetAll(book);

                    Iterator it2 = register.entrySet().iterator();
                    while(it2.hasNext()){
                        Map.Entry pair = (Map.Entry)it2.next();
                        System.out.println(pair.getKey() + ": " + pair.getValue());
                        it2.remove();
                    }
                    register.clear();
                    break;

                case 10:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();
                    System.out.println("> Please, insert the name of the attribute");
                    attribute = sc.nextLine();

                    boolean exists = j.jedis.hexists(book,attribute);
                    if(exists){
                        System.out.println("The " + attribute + " of " + book + " is " + j.jedis.hget(book,attribute));
                    }else{
                        System.out.println("I'm sorry! We don't have that information yet!");
                    }
                    break;

                case 11:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();

                    System.out.println("We have " + j.jedis.hlen(book) + " fields of information on that book.");
                    break;

                case 12:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();

                    j.jedis.hkeys(book).stream().forEach(System.out::println);
                    break;

                case 13:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();

                    j.jedis.hvals(book).stream().forEach(System.out::println);
                    break;

                case 14:
                    System.out.println("\n> Please, insert the name of the book");
                    book = sc.nextLine();
                    System.out.println("> Please, insert the name of the attribute");
                    attribute = sc.nextLine();

                    j.jedis.hdel(book,attribute);

                    System.out.println("\n Book Register:");
                    System.out.println("name: " + book);

                    register = j.jedis.hgetAll(book);

                    Iterator it3 = register.entrySet().iterator();
                    while(it3.hasNext()){
                        Map.Entry pair = (Map.Entry)it3.next();
                        System.out.println(pair.getKey() + ": " + pair.getValue());
                        it3.remove();
                    }
                    register.clear();

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid Choice! Please Try Again...");
                    break;
            }
        } while (choice != 0);
        sc.close();
        exit(0);
    }
}
