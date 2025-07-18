object InputHandler {
  def getUserInput(): String = {
    print("Enter English or Morse code (type HELP for guide, or EXIT to quit): ")
    scala.io.StdIn.readLine()
  }
}

