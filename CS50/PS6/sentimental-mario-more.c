#TODO
limit = 8

    while True:
try : height = int(input("Height: "))

    except ValueError:
        print("Invalid input. Please enter a valid integer.")

        continue

    if height > 0 and height <= limit:
        max_width = height

        for i in range(1, height + 1):  # 1 to 8 i++
#(print space 8 to 1 i --) +(#multiplied by i) +(space in the middle) +(#multiplied by i)
            print("".rjust(max_width - i) + "#" * i + "  " + "#" * i)

        break

    else:
        print("Height should be greater than 0 and less than or equal to", limit)
