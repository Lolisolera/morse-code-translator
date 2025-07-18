import scala.util.control.Breaks._

object Main extends App {
  println("Welcome to the Morse Code Translator!")
  println("You can enter English (e.g., HELLO) or Morse code (e.g., .... . .-.. .-.. ---).")
  println("When entering Morse code, use '/' to separate words (e.g., .... . .-.. .-.. --- / .-- --- .-. .-.. -..).")
  println("Type EXIT to quit.")


  breakable {
    while (true) {
      val input = InputHandler.getUserInput()
      if (input.trim.toUpperCase == "EXIT") break

      val output =
        if (input.contains(".") || input.contains("-"))
          Translator.morseToEnglish(input)
        else
          Translator.englishToMorse(input)

      output match {
        case Right(result) => OutputHandler.printResult(result)
        case Left(error)   => OutputHandler.printError(error)
      }
    }
  }
}

