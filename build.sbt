name := "Overwatch"

organization := "com.databricks.labs"

version := "0.2_RC1"

scalaVersion := "2.11.12"
scalacOptions ++= Seq("-Xmax-classfile-name", "78")

val sparkVersion = "2.4.5"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion
libraryDependencies += "com.databricks" %% "dbutils-api" % "0.0.4"
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2"
libraryDependencies += "com.microsoft.azure" %% "azure-eventhubs-spark" % "2.3.7"

//libraryDependencies += "io.delta" %% "delta-core" % "0.6.1"
libraryDependencies += "com.github.mrpowers" %% "spark-fast-tests" % "0.21.3" % Test
// https://mvnrepository.com/artifact/org.mockito/mockito-core
libraryDependencies += "org.mockito" % "mockito-core" % "3.5.15" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
// https://mvnrepository.com/artifact/com.holdenkarau/spark-testing-base
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.5_0.14.0" % Test


// enforce execution of tests during packaging - uncomment next line when we fix dependencies
// Keys.`package` := (Compile / Keys.`package` dependsOn Test / test).value

coverageEnabled := true
//coverageMinimum := 80
//coverageFailOnMinimum := true

assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter { f =>
    f.data.getName.contains("spark-core") ||
      f.data.getName.contains("spark-sql") ||
      f.data.getName.contains("spark-hive") ||
      f.data.getName.contains("azure-eventhubs-spark") ||
      f.data.getName.contains("delta-core") ||
      f.data.getName.contains("com.databricks.dbutils-api_2.11")
  }
}
