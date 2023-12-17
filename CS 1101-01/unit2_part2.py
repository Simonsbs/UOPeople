# This function takes a total amount and returns the new discounted total
def calc_discount(total_price, item_count):
    if item_count == 2:
        return total_price * 0.9  # 10% discount
    elif item_count == 3:
        return total_price * 0.75 # 25% discount
    else:
        return total_price        # 0% discount    


# Prices for individual items
item1_price = 200.0
item2_price = 400.0
item3_price = 600.0

# Calculate combo prices
combo1_price = calc_discount((item1_price + item2_price), 2)
combo2_price = calc_discount((item2_price + item3_price), 2)
combo3_price = calc_discount((item1_price + item3_price), 2)
combo4_price = calc_discount((item1_price + item2_price + item3_price), 3)

output = "Online Store\n"
output += "--------------------------------\n"
output += "Product(s)               | Price\n"
output += "Item 1                   | " + str(item1_price) + "\n"
output += "Item 2                   | " + str(item2_price) + "\n"
output += "Item 3                   | " + str(item3_price) + "\n"
output += "Combo 1(Item 1 + 2)      | " + str(combo1_price) + "\n"
output += "Combo 2(Item 2 + 3)      | " + str(combo2_price) + "\n"
output += "Combo 3(Item 1 + 3)      | " + str(combo3_price) + "\n"
output += "Combo 4(Item 1 + 2 + 3)  | " + str(combo4_price) + "\n"
output += "--------------------------------\n"
output += "For delivery Contact:98764678899\n"

print(output)
