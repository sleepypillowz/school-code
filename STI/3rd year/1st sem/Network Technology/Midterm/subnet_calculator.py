import ipaddress

def subnet_info(original_network, num_subnets):
    # Calculate the number of bits required for the custom subnet mask
    subnet_bits = num_subnets.bit_length()

    # Calculate the custom subnet mask
    custom_subnet_mask = f"/{32 - subnet_bits}"

    # Create an IPv4 network object with the original network and custom subnet mask
    original_network = ipaddress.IPv4Network(f"{original_network}{custom_subnet_mask}", strict=False)

    # Calculate the IP address ranges for the subnets
    subnet_ranges = list(original_network.subnets(new_prefix=original_network.prefixlen + subnet_bits))

    # Calculate the number of subnets and hosts per subnet
    num_total_subnets = 2 ** subnet_bits
    num_hosts_per_subnet = 2 ** (32 - (original_network.prefixlen + subnet_bits)) - 2

    # Create a dictionary to store the information
    subnet_info_dict = {
        "Original Network": str(original_network.network_address),
        "Custom Subnet Mask": custom_subnet_mask,
        "Number of Subnets": num_total_subnets,
        "Number of Hosts per Subnet": num_hosts_per_subnet,
        "Subnets": [
            {
                f"Subnet {i + 1}": f"{subnet.network_address} - {subnet.broadcast_address}"
            }
            for i, subnet in enumerate(subnet_ranges)
        ],
    }

    return subnet_info_dict

# Example usage of the function
original_network = "89.63.200.0"
num_subnets = 20
result = subnet_info(original_network, num_subnets)

# Print the result dictionary
for key, value in result.items():
    if key == "Subnets":
        print(key + ":")
        for subnet_range in value:
            for subnet_name, subnet_address in subnet_range.items():
                print(f"{subnet_name}: {subnet_address}")
    else:
        print(f"{key}: {value}")
