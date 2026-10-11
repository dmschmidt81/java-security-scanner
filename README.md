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

## Risk-Scoring Philosophy
A central design principle of this project is:
One suspicious indicator is not proof of malicious behavior.

Individual capabilities may be completely legitimate.
For example, networking, file access, JavaScript, Python, or executable-file references are not inherently malicious.
The scanner will eventually assign greater significance when multiple behaviors appear together.
Example:

network capability        → low-weight indicator
network connection        → stronger indicator
download/save behavior    → additional risk
process execution         → stronger risk
download → save → execute → high-interest behavior chain

This approach is intended to reduce false positives and provide an explanation for why a file received a particular risk score.
## Planned Development
Future milestones include:
- Read source files line by line
- Detect Java-specific security indicators
- Assign weighted risk scores
- Explain why each risk point was added
- Distinguish capability from actual activity
- Detect connected behavior sequences
- Add JavaScript scanning
- Add Python scanning
- Add PowerShell scanning
- Separate language-specific scanners from the shared scoring engine
- Analyze network destinations and ports
- Detect suspicious file-writing and process-execution patterns
- Improve false-positive handling
- Add logging and scan reports
- Develop increasingly realistic security test cases
##Long-Term Goal
The long-term goal is to develop this into a multi-language static-analysis security tool capable of examining source code and identifying meaningful combinations of potentially risky behavior.
Rather than simply searching for dangerous-looking words, the project will increasingly focus on:
What capability exists?

What activity actually occurs?

Where does data come from?

Where does the data go next?

Are several risky behaviors connected?

## Technologies
- Java
- Java standard library
- Visual Studio Code
- Git
- GitHub
Additional libraries and technologies will be introduced as the scanner becomes more sophisticated.
Status
## Early development
The project currently has the initial application structure and file-type detection system in place. Source-code content scanning is the next major feature under development.
## Author
David Schmidt
High school computer science and technology educator transitioning into professional software development, with current focus areas including Java, COBOL, web development, and cybersecurity.
I especially like the **“build evidence”** section for this project. It captures the security philosophy you’ve already developed: your scanner shouldn’t scream *malware* because it sees `.exe`, `Socket`, or JavaScript; it should analyze what those capabilities are actually being used to do.
I especially like the **“build evidence”** section for this project. It captures the security philosophy you’ve already developed: your scanner shouldn’t scream *malware* because it sees `.exe`, `Socket`, or JavaScript; it should analyze what those capabilities are actually being used to do.
