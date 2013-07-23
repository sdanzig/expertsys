package test

import org.specs2.Specification
import models.Question._

class QuestionAcceptanceSpec extends Specification { def is = s2"""
    Test question display

    getCurrentQuestion should
      with no question added, have text of None 					       $e1
      with no question added, have choices of None 					       $e2
      with first question added, respond with that question                $e3
      handle question added and no answers                                 $e4
      handle question added and one answer                                 $e5
      handle question added with two answers                               $e6      
                                                                           """
  def e1 = {
    getCurrentQuestion.getQuestionText must beNone
  }
  def e2 = {
    getCurrentQuestion.getChoices must beNone
  }
  def e3 = {
    getCurrentQuestion.setQuestionText("Are you organizing data?")
    val qText = getCurrentQuestion.getQuestionText
    qText must beSome("Are you organizing data?")
  }
  def e4 = {
    getCurrentQuestion.setQuestionText("Are you organizing data?")
    getCurrentQuestion.getChoices must beSome(Nil)
  }
  def e5 = {
    getCurrentQuestion.setQuestionText("Are you organizing data?")
    getCurrentQuestion.addChoice("Yes")
    getCurrentQuestion.getChoices must beSome(List("Yes"))
  }
  def e6 = {
    getCurrentQuestion.setQuestionText("Are you organizing data?")
    getCurrentQuestion.addChoice("Yes")
    getCurrentQuestion.addChoice("No")
    val choicesOpt = getCurrentQuestion.getChoices
    choicesOpt must beSome and {
      val list = choicesOpt.get
      (list must have size(2)) and
      (list must beEqualTo(List("Yes","No")))
    }
  }
}