def add(x, y):
    return x + y

def subtract(x, y):
    return x - y

def multiply(x, y):
    return x * y

def divide(x, y):
    # Handle division by zero
    if y == 0:
        return "Error: Cannot divide by zero!"
    return x / y

def calculator():
    print("Welcome to the Simple Calculator!")

    while True:
        print("\n---")
        print("Choose an operation:")
        print("1. Add")
        print("2. Subtract")
        print("3. Multiply")
        print("4. Divide")
        print("5. Exit")

        choice = input("Enter your choice (1/2/3/4/5): ")

        if choice in ('1', '2', '3', '4'):
            try:
                num1 = float(input("Enter first number: "))
                num2 = float(input("Enter second number: "))
            except ValueError:
                print("Invalid input. Please enter numbers only.")
                continue # Skip to the next loop iteration

            if choice == '1':
                result = add(num1, num2)
                operation_symbol = "+"
            elif choice == '2':
                result = subtract(num1, num2)
                operation_symbol = "-"
            elif choice == '3':
                result = multiply(num1, num2)
                operation_symbol = "*"
            else: # choice == '4'
                result = divide(num1, num2)
                operation_symbol = "/"
            
           
            if isinstance(result, str): # If it's an error message
                print(result)
            else:
                print(f"Result: {num1} {operation_symbol} {num2} = {result}")

        elif choice == '5':
            print("Thanks for using the calculator. Goodbye!")
            break # Exit the loop
        else:
            print("Invalid choice. Please pick from 1, 2, 3, 4, or 5.")

if _name_ == "_main_":
    calculator()
