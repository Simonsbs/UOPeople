# import the random library to generate random numbers
import random

# Initial list of 10 employee names
employee_list = ["Luke Skywalker",
                 "Han Solo",
                 "Princess Leia",
                 "Darth Vader",
                 "Yoda",
                 "Ellen Ripley",
                 "Sarah Connor",
                 "Kyle Reese",
                 "Marty McFly",
                 "Doc Brown"]

# Step 1: Splitting the list into two sublists
subList1 = employee_list[:5]
subList2 = employee_list[5:]

print(f'subList1: {subList1}')
print(f'subList2: {subList2}')

# Step 2: Adding a new employee to subList2
new_employee = "Kriti Brown"
subList2.append(new_employee)

print(f'subList2 - with new employee: {subList2}')

# Step 3: Removing the second employee's name from subList1
subList1.pop(1)

print(f'subList1 - after removing second employee: {subList1}')

# Step 4: Merging both the lists
merged_list = subList1 + subList2

print(f'Merged List: {merged_list}')

# Generate the initial salary list using random numbers
salaryList = [random.randint(40000, 100000)
              for _ in range(len(merged_list))]

print(f'Initial Salary List: {salaryList}')

# Step 5: Giving a rise of 4% to every employee
salaryList = [salary * 1.04 for salary in salaryList]

print(f'Updated Salary List: {salaryList}')

# Step 6: Sorting the SalaryList and showing top 3 salaries
salaryList.sort(reverse=True)
top_3_salaries = salaryList[:3]

print(f'Top 3 Salaries: {top_3_salaries}')
