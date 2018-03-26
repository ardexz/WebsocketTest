name := """WebsocketTest"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
// libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "com.github.tminglei" %% "slick-pg" % "0.15.2",
  "com.typesafe.akka" %% "akka-remote" % "2.5.9",
  "com.typesafe.akka" %% "akka-actor" % "2.5.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.9" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.1" % Test,
  "com.typesafe.play" %% "play-ws-standalone" % "2.0.0-M1",
  "com.typesafe.play" %% "play-ahc-ws-standalone" % "2.0.0-M1"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

