def hypotenuse(a, b):
    if a < 0 or b < 0:
        return "Invalid input: lengths must be non-negative."
    return (a**2 + b**2)**0.5

print(hypotenuse(3,4))
print(hypotenuse(5,12))
print(hypotenuse(8,15))
print(hypotenuse(-5,10))
print(hypotenuse(5,-10))
print(hypotenuse(-5,-10))
print(hypotenuse(0,0))