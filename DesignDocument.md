# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.


## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a class diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)
classDiagram

```mermaid
classDiagram
    IEmployee <|-- HourlyEmployee: implements(is a)
    IEmployee <|-- SalaryEmployee: implements(is a)
    ITimeCard <|-- TimeCard: implements(is a)
    IPayStub <|-- PayStub: implements(is a)

    HourlyEmployee --> PayStub: has a
    SalaryEmployee --> PayStub: has a

    Builder --> ITimeCard:uses
    Builder --> IEmployee:uses
    

    PayrollGenerator --> Builder:uses
    PayrollGenerator --> FileUtil:uses
    PayrollGenerator --> Arguments:uses
    PayrollGenerator --> IEmployee:uses
    PayrollGenerator --> ITimeCard:uses
    PayrollGenerator --> IPayStub:uses
    PayrollGenerator --> HourlyEmployee:uses
    PayrollGenerator --> SalaryEmployee:uses

    PayrollGenerator --|> Arguments : contains (static final)
    

    class IEmployee {
        <<interface>>
        + getName() String
        + getID() String
        + getPayRate() double
        + getEmployeeType() String
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + runPayroll(hoursWorked:double) IPayStub
        + toCSV() String
    }


    class ITimeCard {
        <<interface>>
        + getEmployeeId() String
        + getHoursWorked() double
    }


    class IPayStub {
        <<interface>>
        + getPay() double
        + getTaxesPaid() double
        + toCSV() String
    }


    class PayStub {
    - tax: double
    - name: String
    - netPay: double
    + PayStub(String, double, double, double, double)
    + getName() String
    + getPay() double
    + getTaxesPaid() double
    + toCSV() String
    }


    class TimeCard {
        - id: String
        - hoursWorked: double
        + TimeCard(id: String, hoursWorked: double)
        + getEmployeeID() String
        + getHoursWorked() double
        + toString() String
    }


    class SalaryEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + SalaryEmployee(String, String, double, double, double, double)
        + getName() String
        + getID() String
        + getPayRate() double
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + getEmployeeType() String
        + runPayroll(hoursWorked: double) IPayStub
        + toCSV() String
    }


    class HourlyEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + HourlyEmployee(String, String, double, double, double, double)
        + getName() String
        + getID() String
        + getPayRate() double
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + getEmployeeType() String
        + runPayroll(hoursWorked: double) IPayStub
        + toCSV() String
    }


    class FileUtil {
    + static EMPLOYEE_HEADER: String
    + static PAY_STUB_HEADER: String
    - FileUtil()
    + static readFileToList(file: String) List<String>
    + static writeFile(outFile: String, lines: List<String>) void
    + writeFile(outFile: String, lines: List<String>, backup: boolean) void
    }


    class PayrollGenerator {
    - static DEFAULT_EMPLOYEE_FILE: String
    - static DEFAULT_PAYROLL_FILE: String
    - static DEFAULT_TIME_CARD_FILE: String
    - PayrollGenerator()
    + main(args: String[]) void
    }


    class Builder {
        - Builder()
        + static buildEmployeeFromCSV(csv: String) IEmployee
        + static buildTimeCardFromCSV(csv: String) ITimeCard
    }


    class Arguments {
        <<static>>
        - employeeFile: String
        - payrollFile: String
        - timeCards: String
        - Arguments()
        + getEmployeeFile() String
        + getPayrollFile() String
        + getTimeCards() String
        + printHelp() void
        + static process(args: String[]) Arguments
    }


```





## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `Employee` class properly returns `name` from `getName()`.
2. Test that the `Employee` class properly returns `id` from `getId()`.
3. Test that the `Employee` class properly returns `payRate` from `getpayRate()`, returns `YTDEarnings` from `getYTDEarnings()`, returns `YTDTaxesPaid` from `getYTDTaxesPaid()`.
4. Test that the `Employee` class properly returns `PretaxDeductions` from `getPretaxDeductions()`, returns `EmployeeType` from `getEmployeeType()`, returns `payStub` from `runPayroll()`, returns CSV String representing the employee from `toCSV()`.
5. Test that the `PayStub` class properly returns `Pay` from `getPay()`, returns `Taxes` from `getTaxes()`, returns CSV String representing the `PayStub` from `toCSV()`.
6. Test that the `Builder` class properly returns `Employee` object from `buildEmployeeFromCSV()`, returns `TimeCard` object from `buildTimeCardFromCSV()`.
7. Test that the `TimeCard` class properly returns `Id` from `getId()`, returns `hoursWorked` from `getHoursWorked()`, returns String representing the `TimeCard` from `toString()`.
8. Test that the `PayrollGenerator` class properly returns PayStub CSV which meets expectation, such as input `PayStub`(HOURLY,Luffy,s192,30.00,0,20000,4530), `TimeCard`(s192,45), and we can get the result of (HOURLY,Luffy,s192,30.0,0.0,21102.24,4852.76) and (Luffy,1102.24,322.76,21102.24,4852.76).



## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect.
```mermaid
classDiagram



    IEmployee <|-- HourlyEmployee: implements(is a)
    IEmployee <|-- SalaryEmployee: implements(is a)
    ITimeCard <|-- TimeCard: implements(is a)
    IPayStub <|-- PayStub: implements(is a)

    HourlyEmployee --> PayStub: has a
    SalaryEmployee --> PayStub: has a

    Builder --> ITimeCard:uses
    Builder --> IEmployee:uses
    Builder --> SalaryEmployee:uses
    Builder --> HourlyEmployee:uses

    PayrollGenerator --> Builder:uses
    PayrollGenerator --> FileUtil:uses
    PayrollGenerator --> Arguments:uses
    PayrollGenerator --> IEmployee:uses
    PayrollGenerator --> ITimeCard:uses
    PayrollGenerator --> IPayStub:uses

    PayrollGenerator --|> Arguments : contains (static final)
    PayrollGenerator --> Arguments : uses

    class IEmployee {
        <<interface>>
        + getName() String
        + getID() String
        + getPayRate() double
        + getEmployeeType() String
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + runPayroll(hoursWorked:double) IPayStub
        + toCSV() String
    }




    class ITimeCard {
        <<interface>>
        + getEmployeeId() String
        + getHoursWorked() double
    }


    class IPayStub {
        <<interface>>
        + getPay() double
        + getTaxesPaid() double
        + toCSV() String
    }


    class PayStub {
    - tax: double
    - name: String
    - netPay: double
    - ytdE: double
    - ytdT: double
    + PayStub(String, double, double, double, double)
    + getName() String
    + getPay() double
    + getTaxesPaid() double
    + getYtdE() double
    + getYtdT() double
    + toCSV() String
    }


    class TimeCard {
        - id: String
        - hoursWorked: double
        + TimeCard(id: String, hoursWorked: double)
        + getEmployeeID() String
        + getHoursWorked() double
        + toString() String
    }


    class SalaryEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + SalaryEmployee(String, String, double, double, double, double)
        + getName() String
        + getID() String
        + getPayRate() double
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + getEmployeeType() String
        + runPayroll(hoursWorked: double) IPayStub
        + toCSV() String
    }


    class HourlyEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + HourlyEmployee(String, String, double, double, double, double)
        + getName() String
        + getID() String
        + getPayRate() double
        + getYTDEarnings() double
        + getYTDTaxesPaid() double
        + getPretaxDeductions() double
        + getEmployeeType() String
        + runPayroll(hoursWorked: double) IPayStub
        + toCSV() String
    }


    class FileUtil {
    + static EMPLOYEE_HEADER: String
    + static PAY_STUB_HEADER: String
    - FileUtil()
    + static readFileToList(file: String) List<String>
    + static writeFile(outFile: String, lines: List<String>) void
    + writeFile(outFile: String, lines: List<String>, backup: boolean) void
    }


    class PayrollGenerator {
    - static DEFAULT_EMPLOYEE_FILE: String
    - static DEFAULT_PAYROLL_FILE: String
    - static DEFAULT_TIME_CARD_FILE: String
    - PayrollGenerator()
    + main(args: String[]): void
    }


    class Builder {
        - Builder()
        + static buildEmployeeFromCSV(csv: String) IEmployee
        + static buildTimeCardFromCSV(csv: String) ITimeCard
    }


    class Arguments {
        <<static>>
        - employeeFile: String
        - payrollFile: String
        - timeCards: String
        - Arguments()
        + getEmployeeFile() String
        + getPayrollFile() String
        + getTimeCards() String
        + printHelp() void
        + static process(args: String[]) Arguments
    }

```


> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.





## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two.  
- What were some major changes, and why you made them?  
  Firstly, I let PayrollGenerator use HourlyEmployee and SalaryEmployee class to call runPayroll method and let Builder use interface IEmployee.
  Finally, in PayrollGenerator, interface IEmployee is used while in Builder, specific classes are used. Also, according to the parameter in PayStub, beside the method in interface, I added new methods, like getYtdEarnings() to the class.
  This is because in PayrollGenerator, the execution(read employee and call runPayRoll method) is nothing about the the exact kind of employee, but in Builder, to build employee into list for pay calculation, the type of employee is necessary.
- What did you learn from this process?  
  When deciding to use an interface or a specific class, it is important to see if such specification is necessary there or not. Also, not just following the interface, when creating class, more detailed points should be considered based on the whole project.
- What would you do differently next time?   
  When deciding to use an interface or a specific class, I will see if such specification is necessary there and follow the principle of flexibility, maintainability, and scalability. Also, not just following the interface when creating class, more detailed points should be considered based on the whole project.
- What was the most challenging part of this process?   
  It is to find the relationship between interface and class, class and class according to the code provided.
