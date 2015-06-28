scalaVersion := "2.10.4"

resolvers += "Templemore Repository" at "http://templemore.co.uk/repo"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("templemore" % "sbt-cucumber-plugin" % "0.8.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.11")
