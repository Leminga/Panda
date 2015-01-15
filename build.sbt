import play.PlayJava

name := "panda"

scalaVersion := "2.11.2"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.apache.commons" % "commons-email" % "1.2",
  "junit" % "junit" % "4.11",  
  "org.webjars" % "angularjs" % "1.3.2",
  "org.st-js.bridge" % "angularjs" % "1.0.7.bv0",
  "org.webjars" % "ngStorage" % "0.3.0",
  "org.apache.commons" % "commons-csv" % "1.1",
  "org.webjars" % "cryptojs" % "3.1.2",
  "org.imgscalr" % "imgscalr-lib" % "4.2",
  "org.apache.directory.studio" % "org.apache.commons.io" % "2.4",
   "org.json" % "org.json" % "chargebee-1.0"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)
