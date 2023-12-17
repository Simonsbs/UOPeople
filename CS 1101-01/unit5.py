def display_n_characters(name, n):
    # Display the first n characters of the given name.
    return name[:n]

def count_vowels(name):
    # Count and return the number of vowels in the given name.
    
    # Define the vowels
    vowels = "AEIOUaeiou"
    
    # Initialize a counter for the vowels
    vowel_count = 0
    
    # Iterate over each character in the name
    for char in name:
        # Check if the character is a vowel
        if char in vowels:
            # Increment the vowel counter
            vowel_count += 1
            
    # Return the final count of vowels
    return vowel_count

def reverse_string(name):
    # Return the reversed version of the given name.
    return name[::-1]

def main():
    # Stage 1: Get the user's name
    name = input("Enter your name: ")

    # Stage 2: Get the number of characters to display from the left
    n_input = input("Enter the number of characters you want to display from the left: ")
    n = int(n_input)

    # Stage 3: Display n characters from the left
    first_n_chars = display_n_characters(name, n)
    print(f"First {n} characters from the left: {first_n_chars}")

    # Stage 4: Count the number of vowels in the name
    vowels_count = count_vowels(name)
    print(f"Number of vowels in the name: {vowels_count}")

    # Stage 5: Reverse the name and display it
    reversed_name = reverse_string(name)
    print(f"Reversed name: {reversed_name}")

main()