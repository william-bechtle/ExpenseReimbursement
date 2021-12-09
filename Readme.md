# **EXPENSE REIMBURSEMENT**

## **Project Description**
Expense Reimbursement web application that allows employees to submit a reimbursement request and view all of their reimbursement requests, and have a calculator to add up costs.

## **Technologies Used**
Hibernate - Version 5.6.1.Final

mysql-connector-java - Version 8.0.27

junit - Version 4.11

javax.servet - Version 2.5

Tomcat - Version 8.5.72

HTML5 - Version 5

JavaScript - Version ES2015

CSS - Version 3

Java - Version 17

## **Features**

Register

Login 

Log Out

Navigation Bar 

### **Manager**

View list of all reimbursement requests, with option to approve or deny certain requests.

Calculator, to add up reimbursements.

### **Employee**

View list of all their reimbursement requests and the status of those requests. (Approved, Denied, Pending)

Submit new reimbursement request, (app verifies to make sure information entered is correct).

Calculator, to add up expenses. 

#### **To-do list:**

Allow employees to transfer money to eachother.

Allow manager to remove employees from the system.

Allow manager to add new employees manually, instead of having them sign up.

Allow manager to flag a reimbursement request as susipicous, which sends an alert to the employee warning them not to do that again.

Allow manager to revoke an employee's access to submitting reimbursement requests.


## **Getting Started**
Install git from this link: https://git-scm.com/download/win

Run the command in the command line: $ git clone https://github.com/william-bechtle/ExpenseReimbursement/

install MySQL: https://dev.mysql.com/downloads/installer/

Login to MySQL with: $ mysql -u USERNAME -p PASSWORD
  
Create MySQL database with: $ CREATE DATABASE revature
  
Switch to the database with: $ use revature
  
Run these 2 commands to create two tables: 

create table employee (id int PRIMARY KEY AUTO_INCREMENT, age int, gender varchar(255), password varchar(255), username varchar(255) UNIQUE);

create table transactions (id int PRIMARY KEY AUTO_INCREMENT, amount DECIMAL(10,2), approved int, reason varchar(255), username varchar(255));

Open the GitHub repo in Maven or Ecplipse.

Go into src.main.resources.hibernate.cfg.xml and edit the username and password properties to match your database.

Add a TomCat Run configuration with the Version listed above. Set the deployment directory to the webapp folder in the project, set the context path to /ExpenseReimbursement, set the Server Port to 8081, and the admin port to 8005.

Build the project, this will download all necessary dependencies. 

Run the project with the TomCat run configuration.
![image](https://user-images.githubusercontent.com/93163143/145493295-04528dea-28d9-47cb-a83e-9b9e568971d2.png)


  

  




## **Usage**
Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

