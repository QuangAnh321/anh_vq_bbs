import sbt.Keys._
import scalariform.formatter.preferences._
name := """BulletinBoardSystem"""
organization := "com.example"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, ScalikejdbcPlugin)
  .settings(
    libraryDependencies ++= Seq(
      evolutions,
      jdbc,
      guice,
      "mysql" % "mysql-connector-java" % "8.0.18",
      "org.scalikejdbc" %% "scalikejdbc" % "3.4.0",
      "org.scalikejdbc" %% "scalikejdbc-config" % "3.4.0",
      "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.4",
      "org.skinny-framework" %% "skinny-orm" % "3.0.3",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "org.specs2" %% "specs2-core" % "4.6.0" % "test",
      "org.specs2" %% "specs2-mock" % "4.6.0" % "test"
    ),
    scalacOptions in Test ++= Seq("-Yrangepos")
  )
scalariformPreferences := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Preserve)
initialCommands := """
import scalikejdbc._
import skinny.orm._, feature._
import org.joda.time._
skinny.DBSettings.initialize()
implicit val session = AutoSession
"""
