enablePlugins(ScalaJSPlugin)
enablePlugins(GhpagesPlugin)

git.remoteRepo := "git@github.com:sadhen/Binding-SemanticUI.git"

skip in packageJSDependencies := false

crossTarget in fastOptJS := baseDirectory.value / "src" / "site"

crossTarget in fullOptJS := baseDirectory.value / "src" / "site"


lazy val jQueryV = "3.3.1"
lazy val semanticV = "2.4.1"

jsDependencies += "org.webjars" % "jquery" % jQueryV / "jquery.js" minified "jquery.min.js"
jsDependencies += "org.webjars" % "Semantic-UI" % semanticV / "semantic.js" minified "semantic.min.js" dependsOn "jquery.js"
