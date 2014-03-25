import play.Project._

name := "Undercurrent"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.1.0" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.40.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"
)

playScalaSettings

seq(cucumberSettings : _*)

cucumberFeaturesLocation := "test/acceptance/features"

cucumberStepsBasePackage := "com.undercurrentapp.webapp.test.acceptance.step_definitions"
