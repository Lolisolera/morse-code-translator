# Morse Code Translator – Scala CLI App

A modular Scala command-line application that translates between English and Morse code.

## Features

- Translate **English → Morse**
- Translate **Morse → English**
- Follows spacing rules:
  - One space between Morse characters:  
    `.... . .-.. .-.. ---`
  - `/` between words:  
    `.... . .-.. .-.. --- / .-- --- .-. .-.. -..`
- Functional, testable, and beginner-friendly code structure

## Project Structure

- `InputHandler`: Reads and validates user input from the command line
- `OutputHandler`: Displays translated output to the user
- `Translator`: Contains the core logic for both translations (pure functions)
- `MorseCode`: Stores the Morse code map as `Map[Char, String]`

## Example

```text
Input: Hello World  
Output: .... . .-.. .-.. --- / .-- --- .-. .-.. -..

Input: .... . .-.. .-.. --- / .-- --- .-. .-.. -..  
Output: HELLO WORLD
```

## 🧪 Testing

This project uses **ScalaTest** to verify functionality.

### What’s Tested

- English → Morse translation
- Morse → English translation
- Word separation using `/`
- Handling of invalid or unsupported characters


## 💡 Bonus Features

These enhancements go beyond the core functionality and are optional additions:

- **Auto-detect input type** (Morse vs English)  
  Automatically decide whether the input is Morse code or plain text.

- **Loop until `"exit"` is typed**  
  Keep prompting the user until they choose to quit the application.

- **Optional punctuation support**  
  Extend the Morse code map to support symbols like `. , ? !` and more.


## Morse Code Mapping Example

The core translation map used in the application:

```scala
val morseCode: Map[Char, String] = Map(
  'A' -> ".-",   'B' -> "-...", 'C' -> "-.-.", 'D' -> "-..",
  'E' -> ".",    'F' -> "..-.", 'G' -> "--.",  'H' -> "....",
  'I' -> "..",   'J' -> ".---", 'K' -> "-.-",  'L' -> ".-..",
  'M' -> "--",   'N' -> "-.",   'O' -> "---",  'P' -> ".--.",
  'Q' -> "--.-", 'R' -> ".-.",  'S' -> "...",  'T' -> "-",
  'U' -> "..-",  'V' -> "...-", 'W' -> ".--",  'X' -> "-..-",
  'Y' -> "-.--", 'Z' -> "--..", ' ' -> "/"
)
```

## Author

**Lola Marquez**  
GitHub: [@Lolisolera](https://github.com/Lolisolera)