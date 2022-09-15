name := """play-java-hello-world-tutorial"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies ++= Seq(
javaWs,
caffeine,
"com.google.code.gson" % "gson" % "2.2.4",
"org.mockito" % "mockito-core" % "2.22.0" % "test",
"com.typesafe.akka" %% "akka-actor" % "2.6.14",
"com.typesafe.akka" %% "akka-testkit" % "2.6.14" % Test
)
libraryDependencies += "org.mockito" % "mockito-core" % "2.10.0" % Test


