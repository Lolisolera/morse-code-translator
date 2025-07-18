object OutputHandler {
  def printResult(result: String): Unit = {
    println(s"Translated: $result")
  }

  def printError(message: String): Unit = {
    Console.err.println(s"Error: $message")
  }
}

