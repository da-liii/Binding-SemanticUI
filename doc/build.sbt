enablePlugins(ScalaJSPlugin)
enablePlugins(GhpagesPlugin)

git.remoteRepo := "git@github.com:sadhen/Binding-SemanticUI.git"

skip in packageJSDependencies := false

crossTarget in fastOptJS := baseDirectory.value / "src" / "site"

crossTarget in fullOptJS := baseDirectory.value / "src" / "site"


