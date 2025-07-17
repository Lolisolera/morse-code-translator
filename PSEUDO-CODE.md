# Pseudo Code – Morse Code Translator (Scala CLI App)

This file outlines the step-by-step structure, architecture, and logic for building the Morse Code Translator CLI application in Scala.

## Step 1: Project Setup

- [ ] Create a new Scala project using **SBT** in IntelliJ
- [ ] Initialize Git and push to GitHub
- [ ] Create `README.md` and `PSEUDO-CODE.md`

## Step 2: Project Architecture

Structure the project into the following files:

src/
└── main/
└── scala/
├── Main.scala
├── InputHandler.scala
├── OutputHandler.scala
├── Translator.scala
└── MorseCode.scala
└── test/
└── scala/
└── TranslatorTest.scala

## Step 3: Define Morse Code Mapping (MorseCode.scala)

### Pseudocode:
- Create an object called `MorseCode`
- Store a `Map[Char, String]` for English → Morse
- Create an inverse `Map[String, Char]` for Morse → English

## Step 4: InputHandler (InputHandler.scala)

### Responsibilities:
- Read user input from command line
- Validate the input
- Return trimmed/uppercase string

### Pseudocode:

```scala
object InputHandler {
  def getUserInput: String = {
    // Read line from stdin
    // Trim whitespace
    // Convert to uppercase
  }
}
```

## Step 5: OutputHandler (`OutputHandler.scala`)

### Responsibilities:
- Print output to terminal
- Handle messages and errors

### Pseudocode:

```scala
object OutputHandler {
  def printResult(result: String): Unit = {
    // Print translated message
  }

  def printError(message: String): Unit = {
    // Print error to stderr
  }
}
```

## Step 6: Translator (`Translator.scala`)

### Responsibilities:
- Pure functions to convert:
    - English → Morse
    - Morse → English

### Pseudocode:

```scala
object Translator {
  def englishToMorse(input: String): Either[String, String] = {
    // Split input into chars
    // Look up each char in morseCode Map
    // Join with space, separate words with "/"
    // Return Right(result) or Left(error)
  }

  def morseToEnglish(input: String): Either[String, String] = {
    // Split input into words by "/"
    // Then split each word into Morse symbols
    // Look up each Morse symbol in inverse Map
    // Join the letters and words
    // Return Right(result) or Left(error)
  }
}
```
## Step 7: Main Program (`Main.scala`)

### Responsibilities:
- Show welcome message
- Loop until user types `"exit"`
- Auto-detect input type (optional)
- Use `InputHandler`, `Translator`, and `OutputHandler`

### Pseudocode:
```scala
object Main extends App {
  // Print welcome message

  while (true) {
    val input = InputHandler.getUserInput()
    if (input == "EXIT") return

    val output = if (input.contains(".") || input.contains("-")) {
      Translator.morseToEnglish(input)
    } else {
      Translator.englishToMorse(input)
    }

    output match {
      case Right(result) => OutputHandler.printResult(result)
      case Left(error)   => OutputHandler.printError(error)
    }
  }
}
```
## Step 8: Testing (TranslatorTest.scala)
### Responsibilities:
- Unit test core functionality

- Test both translation directions

- Test handling of word separation and invalid input

- Example test pseudocode:

```scala

class TranslatorTest extends AnyFunSuite {
test("translate HELLO to Morse") {
assert(Translator.englishToMorse("HELLO") == Right(".... . .-.. .-.. ---"))
}

test("translate Morse to HELLO") {
assert(Translator.morseToEnglish(".... . .-.. .-.. ---") == Right("HELLO"))
}

test("invalid character returns Left") {
assert(Translator.englishToMorse("HI!") == Left("Invalid character: !"))
}
}
```
## Bonus Features 

These features are not part of the core MVP but can enhance the user experience and extend the app’s functionality:

- **Auto-detect input type**  
  Detect whether the user entered Morse code or English, and translate accordingly.

- **Add punctuation support**  
  Extend the `MorseCode` map to include characters like `. , ! ?` for richer translations.

- **Add a "Help" command**  
  Provide a command like `help` that explains how to use the app and shows examples.

- **Export translations to a file**  
  Allow users to save translated output into a text file for reference.

- **Loop until `"exit"` is typed**  
  Keep prompting the user for input until they type `"exit"` to gracefully quit the app.


## Functional Programming Guidelines

To align with Scala best practices and the project’s functional programming goals, follow these principles:

- **Prefer `val` over `var`**  
  Avoid mutable state. Use `val` unless mutation is absolutely necessary.

- **Keep functions pure in `Translator`**  
  Ensure all translation logic has no side effects and returns the same output for the same input.

- **Use `Option`, `Either`, or `Try` for error handling**  
  Avoid throwing exceptions or returning `null`. Prefer expressive types like `Either[String, String]` to handle success or failure.

- **Use `map`, `flatMap`, and `filter` instead of loops**  
  Embrace Scala’s collection methods and avoid imperative `for` or `while` loops where possible.

- **Keep all I/O (input/output) inside `InputHandler` and `OutputHandler`**  
  Maintain separation of concerns by keeping side effects out of core logic and tests.


## Final Checklist

Use this checklist to verify that all major parts of the Morse Code Translator project are complete:

- [ ] **Project structure set**  
  All files and folders created according to the planned architecture.

- [ ] **Core logic implemented**  
  English ↔ Morse translation works through pure functions.

- [ ] **Input/output handlers working**  
  Console input is read correctly, and results/errors are printed cleanly.

- [ ] **Unit tests pass**  
  All test cases (including edge cases) pass using ScalaTest.

- [ ] **Bonus features added**  
  Additional functionality like auto-detect, punctuation, or export included.

- [ ] **Push to GitHub**  
  Code is version-controlled, committed, and pushed to a public repo.

- [ ] **Celebrate!**  
  I've built a modular, testable, functional Scala CLI app!