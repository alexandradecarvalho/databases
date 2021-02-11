# Redis



## Autocomplete

Example using the Redis server and the Jedis client driver to create a program that provides a list of ordered terms for the purpose of auto-completion. Let's start by using the **"female-names.txt"** file for the search terms.



##### Step 1 - Python Script

In order to have not only the names, but also the command SET:

```python
def main():
    commands = open("commands4redis.txt","w") 

    file_lines = []
    with open("female-names.txt", "r") as female_names:
        file_lines = female_names.readlines()
        female_names.close()
    
    for name in file_lines:
        line_to_write = "SET " + name.strip("\n") + "\n"
        commands.write(line_to_write)
    
    commands.close()

if __name__ == "__main__":
    main()
```



The file **"commands4redis.txt"** after running the script:

> SET aaren
> SET aarika
> SET abagael
> SET abagail
> SET abbe
> SET abbey
> SET abbi
> SET abbie
> SET abby
> SET abbye
> SET abigael
> SET abigail
> SET abigale
> SET abra
> (...)
> SET zitella
> SET zoe
> SET zola
> SET zonda
> SET zondra
> SET zonnya
> SET zora
> SET zorah
> SET zorana
> SET zorina
> SET zorine
> SET zsa zsa
> SET zsazsa
> SET zulema
> SET zuzana



##### Step 2 - Pipelining from the File to Redis-cli

```bash
cat commands4redis.txt | redis-cli --pipe 
```