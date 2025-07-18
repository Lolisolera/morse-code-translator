object OutputHandler {
  def printResult(result: String): Unit = {
    println(s"Translated: $result")
  }

  def printError(message: String): Unit = {
    Console.err.println(s"Error: $message")
  }

  def printMorseLegend(): Unit = {
    println()
    println("📘 Morse Code Guide:")
    println("A: .-     B: -...   C: -.-.   D: -..    E: .     F: ..-.")
    println("G: --.    H: ....   I: ..     J: .---   K: -.-    L: .-..")
    println("M: --     N: -.     O: ---    P: .--.   Q: --.-   R: .-.")
    println("S: ...    T: -      U: ..-    V: ...-   W: .--    X: -..-")
    println("Y: -.--   Z: --..")
    println()
    println("Use '/' to separate words when entering Morse code.")
    println()
  }
}


