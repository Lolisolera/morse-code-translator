object Translator {
  def englishToMorse(input: String): Either[String, String] = {
    val result = input.toUpperCase.flatMap {
      case c if MorseCode.morseCode.contains(c) =>
        MorseCode.morseCode(c) + " "
      case c => return Left(s"Unsupported character: '$c'")
    }
    Right(result.trim.replaceAll(" / ", " / "))
  }

  def morseToEnglish(input: String): Either[String, String] = {
    val words = input.trim.split(" / ")
    val translatedWords = words.map { word =>
      word.split(" ").map { symbol =>
        MorseCode.inverseMorseCode.getOrElse(symbol, '?')
      }.mkString
    }
    Right(translatedWords.mkString(" "))
  }
}
