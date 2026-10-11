# Java Security Scanner

A Java-based security scanning project designed to analyze source-code files, identify potentially risky capabilities and behaviors, and eventually assign contextual risk scores based on combinations of indicators.

This project is being built incrementally as part of my software development and cybersecurity training.

## Current Features

The scanner currently:

- Accepts a source file for analysis
- Detects the file extension
- Identifies supported source-code types
- Uses an initial risk-scoring structure
- Separates the application runner from the scanner logic

Current file types being explored include:

- Java (`.java`)
- JavaScript (`.js`)
- Python (`.py`)

## Project Structure

```text
java-security-scanner/
├── examples/
│   └── Testfile.java
├── src/
│   └── security/
│       ├── SecurityApp.java
│       └── SecurityAppRunner.java
├── out/
├── .gitignore
├── .vscode/
│   └── settings.json
└── README.md

SecurityAppRunner starts the application.
SecurityApp contains the scanning and analysis logic.
The examples directory contains harmless source files used to test scanner behavior.
The out directory contains compiled Java files and is excluded from Git tracking.
Current Development Goal
The next phase is to move beyond file-extension detection and begin analyzing the actual contents of source files.
The scanner will initially look for behaviors such as:
file reading
network capability
network connections
data receiving
file creation/saving
process execution
script execution

The goal is not to classify a file as malicious because of one keyword.
Instead, the scanner will build evidence.
For example:

Socket import
    ↓
Network capability

Socket creation
    ↓
Network activity

Network data received
    ↓
File written

File executed
    ↓
Higher-risk behavior chain

