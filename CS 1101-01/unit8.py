import json

# Step 1: Create the input file with the original dictionary
input_file_content = """{
  "Blade Runner": ["Sci-Fi", "Neo-noir"],
  "The Matrix": ["Sci-Fi", "Action"],
  "Star Wars: Return of the Jedi": ["Sci-Fi", "Adventure"],
  "Terminator 2: Judgment Day": ["Sci-Fi", "Action"],
  "Total Recall": ["Sci-Fi", "Action"],
  "The Fifth Element": ["Sci-Fi", "Adventure"]
}"""

# define the input and output file paths
input_file_path = "original_dict.txt"
output_file_path = "inverted_dict.txt"

# Save the content to original_dict.txt
with open(input_file_path, "w") as file:
    file.write(input_file_content)


# Step 2: Python Program to read, invert the dictionary, and write to a new file
def invert_dictionary(input_file_path, output_file_path):
    try:
        # Read the dictionary from the input file
        with open(input_file_path, 'r') as file:
            original_dict = json.load(file)

        # Improved Invert the dictionary
        # Source, Jose Alvarado (Instructor)
        inverted_dict = {}
        for key, values in original_dict.items():
            for value in values:
                inverted_dict.setdefault(value, []).append(key)

        # Write the inverted dictionary to the output file
        with open(output_file_path, 'w') as file:
            json.dump(inverted_dict, file, indent=2)

        return original_dict, inverted_dict
    except FileNotFoundError:
        print(f"Error: The file {input_file_path} was not found.")
    except SyntaxError:
        print("Error: The content of the input file is not a valid dictionary.")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")


# Call the function and save the returned values
original_dict, inverted_dict = invert_dictionary(
    input_file_path, output_file_path)

# output the original dictionary
print("Original Dictionary:")
print(original_dict)
# output the inverted dictionary
print("Inverted Dictionary:")
print(inverted_dict)
