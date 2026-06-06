# MediTrack - Hospital Management System

## Overview

MediTrack is a console-based Hospital Management System developed in Java to demonstrate strong understanding of:

* Core Object-Oriented Programming
* Advanced Java Concepts
* Collections Framework
* Exception Handling
* Design Patterns
* Java Streams & Lambdas
* File Handling & Persistence
* Menu-Driven Console Applications

The project follows a modular package-based architecture and demonstrates industry-standard coding practices.

---

# Features

## Core Features

### Doctor Management

* Add Doctor
* View Doctors
* Search Doctor by Name
* Filter Doctors by Specialization
* Delete Doctor

### Patient Management

* Add Patient
* View Patients
* Search Patient by Name
* Delete Patient

### Appointment Management

* Create Appointment
* View Appointments
* Cancel Appointment
* Appointment Status Tracking

### Billing System

* Generate Hospital Bills
* Multiple Billing Strategies
* Tax Calculation
* Insurance Billing Support

---

# Implemented OOP Concepts

## Encapsulation

* Private fields
* Getter methods
* Controlled data access

## Inheritance

```text
Person
 ├── Doctor
 └── Patient
```

## Polymorphism

* Method Overriding
* Dynamic Method Dispatch

## Abstraction

* BillingStrategy Interface
* Service-based architecture

## Advanced OOP

* Cloneable implementation
* Immutable class (`BillSummary`)
* Enums (`AppointmentStatus`)
* Singleton Design Pattern

---

# Design Patterns Implemented

## Singleton Pattern

Used for:

* `AppConfig`
* `IdGenerator`

### Types Demonstrated

* Eager Singleton
* Lazy Singleton

---

## Factory Pattern

Used in:

* `BillFactory`

Purpose:

* Dynamically returns billing strategy objects.

---

## Strategy Pattern

Used in:

* Billing System

Strategies:

* Normal Billing
* Insurance Billing

---

## Observer Pattern

Used for:

* Appointment Notifications

Implementation:

* `ConsoleNotifier`

---

# Java Streams & Lambdas

Implemented analytics using Streams API.

## Features

* Calculate average doctor fee
* Filter doctors by specialization
* Lambda expressions
* Stream pipelines

File:

```text
DoctorAnalytics.java
```

---

# File I/O & Persistence

Implemented CSV-based persistence.

## Features

* Save Doctor data
* Load Doctor data
* CSV Parsing
* `String.split(",")`
* Try-with-resources

File:

```text
CSVUtil.java
```

---

# Project Structure

```text
src/
└── com/
    └── airtribe/
        └── meditrack/
            ├── entity/
            ├── service/
            ├── util/
            ├── billing/
            ├── factory/
            ├── observer/
            ├── analytics/
            └── Main.java
```

---

# Packages

## entity

Contains:

* Person
* Doctor
* Patient
* Appointment
* Bill
* AppointmentStatus

---

## service

Contains business logic:

* DoctorService
* PatientService
* AppointmentService

---

## util

Contains utility/helper classes:

* CSVUtil
* AppConfig
* IdGenerator

---

## billing

Contains Strategy Pattern implementations:

* BillingStrategy
* NormalBilling
* InsuranceBilling

---

## factory

Contains:

* BillFactory

---

## observer

Contains:

* ConsoleNotifier

---

## analytics

Contains:

* DoctorAnalytics

---

# Technologies Used

* Java
* OOP
* Java Collections Framework
* Java Streams API
* File I/O
* IntelliJ IDEA

---

# Compile Instructions

## Compile

```bash
javac -d out src/com/airtribe/meditrack/**/*.java src/com/airtribe/meditrack/*.java
```

---

# Run Instructions

```bash
java -cp out com.airtribe.meditrack.Main
```

---

# Sample Menu

```text
===== MEDITRACK =====

1. Add Doctor
2. Add Patient
3. Create Appointment
4. View Doctors
5. View Patients
6. Generate Bill
7. Search Doctor
8. Search Patient
9. View Appointments
10. Cancel Appointment
11. Average Doctor Fee
12. Filter Doctors
13. Save Doctors CSV
14. Load Doctors CSV
15. Exit
```

---

# Example Functionalities

## Add Doctor

Stores doctor details in memory using collections.

## Generate Bill

Uses Strategy + Factory Pattern to generate bills dynamically.

## Appointment Notification

Observer Pattern sends console reminders.

## Analytics

Streams API computes:

* Average fee
* Specialized doctor filtering

---

# Learning Outcomes

This project demonstrates understanding of:

* Java Fundamentals
* JVM Basics
* OOP Principles
* Design Patterns
* Collections Framework
* Exception Handling
* Streams & Lambdas
* File Persistence
* Console Application Development

---

# Future Improvements

Possible future enhancements:

* GUI using JavaFX/Swing
* Database Integration (MySQL)
* REST API Backend
* Spring Boot Migration
* User Authentication
* AI-based Doctor Recommendation
* Auto Appointment Scheduling

---

# Author

Developed as part of Java OOP & System Design learning.
