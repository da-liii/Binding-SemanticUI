import sbt.Keys._

lazy val jQueryV = "3.3.1"
lazy val semanticV = "2.4.1"

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
    </developers>)
)

lazy val ant = (project in file("ant"))
  .settings(commonSettings)
  .settings(
    name := "ant",
    libraryDependencies ++= Seq(
      "com.thoughtworks.binding" %%% "binding" % "11.3.0",
      "com.thoughtworks.extractor" %% "extractor" % "1.2.0",
      "com.lihaoyi" %%% "scalatags" % "0.6.7",
      "org.scala-js" %%% "scalajs-dom" % "0.9.5",
      "org.typelevel" %% "macro-compat" % "1.1.1",
      "org.apache.commons" % "commons-lang3" % "3.8.1",
      "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided
    ),
    scalacOptions += "-Xexperimental",
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  ).enablePlugins(ScalaJSPlugin)

lazy val semantic = (project in file("semantic"))
  .settings(commonSettings)
  .settings(
    name := "semantic",
    libraryDependencies ++= Seq(
      "io.udash" %%% "udash-jquery" % "3.0.0",
      "com.thoughtworks.binding" %%% "dom" % "11.3.0",
      "com.sadhen.binding" %%% "ant" % "0.0.2-SNAPSHOT"
    )
  )
  .dependsOn(ant)
  .enablePlugins(ScalaJSPlugin)

lazy val doc = (project in file("doc"))
  .settings(
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    skip in packageJSDependencies := false,
    jsDependencies ++= Seq(
      "org.webjars" % "jquery" % jQueryV / "jquery.js" minified "jquery.min.js",
      "org.webjars" % "Semantic-UI" % semanticV / "semantic.js" minified "semantic.min.js" dependsOn "jquery.js"
    )
  )
  .dependsOn(semantic)
  .enablePlugins(ScalaJSPlugin)

lazy val root = (project in file("."))
  .aggregate(ant, semantic, doc)
  .settings(
    name := "root"
  )
