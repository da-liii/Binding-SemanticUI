import sbt.Keys._

transitiveClassifiers in Global := Seq(Artifact.SourceClassifier)

scalaVersion in ThisBuild := "2.12.8"

lazy val root = (project in file("."))
  .aggregate(ant, semantic, doc)
  .settings(
    name := "Binding-SemanticUI"
  )

lazy val ant = (project in file("ant"))
  .settings(commonSettings)

lazy val semantic = (project in file("semantic"))
  .settings(commonSettings)
  .dependsOn(ant)

lazy val doc = (project in file("doc"))
  .settings(commonSettings)
  .dependsOn(semantic)

lazy val commonSettings = Seq(
  organization := "com.sadhen.binding",
  version := "0.0.2-SNAPSHOT",
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
)

lazy val publishSettings = Seq(
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
    <url>http://github.com/sadhen/Binding-SemanticUI</url>
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
    </developers>
  )
)
