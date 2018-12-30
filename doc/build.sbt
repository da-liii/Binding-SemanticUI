enablePlugins(ScalaJSPlugin)

lazy val jQueryV = "3.3.1"
lazy val semanticV = "2.4.1"

skip in packageJSDependencies := false
jsDependencies += "org.webjars" % "jquery" % jQueryV / "jquery.js" minified "jquery.min.js"
jsDependencies += "org.webjars" % "Semantic-UI" % semanticV / "semantic.js" minified "semantic.min.js" dependsOn "jquery.js"
