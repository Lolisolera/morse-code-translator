object InputHandler {
  def getUserInput(): String = {
    print("Enter English or Morse code (or type EXIT): ")
    scala.io.StdIn.readLine()
  }
}

