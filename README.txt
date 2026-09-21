HEALTHFIRST PHARMACY INVENTORY MANAGEMENT SYSTEM
=================================================

PROJECT NAME:
HealthFirstPIMS

DESCRIPTION:
HealthFirstPIMS is a Java desktop Pharmacy Inventory Management System
developed using Java Swing, JDBC and MySQL.

The system provides role-based access for Administrators and Cashiers.

-------------------------------------------------
DEFAULT LOGIN CREDENTIALS
-------------------------------------------------

ADMINISTRATOR
Username: admin
Password: admin123

CASHIER
Username: cashier
Password: cash123

-------------------------------------------------
ADMINISTRATOR FEATURES
-------------------------------------------------

- Manage medicines
- Add, update and delete medicines
- Manage suppliers
- Add, update and delete suppliers
- Manage Cashier user accounts
- View Sales Report
- View Item-Wise Report
- View Low Stock Report
- View Expiry Report

-------------------------------------------------
CASHIER FEATURES
-------------------------------------------------

- Point of Sale (POS)
- Add medicines to shopping cart
- Remove items from cart
- Clear shopping cart
- Process checkout
- Automatically update medicine stock
- Generate customer bill
- Print customer bill
- Save customer bill
- Search medicine stock
- Check medicine price and availability

-------------------------------------------------
TECHNOLOGIES USED
-------------------------------------------------

- Java
- Java Swing
- JDBC
- MySQL
- Apache NetBeans IDE

-------------------------------------------------
DATABASE
-------------------------------------------------

Database Name: healthfirst_pims

The database.sql file is included with the project.
It contains the database structure, tables and sample data.

Tables:
- users
- suppliers
- medicines
- sales
- sale_items

-------------------------------------------------
HOW TO RUN THE PROJECT
-------------------------------------------------

1. Install MySQL Server.
2. Open MySQL Workbench.
3. Import and execute the included database.sql file.
4. Make sure the healthfirst_pims database has been created.
5. Open the HealthFirstPIMS project in Apache NetBeans.
6. Make sure MySQL Connector/J is included in the project libraries.
7. Make sure MySQL Server is running.
8. Run the HealthFirstPIMS project.
9. Log in using one of the default accounts shown above.

-------------------------------------------------
GITHUB
-------------------------------------------------

Repository:
https://github.com/SethGov10/HealthFirstPIMS

-------------------------------------------------
NOTES
-------------------------------------------------

Administrators have access to management and reporting functions.

Cashiers have access to Point of Sale and Stock Check functions.
Cashiers cannot add, edit or delete medicines.