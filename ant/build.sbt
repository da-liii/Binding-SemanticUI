enablePlugins(ScalaJSPlugin)

scalacOptions += "-Xexperimental"
libraryDependencies += "com.thoughtworks.binding" %%% "binding" % "11.6.0"
libraryDependencies += "com.thoughtworks.binding" %% "xmlextractor" % "11.6.0"
libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.7"
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.5"
libraryDependencies += "org.typelevel" %% "macro-compat" % "1.1.1"
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided
