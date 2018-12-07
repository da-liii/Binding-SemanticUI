import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "com.sadhen.binding",
  version := "0.0.2-SNAPSHOT",
  scalaVersion := "2.12.8",
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  publishMavenStyle := true,
  isSnapshot := version.value.endsWith("SNAPSHOT"),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := (
    <url>http://jsuereth.com/scala-ar://github.com/sadhen/Binding-SemanticUI</url>
    <licenses>
      <license>
        <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
          <distribution>repo</distribution>
          <comments>A business-friendly OSS license</comments>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:sadhen/Binding-SemanticUI.git</url>
      <connection>scm:git:git@github.com:sadhen/Binding-SemanticUI.git</connection>
    </scm>
    <developers>
      <developer>
        <id>sadhen</id>
        <name>Darcy Shen</name>
        <url>http://sadhen.com</url>
      </developer>
    </developers>)
)

lazy val librarySettings = Seq(
  name := "semantic-ui",
  libraryDependencies ++= Seq(
    "io.udash" %%% "udash-jquery" % "3.0.0",
    "com.thoughtworks.binding" %%% "dom" % "11.3.0"
  )
)

lazy val semantic = (project in file("semantic"))
  .settings(commonSettings, librarySettings)
  .enablePlugins(ScalaJSPlugin)
