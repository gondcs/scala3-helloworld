import Versions._
import sbt._

object Dependencies {

  lazy val config = "com.typesafe" % "config" % configVersion
  lazy val logback = "ch.qos.logback" % "logback-classic" % logbackVersion
  lazy val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion
  lazy val tapirAkkaHttp = ("com.softwaremill.sttp.tapir" %% "tapir-akka-http-server" % tapirAkkaHttpVersion)
}
