package controllers

import play.api._
import play.api.mvc._
import models.Question._

object Questions extends Controller {
  
  def question = Action {
    // for a given session, get the current question
    val text = getCurrentQuestion.getQuestionText.getOrElse("No question set.")
    val choices = getCurrentQuestion.getChoices.getOrElse(Nil)
    Ok(views.html.question(text, choices))
  }
  
  def makeChoice = Action {
    Ok
  }
}