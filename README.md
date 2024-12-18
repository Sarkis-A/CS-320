# CS-320
## How can I ensure that my code, program, or software is functional and secure?
Ensuring functionality and security is a top priority when developing any code, program, or software. To achieve functionality, I write comprehensive unit tests to validate the code against various scenarios, including valid inputs, boundary cases, and invalid inputs. For instance, in the contact service project, I ensured that fields such as contactId, firstName, and lastName were validated to meet strict constraints, including maximum character lengths and non-null values. This was thoroughly tested using JUnit tests like:

assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"), "Contact ID should not be null");.

Implementing these validations ensured that only valid and secure data could enter the system. Security was further enhanced by requiring all updates and additions to meet these constraints, which helped maintain data integrity. I confirmed that the contact service was functional and secure through structured validation and testing.

## How do I interpret user needs and incorporate them into a program?
Understanding user needs is fundamental in developing software that effectively meets requirements. I thoroughly analyze the project requirements to grasp the user's goals. For example, in the task service project, the requirement that task descriptions must not exceed 50 characters was implemented as a validation rule in both the Task class and its associated test cases. By incorporating such constraints into the design, I ensured the program aligned with the user's expectations. 

Additionally, I prioritize scalability and maintainability to allow the program to grow with future needs. This approach involves utilizing flexible and modular designs, as demonstrated in the services I implemented, where each operation—such as adding, updating, and deleting—is modular and easy to extend.

## How do I approach designing software?
When designing software, I systematically break down the problem into smaller, manageable components. Each project begins with defining the core classes, such as Contact, Task, and Appointment, along with their specific attributes and validation rules. After implementing these core components, I develop service classes to handle operations like adding, updating, and deleting objects. This separation of concerns ensures clarity and reduces complexity in the overall design.

I also prioritize user constraints and operational requirements during the design phase, ensuring that validations and edge cases are considered. Finally, I treat testing as a crucial part of the design process, writing test cases to confirm the software's functionality and robustness before finalizing the implementation.
