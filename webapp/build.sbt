import uk.co.timcowlishaw.GulpPlugin.GulpKeys._

name := "Undercurrent"

version := "0.1"

scalaVersion := "2.10.3"


seq(gulpSettings: _*)

gulpAppBase := "ui"

seq(cucumberSettings : _*)

cucumberStepsBasePackage := "step_definitions"

scalaSource in Test := baseDirectory.value / "features"

resourceDirectory in Test := baseDirectory.value / "features"
