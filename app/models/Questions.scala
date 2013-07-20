package models

case class Questions() {
  private var currentQuestionOption : Option[String] = None
  private var currentQuestionChoicesOption : Option[List[String]] = None
}

object Questions {
  def setCurrentQuestion(qObj: Questions, question: String) = {
    qObj.currentQuestionOption = Some(question)
    qObj.currentQuestionChoicesOption = Some(Nil)
  }
  def getCurrentQuestion(qObj: Questions) = {
    qObj.currentQuestionOption
  }
  
  def getCurrentChoices(qObj: Questions) = {
    qObj.currentQuestionChoicesOption
  }
  
  def addChoiceToCurrentQuestion(qObj: Questions, answer: String) = {
    qObj.currentQuestionChoicesOption = qObj.currentQuestionChoicesOption match {
      case None => Some(List(answer))
      case Some(existingAnswers) => Some(existingAnswers :+ answer)
    }
    qObj.currentQuestionChoicesOption
  }
}