package test

import org.specs2._
import specification._
import play.api.test._
import play.api.test.Helpers._
import controllers._

class DatabaseSpec extends Specification { def is =
  {
    val additionalConfiguration: Map[String, String] = Map("mongodb.db" -> "test-db")
    def application = FakeApplication(additionalConfiguration = additionalConfiguration)
    Step(play.api.Play.start(application)) ^
    "The database" ^
      "can be connected to" ! connectToDatabase ^
    Step(play.api.Play.stop())
  }
  
  def connectToDatabase = {
    pending
  }

}

/*
"HandleQuery" should {

def application = FakeApplication(additionalConfiguration = additionalConfiguration)

"HandleQuery Should adhere client's query" in {
  //Add some users
  val usersModel: Model = Users
  //Prepare data
  val user1 = Json.obj(
    "name" -> "Ahmed",
    "age" -> 23)
  val user2 = Json.obj(
    "name" -> "Mohammed",
    "age" -> 26)
  val user3 = Json.obj(
    "name" -> "Heba",
    "age" -> 20)
  println("DB Insertion")
  val op1 = usersModel.collection.insert(user1).map(lastError =>
    if (!lastError.ok)
      throw new Exception("Insertion Failed"))
  Await.result(op1, Duration(10000, "millis"))
  val op2 = usersModel.collection.insert(user2).map(lastError =>
    if (!lastError.ok)
      throw new Exception("Insertion Failed"))
  Await.result(op2, Duration(10000, "millis"))
  val op3 = usersModel.collection.insert(user3).map(lastError =>
    if (!lastError.ok)
      throw new Exception("Insertion Failed"))
  Await.result(op3, Duration(10000, "millis"))
  //DB Query normally
}
step {
  println("Dropping the DB")
  Await.result(Users.collection.drop, Duration(1000, "millis")): Unit
}
step(play.api.Play.stop())
}

}
*/