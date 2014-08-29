scalaVersion := "2.10.4"

resolvers += "Templemore Repository" at "http://templemore.co.uk/repo"

addSbtPlugin("templemore" % "sbt-cucumber-plugin" % "0.8.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

