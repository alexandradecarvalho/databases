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