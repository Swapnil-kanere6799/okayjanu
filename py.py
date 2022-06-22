import csv
from random import randint 

per_row = 100
target_size = 1024 ** 3
with open('number.txt' , 'w' , newline=' ') as f_out:
    f_write = csv.write(f_out)

    while f_out.tell() < target_size:
        row = [randint(0,99) for _ in range(per_row)]
        f_write.writerow(row)