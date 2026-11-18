# ProgExam

## Question 1

```bash
cd QUESTION1
javac *.java
java MattressSalesReport
```

Enter the nine monthly sales figures individually when prompted.

## Question 2

```bash
cd "QUESTION 2"
javac IProductCalculations.java ProductCalculations.java ProductApp.java
java ProductApp
```

The Swing application requires a graphical desktop environment. Successful compilation does not guarantee a window will appear in a terminal-only Codespace. Sales are appended to `data.txt` in the current working directory.

## JUnit 5 tests

```bash
curl -L -o junit-platform-console-standalone-1.11.4.jar https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
javac -cp .:junit-platform-console-standalone-1.11.4.jar IProductCalculations.java ProductCalculations.java ProductCalculationsTest.java
java -jar junit-platform-console-standalone-1.11.4.jar execute --class-path . --select-class ProductCalculationsTest
```
