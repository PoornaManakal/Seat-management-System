# ✈️ Seat Management System

---

## 📖 Introduction

This is a **Seat Management System** designed for managing seat bookings in an airplane. It runs in the console with an interactive menu-based interface.
The Seat Management System allows users to :

- Book seats based on row and seat number.
- Cancel booked seats.
- View seat layout to check availability.
- Find the first available seat.
- Search for ticket details by seat.
- Display all tickets along with the total sales.

---

## ✨ Features

-  Input validation to prevent invalid rows, seat numbers, and incorrect data types.
-  Seat availability tracking across four rows (A, B, C, D).
-  Ticket creation with customer details (Name, Surname, Email).
-  Dynamic pricing based on seat number:
  - Seats 1–5: `$200`
  - Seats 6–9: `$150`
  - Seats 10 and above: `$180`
-  Ticket search functionality.
-  Total sales summary.

---

## 🚀 How to Run

### Requirements:
- Java Development Kit (JDK) 8 or higher

### Steps:
1. Clone the repository:
   
   ```bash
   git clone https://github.com/PoornaManakal/Seat-management-System.git
   ```
   
2. Open the project in your Java IDE (IntelliJ, Eclipse, NetBeans, etc.) or run it via the terminal.
   
3. Compile the Java files:

   ```bash
   javac Main.java Person.java Ticket.java
   ```
   
4. Run the program:
   
   ```bash
   java Main
   ```
   
5. Follow the console menu prompts.

---

##  Program Structure

| File                  | Description                                  |
|-----------------------|----------------------------------------------|
| `Main.java`             | Main logic with menu, booking, canceling    |
| `Person.java`         | Handles user details (name, surname, email)|
| `Ticket.java`| Ticket management with seat and price info |
| `README.md`           | Project documentation                       |

---

##  Example

```bash
-----------------------------------------------------
-    Welcome to the Plane Management application    -
-----------------------------------------------------

*****************************************************
*                   MENU OPTIONS                    *
*****************************************************
   01. Buy a Seat
   02. Cancel a Seat
   03. Find First Available Seat
   04. Show Seat Planning
   05. Print ticket information and total sales
   06. Search ticket
   00. Quit
*****************************************************
Please select an option : 1
```


