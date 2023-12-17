try:
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    
    if num2 == 0:
        raise ZeroDivisionError("Sorry, we can’t divide a number by zero")
    
    result = num1 / num2
    print(f"Result: {result}")

except ZeroDivisionError as e:
    print(f"Error: {e}")
