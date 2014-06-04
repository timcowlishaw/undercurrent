import uk.co.timcowlishaw.GulpPlugin.GulpKeys._

name := "Undercurrent"

version := "0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.23.1" % "test",
  "org.scalatra" %% "scalatra-scalatest" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test"
)

seq(gulpSettings: _*)

gulpAppBase := "ui"

seq(cucumberSettings : _*)

cucumberStepsBasePackage := "step_definitions"

scalaSource in Test := baseDirectory.value / "features"

resourceDirectory in Test := baseDirectory.value / "features"
