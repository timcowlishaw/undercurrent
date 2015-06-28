name := "Undercurrent"

version := "0.1"

scalaVersion := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion = "2.3.5"
  val sprayVersion = "1.3.1"
  Seq(
    "com.typesafe.akka"       %% "akka-actor"                   % akkaVersion,
    "io.spray"                %  "spray-can"                    % sprayVersion,
    "io.spray"                %  "spray-routing"                % sprayVersion,
    "org.fusesource.scalate"  %% "scalate-core"                 % "1.6.1",
    "io.spray"                %  "spray-testkit"                % sprayVersion  % "test",
    "org.scalatest"           %% "scalatest"                    % "2.2.1"       % "test",
    "com.typesafe.akka"       %% "akka-testkit"                 % akkaVersion   % "test",
    "org.seleniumhq.selenium" %  "selenium-java"                % "2.23.1"      % "test",
    "org.mockito"             % "mockito-all"                   % "1.9.5"       % "test"
  )
}

seq(cucumberSettings : _*)

cucumberStepsBasePackage := "step_definitions"

Revolver.settings

instrumentSettings
