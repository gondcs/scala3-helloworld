import Versions._
import TestDependencies._
import Dependencies._
import sbt._

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-moap",
    version := "0.1.0-SNAPSHOT",
    organization := "com.example",
    scalaVersion := scala3Version,
    
    run / fork := true,

    libraryDependencies ++= Seq(
      scalaLogging,
      logback,
      tapirAkkaHttp.cross(CrossVersion.for3Use2_13),
      munit
    )
  )
