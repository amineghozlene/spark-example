name := "sparkex"

organization := "com.sparkex"
version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.4.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

val loggerOptions = Seq(
  "-Dlog4j.debug=true",
  "-Dlog4j.configuration=log4j.properties")
javaOptions in run ++= loggerOptions
javaOptions in test ++= loggerOptions
