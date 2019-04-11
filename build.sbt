name := "akkarabbit"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "com.newmotion" %% "akka-rabbitmq" % "5.0.4-beta"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.20"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.5"
libraryDependencies += "zamblauskas" %% "scala-csv-parser" % "0.11.4"
resolvers += Resolver.bintrayRepo("zamblauskas", "maven")
// Core library, included automatically if any other module is imported.
libraryDependencies += "com.nrinaudo" %% "kantan.csv" % "0.5.0"

// Java 8 date and time instances.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-java8" % "0.5.0"

// Provides scalaz type class instances for kantan.csv, and vice versa.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-scalaz" % "0.5.0"

// Provides cats type class instances for kantan.csv, and vice versa.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-cats" % "0.5.0"

// Automatic type class instances derivation.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-generic" % "0.5.0"

// Provides instances for joda time types.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-joda-time" % "0.5.0"

// Provides instances for refined types.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-refined" % "0.5.0"

// Provides instances for enumeratum types.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-enumeratum" % "0.5.0"

// Provides instances for libra types.
libraryDependencies += "com.nrinaudo" %% "kantan.csv-libra" % "0.5.0"

