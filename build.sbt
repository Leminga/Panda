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
  "org.apache.commons" % "commons-email" % "1.2" 
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)