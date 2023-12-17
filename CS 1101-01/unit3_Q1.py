def countdown(n):
    if n > 0:
        print(n)
        countdown(n-1)

def countup(n):
    if n < 0:
        print(n)
        countup(n+1)

def main() :
    print("Please enter an initial countdown value:")
    print("(The value can be either positive or negative)")
    num = int(input("Value:"))
    
    if num > 0:
        countdown(num)
    elif num < 0:
        countup(num)
        
    print('Blastoff!')

main()
