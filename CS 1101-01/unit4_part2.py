def fizz_buzz(n):
    # Input validation
    if not isinstance(n, int) or n <= 0:
        return "Invalid input: Please provide a positive integer."

    if n % 3 == 0 and n % 5 == 0:
        return "Fizz Buzz"
    elif n % 3 == 0:
        return "Fizz"
    elif n % 5 == 0:
        return "Buzz"
    return n

print(fizz_buzz(2))
print(fizz_buzz(3))
print(fizz_buzz(4))
print(fizz_buzz(10))
print(fizz_buzz(15))
print(fizz_buzz(16))
print(fizz_buzz('One'))
print(fizz_buzz(0))