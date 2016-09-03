enablePlugins(AwsLambdaPlugin)

lazy val root = (project in file(".")).
  settings(
    name := "magic8ball",
    version := "0.0.1",
    scalaVersion := "2.11.8"
  ).
  settings(
    libraryDependencies ++= dependencies
  )

lazy val dependencies = Seq(
    "com.amazon.alexa" % "alexa-skills-kit" % "1.1.3",
    "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.5",
    "org.apache.logging.log4j" % "log4j-core" % "2.6.2",
    "org.slf4j" % "slf4j-api" % "1.7.21",
    "org.apache.commons" % "commons-lang3" % "3.4",
    "commons-io" % "commons-io" % "2.5",
    "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
    "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.31"
)

handlerName := Some("com.freqlabs.magic8ball.Magic8BallSpeechletRequestStreamHandler")
region := Some("us-east-1")
