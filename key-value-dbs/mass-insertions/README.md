# Redis



## Mass Insertion

Redis allows for the insertion of large amounts of data from a file, through the command line.



##### Step 1 - Python Script

Python Script that, given a file of names **female-names.txt**, writes the file **initials4redis.txt** with the following structure:

> SET A <number of names starting with ‘A’/’a’>
> SET B <number of names starting with ‘B’/’b’>
>
> ....



```python
def main():
    initials = open("initials4redis.txt","w") 

    file_lines = []
    with open("female-names.txt", "r") as female_names:
        file_lines = female_names.readlines()
        female_names.close()

    result = {}
    for name in file_lines:
        if name[0] not in result:
            result[name[0]] = 0
        result[name[0]] += 1

    for initial in result:
        line_to_write = "SET " + initial.capitalize() + " " + str(result[initial]) + "\n"
        initials.write(line_to_write)
    
    initials.close()

if __name__ == "__main__":
    main()
```



The file after running the script:

> SET A 463
> SET B 257
> SET C 463
> SET D 315
> SET E 248
> SET F 135
> SET G 210
> SET H 121
> SET I 74
> SET J 290
> SET K 268
> SET L 335
> SET M 471
> SET N 152
> SET O 63
> SET P 118
> SET Q 8
> SET R 243
> SET S 295
> SET T 193
> SET U 15
> SET V 104
> SET W 57
> SET X 5
> SET Y 21
> SET Z 31



##### Step 2 - Pipelining from the File to Redis-cli

```bash
cat initials4redis.txt | redis-cli --pipe 
```