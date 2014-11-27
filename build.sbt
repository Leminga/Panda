import play.PlayJava

name := "panda"

scalaVersion := "2.11.2"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "net.sourceforge.jtds" % "jtds" % "1.2" ,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "org.activiti" % "activiti-engine" % "5.14",
  "be.objectify" %% "deadbolt-java" % "2.3.0-RC1",
  "com.feth"      %%  "play-authenticate" % "0.6.1-SNAPSHOT"
)

resolvers ++=Seq(
  Resolver.url("Objectify Play Repository (release)", url("http://schaloner.github.com/releases/")),
  Resolver.url("Objectify Play Repository (snapshot)", url("http://schaloner.github.com/snapshots/")),
  "play-easymail (release)" at "http://joscha.github.io/play-easymail/repo/releases/",
  "play-easymail (snapshot)" at "http://joscha.github.io/play-easymail/repo/snapshots/",
  "play-authenticate (release)" at "http://joscha.github.io/play-authenticate/repo/releases/",
  "play-authenticate (snapshot)" at "http://joscha.github.io/play-authenticate/repo/snapshots/"
)

lazy val root = (project in file("."))
.enablePlugins(PlayJava)