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
  
Run these 3 commands to create two tables and insert a necessary account: 

1. $ create table employee (id int PRIMARY KEY AUTO_INCREMENT, age int, gender varchar(255), password varchar(255), username varchar(255) UNIQUE);

2. $ create table transactions (id int PRIMARY KEY AUTO_INCREMENT, amount DECIMAL(10,2), approved int, reason varchar(255), username varchar(255));

3. $ insert into employee (age,gender,password,username) VALUES (50,"Male","pass","wjbechtle@gmail.com");

Open the GitHub repo in Maven or Ecplipse.

Go into src.main.resources.hibernate.cfg.xml and edit the username and password properties to match your database.

Add a TomCat Run configuration with the Version listed above. Set the deployment directory to the webapp folder in the project, set the context path to /ExpenseReimbursement, set the Server Port to 8081, and the admin port to 8005.

Build the project, this will download all necessary dependencies. 

Run the project with the TomCat run configuration.
![image](https://user-images.githubusercontent.com/93163143/145493295-04528dea-28d9-47cb-a83e-9b9e568971d2.png)


## **Usage**

### Go to http://localhost:8081/ExpenseReimbursement/home to see the login screen, you do not have an account, so click New User.
![image](https://user-images.githubusercontent.com/93163143/145493566-f34a6dc1-b405-4e1d-be00-0de79b8ea3a0.png)

### After clicking, the register screen should show like below, enter the info and click Sign Up: 
![image](https://user-images.githubusercontent.com/93163143/145493737-e82505b8-fefc-4f44-aa3e-557223fbae2d.png)

### A screen will show with your information (below), click login and enter your username and password:
![image](https://user-images.githubusercontent.com/93163143/145494028-433cf187-a959-4162-acb9-4f04a6c515a5.png)

### You will now see the menu, you can click the "Home" in the NavBar at anytime to go back to this page:
![image](https://user-images.githubusercontent.com/93163143/145494469-3d2c2fb9-ba57-4cfa-be05-84ef6b1567b3.png)

### Selection "Submit Reimbursement Request" will show this screen, enter the info, if you enter it incorrectly, it will make you do it again:
![image](https://user-images.githubusercontent.com/93163143/145494704-8a960f17-7c0b-4c38-a66a-2c717f51e4da.png)

### After submitting the request, it will bring you back to the Menu above, then you can select "List of your reimbursements" to see the reimbursement you submitted:
![image](https://user-images.githubusercontent.com/93163143/145494864-41ad9764-545c-43e0-bc78-7104fc7f7053.png)

### You can then click the home button, to return to the Menu above, clicking on calculator will show the calculator: 
![image](https://user-images.githubusercontent.com/93163143/145495020-2cc2d110-2841-4c23-adf1-6d46a02fdea2.png)

### Now click LogOut, this will return you to the login screen. Enter "wjbechtle@gmail.com" as the username, and "pass" as the password, this logs you into the "Manager" account.

### The menu will be different, the calculator still exists, but you have the other option to "List All Reimbursements":
![image](https://user-images.githubusercontent.com/93163143/145495258-340288d8-012f-4cc9-97a5-537d67787884.png)

### Clicking on that option will show you all reimbursements:
![image](https://user-images.githubusercontent.com/93163143/145495425-487e7888-2e1e-49c0-bbce-cdae300869ac.png)

### Approving or denying a request will immediately update the page with the approval status:
![image](https://user-images.githubusercontent.com/93163143/145495506-0bdc061e-95e6-4bda-9fb6-3edda4bbf840.png)




















