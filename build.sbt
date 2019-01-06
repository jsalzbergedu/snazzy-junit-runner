import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.jssalzbe"
ThisBuild / organizationName := "jssalzbe"

lazy val root = (project in file("."))
  .settings(
    name := "snazzy-junit",
    libraryDependencies += scalaTest % Test,
    scalacOptions += "-feature",
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
    libraryDependencies += "org.scala-lang.modules" %% "scala-java8-compat" % "0.9.0",
    libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.27",
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.3",
    libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.14.0",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.3.2",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-params" % "5.3.2",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.3.2",
    libraryDependencies += "org.junit.vintage" % "junit-vintage-engine" % "5.3.2",
    libraryDependencies += "org.junit.platform" % "junit-platform-launcher" % "1.3.1",
    libraryDependencies += "org.junit.platform" % "junit-platform-console" % "1.3.1",
    libraryDependencies += "io.reactivex" %% "rxscala" % "0.26.5"
  )

// Uncomment the following for publishing to Sonatype.
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for more detail.

// ThisBuild / description := "Some descripiton about your project."
// ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
// ThisBuild / homepage    := Some(url("https://github.com/example/project"))
// ThisBuild / scmInfo := Some(
//   ScmInfo(
//     url("https://github.com/your-account/your-project"),
//     "scm:git@github.com:your-account/your-project.git"
//   )
// )
// ThisBuild / developers := List(
//   Developer(
//     id    = "Your identifier",
//     name  = "Your Name",
//     email = "your@email",
//     url   = url("http://your.url")
//   )
// )
// ThisBuild / pomIncludeRepository := { _ => false }
// ThisBuild / publishTo := {
//   val nexus = "https://oss.sonatype.org/"
//   if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//   else Some("releases" at nexus + "service/local/staging/deploy/maven2")
// }
// ThisBuild / publishMavenStyle := true
