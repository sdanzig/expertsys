import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "expertsys"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "org.specs2" %% "specs2" % "2.0-RC2" % "test"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
