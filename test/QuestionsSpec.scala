package test

import org.specs2.Specification
import models.Questions

class QuestionsAcceptanceSpec extends Specification { def is = s2"""
    Test question display

    getCurrentQuestion should
      with no question added, respond with None 					       $e1
      with first question added, respond with that question                $e2
   
    getCurrentChoices should
      handle no question added respond with None                            $e3
      handle question added and no answers                                 $e4
      handle question added and one answer                                 $e5
      handle question added with two answers                               $e6      
                                                                           """
  def e1 = {
    Questions.getCurrentQuestion(Questions()) must beNone
  }
  def e2 = {
    val qObj = Questions()
    Questions.setCurrentQuestion(qObj, "Are you organizing data?")
    val qOpt = Questions.getCurrentQuestion(qObj)
    qOpt must beSome("Are you organizing data?")
  }
  def e3 = {
    Questions.getCurrentChoices(Questions()) must beNone
  }
  def e4 = {
    val qObj = Questions()
    Questions.setCurrentQuestion(qObj, "Are you organizing data?")
    Questions.getCurrentChoices(qObj) must beSome(Nil)
  }
  def e5 = {
    val qObj = Questions()
    Questions.setCurrentQuestion(qObj, "Are you organizing data?")
    Questions.addChoiceToCurrentQuestion(qObj,"Yes")
    Questions.getCurrentChoices(qObj) must beSome(List("Yes"))
  }
  def e6 = {
    val qObj = Questions()
    Questions.setCurrentQuestion(qObj, "Are you organizing data?")
    Questions.addChoiceToCurrentQuestion(qObj,"Yes")
    Questions.addChoiceToCurrentQuestion(qObj,"No")
    val choicesOpt = Questions.getCurrentChoices(qObj)
    choicesOpt must beSome and {
      val list = choicesOpt.get
      (list must have size(2)) and
      (list must beEqualTo(List("Yes","No")))
    }
  }
}