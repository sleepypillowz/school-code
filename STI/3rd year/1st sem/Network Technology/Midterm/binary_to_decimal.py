def binary_to_decimal(dotted_binary):
    binary_parts = dotted_binary.split('.')
    decimal_parts = [str(int(part, 2)) for part in binary_parts]
    decimal_notation = ".".join(decimal_parts)
    return decimal_notation

# Test the function with your examples
binary1 = "11101001.00011011.10000000.10100100"
binary2 = "10101010.00110100.11100110.00010111"
binary3 = "11111111.11010011.01000001.11001110"

decimal1 = binary_to_decimal(binary1)
decimal2 = binary_to_decimal(binary2)
decimal3 = binary_to_decimal(binary3)

print("Decimal Notation 1:", decimal1)
print("Decimal Notation 2:", decimal2)
print("Decimal Notation 3:", decimal3)
