import re

def shorten_ipv6(ipv6_address):
    # Split the address into groups
    groups = ipv6_address.split(":")
    
    # Remove leading zeros in each group
    shortened_groups = [re.sub(r'^0+', '', group) for group in groups]
    
    # Collapse consecutive groups of zeros with ::
    shortened_ipv6 = ":".join(shortened_groups)
    shortened_ipv6 = re.sub(r'(?::|^)(0::)+', '::', shortened_ipv6)
    
    return shortened_ipv6

# Example IPv6 addresses
ipv6_1 = "FD81:273B:6A9D:0000:0DA6:CACD:2347:3596"
ipv6_2 = "FD56:0000:004D:E798:F100:2344:1002:3461"
ipv6_3 = "FD00:8E00:006c:0000:0006:B761:AABD:0034"

# Shorten the IPv6 addresses
shortened_ipv6_1 = shorten_ipv6(ipv6_1)
shortened_ipv6_2 = shorten_ipv6(ipv6_2)
shortened_ipv6_3 = shorten_ipv6(ipv6_3)

print("Shortened IPv6 Address 1:", shortened_ipv6_1)
print("Shortened IPv6 Address 2:", shortened_ipv6_2)
print("Shortened IPv6 Address 3:", shortened_ipv6_3)
