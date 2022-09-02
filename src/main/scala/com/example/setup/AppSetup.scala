package com.example.setup

import com.typesafe.scalalogging._
import akka.actor.ActorSystem

trait AppSetup:
	lazy val logger = Logger(getClass.getName)
	lazy val actorSystem: ActorSystem = ActorSystem()
