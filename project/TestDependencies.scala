import Versions._
import sbt._

object TestDependencies {
  lazy val munit = "org.scalameta" %% "munit" % munitVersion % Test
}
