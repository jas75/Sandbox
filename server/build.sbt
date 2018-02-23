name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

libraryDependencies ++= Seq(
  "com.mohiva" %% "play-silhouette" % "5.0.2",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "5.0.2",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "5.0.2",
  "com.mohiva" %% "play-silhouette-persistence" % "5.0.2",
  "com.mohiva" %% "play-silhouette-testkit" % "5.0.2" % "test",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.14"
)


