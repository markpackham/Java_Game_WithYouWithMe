# Java Game for WithYouWithMe - Kingdom & Farmland creator

## Game Purpose

The goal of this game is to create a kingdom and farmland which are two types of territory.

You then populate them with various villagers which are knights, farmers & blacksmiths.

You have to put your villagers in relevant buildings so farmers go in silos, stables and barns, blacksmiths in forges and blacksmith schools while knights get placed in forts.

At the end a report is generated of what you have created in your kingdom and farmland.

The main purpose is to demo in the code object-oriented programming in Java and use common Java types, methods & control flow statements.

#### Javadoc

To find the JavaDoc as well as documents related to the project creation please go to the folder - "Notes & Ideas".

## Requirements

* Code was written in Java using IntelliJ IDEA 2024.2.3 (Community Edition)
* openjdk 21.0.4 2024-07-16 LTS
* OpenJDK Runtime Environment Temurin-21.0.4+7 (build 21.0.4+7-LTS)
* OpenJDK 64-Bit Server VM Temurin-21.0.4+7 (build 21.0.4+7-LTS, mixed mode, sharing)

### Optional Requirements ###

Unit testing is being carried out via junit-jupiter-5.8.1

### Install Dependencies & Run

Obtain the code from https://github.com/markpackham/Java_Game_WithYouWithMe

The best way to edit or run the code is to install IntelliJ IDEA.
https://www.jetbrains.com/idea/


### Obsolete Repo

The code's original repo was https://github.com/markpackham/Java_WithYouWithMe before it was separated into its own project and moved into the repo https://github.com/markpackham/Java_Game_WithYouWithMe

### Usage

1) Run the Java based game.

2) Create a territory of type kingdom.

3) Create a set number of knights (0-10).

4) Assign the knights to forts that you created, when it comes to a knight you must select a weapon.

5) Create a set of blacksmiths (0-10).

6) Assign the blacksmiths to forges and blacksmith schools.

7) A report of the kingdom is generated.

8) Create a territory of type farmland.

9) Create a set of farmers (0-10).

10) Assign the farmers to barns, silos & stables (you can skip these).

11) A report of the farmland is generated. 

* All buildings have a name, a year built, numbers of windows, doors alongside 1 unique attribute.
* Often the unique attribute is selected from a list of attributes at random.
* Eg a random number is chosen or the current day of the week or number if the month impacts the result.
* So if you have a farm stable created on a Monday it will have 5 horses while if you made it on Sunday it will have 11.

12) You can type 'exit', 'quit' or 'q' at the end of the process to exit the program.


## Unfinished Aspects / Future Scope ##

1) Need to implement more Unit tests, so far only done blacksmith, blacksmith school & forge ones since they don't require
an Enum with user input for blacksmith creation.

2) A greater focus on gameplay and resource management elements:
- Inflict random famines or enemy attacks that need be mitigated by farmer & knight numbers.
- Allow for population growth as long as there are enough farmers, blacksmiths & buildings to support it.