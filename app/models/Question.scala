package models

case class Question() {
  private var questionTextOption : Option[String] = None
  private var questionChoicesOption : Option[List[String]] = None
  def setQuestionText(question: String) = {
    questionTextOption = Some(question)
    questionChoicesOption = Some(Nil)
  }
  def getQuestionText() = {
    questionTextOption
  }
  
  def getChoices() = {
    questionChoicesOption
  }
  
  def addChoice(answer: String) = {
    questionChoicesOption = questionChoicesOption match {
      case None => Some(List(answer))
      case Some(existingAnswers) => Some(existingAnswers :+ answer)
    }
    questionChoicesOption
  }
}

object Question {
  lazy val currentQuestion: Question = new Question
  def getCurrentQuestion: Question = {
    currentQuestion
  }
}