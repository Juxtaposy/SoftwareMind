# SoftwareMind
Software Mind task

# Description
This is console program to evenly distribute players between teams.
User can either use the predefined data or provide custom data through console
when prompted.

# Setup - IntelliJ IDE
Project built using IntelliJ IDE Community Edition.

Import the project and run Main from SoftwareMind/src/main/java/mind folder.

To run Tests in SoftwareMind/test/java add JUnit 4 dependency in pom.xml file.
Configuration pom.xml file is provided, it shouldn't be necessary.

# Setup - Command line
Navigate to /SoftwareMind/src/main/java folder.

Compile using: javac mind/Main.java

Run using: java mind.Main

Running tests from command line is not recommended as it requires providing
JUnit.jar file. 

# How to use
On startup, program asks for data control value: '1' or '2'.

Choosing '1' will use predefined data and display the result.

Choosing '2' will ask the user to provide:

Number of People to use for calculations.

Number of Teams to use for calculations.

Then each Person will require: 1) Name 2) Rate

Input is checked for correct format. Use comma (.) separated values for
decimal numbers.

After data is provided, result is calculated and displayed.

In the end, program finishes and closes.

# Created by:
Mateusz Gawroński