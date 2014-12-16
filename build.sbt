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
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.activiti" % "activiti-engine" % "5.16.4",
  "org.apache.commons" % "commons-email" % "1.2",
  "junit" % "junit" % "4.11",  
  "org.webjars" % "angularjs" % "1.3.2",
  "org.st-js.bridge" % "angularjs" % "1.0.7.bv0",
  "org.webjars" % "ngStorage" % "0.3.0"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)