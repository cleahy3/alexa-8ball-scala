# Destiny on the Tip of Your Tongue

## Overview

This project is an example Amazon Alexa skill written in Scala and targetting
the AWS Lambda platform.

## Prerequisites

Java 8 JDK is required.

[Scala Build Tool](http://www.scala-sbt.org/) is used to build and deploy this
project to an AWS Lambda function.

Deploying to AWS with `sbt` requires the [AWS CLI](https://aws.amazon.com/cli/)
tool to be configured on the system. Otherwise, the JAR can be uploaded
manually.

## Instructions

In the top level directory, copy the example environment script and edit it to
your needs.

**Note: The script must be sourced, not run.**

```
cp env.sh-sample env.sh
$EDITOR env.sh
. env.sh
```

To build the project and create the Lambda function:

```
sbt createLambda
```

When the command completes, the ARN of the created function will be displayed at
the end of the output.

**Note: You must add the `Alexa Skill Kit` trigger to the function manually.**

If you change the code after creating the function, you can update the function:

```
sbt updateLambda
```

To simply build the JAR without interacting with AWS:

```
sbt compile
sbt assembly
```

The intent schema and sample utterances for the Alexa skill are located in
`alexa/`

Detailed instructions for setting up the Alexa skill are outside the scope of
this README.

## Disclaimer

`Magic 8 Ball` is a registered trademark of Mattel, Inc. The `Magic 8 Ball`
trademark and various 8-Ball answers are used without permission of Mattel, Inc.
Mattel, Inc. is neither affiliated with this project, nor with authors of this
code.
