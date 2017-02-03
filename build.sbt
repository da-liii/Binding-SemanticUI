import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "com.sadhen.binding",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  isSnapshot := version.value.endsWith("SNAPSHOT")
)

lazy val librarySettings = Seq(
  name := "semantic-ui",
  libraryDependencies ++= Seq(
    "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
    "com.thoughtworks.binding" %%% "dom" % "10.0.2"
  )
)

lazy val library = (project in file("."))
  .settings(commonSettings, librarySettings)
  .enablePlugins(ScalaJSPlugin)
