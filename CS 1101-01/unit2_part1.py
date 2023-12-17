# define a constant for π and initialize the value
PI = 3.14159

def print_circum(radius):
    # Calculate the circumference using the formula 2 * π * radius
    circumference = 2 * PI * radius
    
    # Print the calculated circumference
    print(f"The circumference of a circle with radius {radius} is {circumference:.5f}")


# Test the function with three different radius values
print_circum(42)
print_circum(PI)
print_circum(2 / PI)
