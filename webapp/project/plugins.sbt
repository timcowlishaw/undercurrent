scalaVersion := "2.10.3"

resolvers += "Templemore Repository" at "http://templemore.co.uk/repo"

addSbtPlugin("com.joprice" % "grunt-plugin" % "0.0.1")

addSbtPlugin("templemore" % "sbt-cucumber-plugin" % "0.8.0")
