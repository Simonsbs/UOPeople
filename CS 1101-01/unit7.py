def invert_dict(student_courses):
    # This function inverts a dictionary that maps student identifiers
    # to a list of courses they're enrolled in.The inverted dictionary
    # maps course identifiers to a list of student identifiers
    # enrolled in that course.

    inverted = {}

    # First we iterate over the student_courses dictionary
    # using the items() method
    for student, courses in student_courses.items():
        # Then we iterate over the courses list for each student
        for course in courses:
            # If the course is already in the inverted dictionary
            # we append the student to the list of students for that
            # course. Otherwise, we create a new key-value pair
            # with the course as the key and the student as the value.
            if course in inverted:
                inverted[course].append(student)
            else:
                inverted[course] = [student]
    return inverted


# Sample input
sample_input = {
    'Stud1': ['CS1101', 'CS2402', 'CS2001'],
    'Stud2': ['CS2402', 'CS2001', 'CS1102']
}

# Inverting the dictionary
inverted_output = invert_dict(sample_input)

# Output
print('Original:', sample_input)
print('Inverted:', inverted_output)
