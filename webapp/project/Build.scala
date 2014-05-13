import sbt._
import Keys._
object UndercurrentBuild extends Build {
  lazy val api = Project(id = "api", base=file("api"))
  lazy val root = Project(id = "undercurrent", base=file(".")) aggregate(api)
}
