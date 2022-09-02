package com.example.route

import akka.actor.ActorSystem
import scala.concurrent.ExecutionContext

object Routes:
	def apply()(using ActorSystem, ExecutionContext) =
		val definition = new EndpointsDefinitions
		val implementation = new EndpointsImplAkka(definition)
		implementation.routes
