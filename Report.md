# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

**1. What does CSV stand for?**  
CSV stands for Comma-Separated Values. It is a file format used to store tabular data, where each value is separated by a comma.[^1]

**2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?**    
This gives us the flexibility to use any type of List (e.g., ArrayList, LinkedList, etc.) and any class that implements the IEmployee interface. 

**3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?**  
   It represents a "has-a" relationship.

**4. Can you provide an example of a has-a relationship in your code (if one exists)?**   
   The runPayroll method in the HourlyEmployee class returns a PayStub object, which means that an HourlyEmployee "has-a" PayStub.

**5. Can you provide an example of an is-a relationship in your code (if one exists)?**  
Since HourlyEmployee implements the IEmployee interface, it follows the "is-a" relationship. This means that HourlyEmployee is a type of IEmployee.

**6. What is the difference between an interface and an abstract class?**  
- Interface defines a contract that classes must follow while abstract class serves as a base class that other classes extend.
- Interface provides only method signatures without implementation while abstract class can have both.[^2]
- A class can implement multiple interfaces while a class can extend only one abstract class.
- Interface's fields are public, static, and final by default while abstract class can have instance variables.[^3]
- Interface cannot have constructors while abstract class can have.

**7. What is the advantage of using an interface over an abstract class?**  
- A class can implement multiple interfaces, enabling greater flexibility in designing. But it can extend only one abstract class.[^2]
- Interfaces define a contract without enforcing any specific implementation. allowing different classes to implement the interface in their own way. 
- Default methods are introduced in interfaces, allowing for method implementation while still supporting multiple inheritance.[^4]

**8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it.**  
It is invalid as generics should work with object instead of primitive types. It should be `List<Integer> numbers = new ArrayList<Integer>()`. [^5]


**9. Which class/method is described as the "driver" for your application?**  
PayrollGenerator is the driver as it contains the main method, which is the entry point for execution.
In main, it creats different new objects and call their methods to process command-line arguments, read employee and time card data from files, generate pay stubs based on worked hours and create output files.
By doing so, it initializes and manages the necessary workflows within the program, making it the primary "driver" class of the application.


**10. How do you create a temporary folder for JUnit Testing?**  
We can use `@TempDir` annotation to creat a temporary files which provides a temporary directory that is automatically created for each test method, and it is automatically cleaned up after the test finishes.
After declaring `@TempDir` annotation and `static Path tempDir`, we can use `resolve()` to create file in the folder, like`Path employees = tempDir.resolve("employees.csv")`. [^6]




## Deeper Thinking 

*Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits.* 

*Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.*

*Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that.* 

*The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity.* 

Based on the calculation process of pay, pay rate is directly related to equity which can be determined by employers while other factors like pre-taxdeduction can not be changed by employers. 
To ensure equity, an employer should decide what factors should influence pay rate and what should not. For example, performance evaluation in this period should be considered while gender should not. [^7] 
According to survey, these factors are recommended to employers:  
- experience level: the number of years an employee has worked   
- job content: the complexity, scope, and level of responsibility [^8] 
- performance: individual or team performance evaluation  
- geographic location: different areas may differ in cost of living and prevailing wage rates while company business scale is not the same.  [^9]

For employers, they should determine the weight for the above factors and a method to calculate the expected pay rate based on them.  
So those factors should be added to employee class as attributes. A new class called `EquityExamination` should be added like PayStub and in class `Employee`, just like `runPayroll()`, a new method called `equityExamination()` should be added to calculate the expected pay rate and compare with the actual pay rate, return an `EquityExamination` class to report if the employee get the expected pay. And just like the process of generating PayStub.CSV, a report about all employees' pay equity can be got.



## References
[^1]: Comma-separated values. https://en.wikipedia.org/wiki/Comma-separated_values Accessed: 2025-02-08.  
[^2]: Abstract Methods and Classes. https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html Accessed: 2025-02-08.  
[^3]: Difference between Abstract Class and Interface in Java. https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/ Accessed: 2025-02-09.  
[^4]: Default Methods https://www.geeksforgeeks.org/default-methods-java/ Accessed: 2025-02-09.  
[^5]: Generic Types https://docs.oracle.com/javase/tutorial/java/generics/types.html Accessed: 2025-02-09.  
[^6]: JUnit 5 - @TempDir https://www.geeksforgeeks.org/junit-5-tempdir/?ref=ml_lbp Accessed: 2025-02-09.  
[^7]: What Are Pre-Tax Deductions? https://www.justworks.com/blog/what-are-pre-tax-deductions#what-are-pretax-deductions Accessed: 2025-02-09.  
[^8]: Equal Pay/Compensation Discrimination https://www.eeoc.gov/equal-paycompensation-discrimination Accessed: 2025-02-09.  
[^9]: A Better Way for Companies to Address Pay Gaps https://hbr.org/2024/02/a-better-way-for-companies-to-address-pay-gaps Accessed: 2025-02-09.  
