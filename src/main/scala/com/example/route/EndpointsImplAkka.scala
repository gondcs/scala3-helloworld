package com.example.route

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter
import akka.actor.ActorSystem

import scala.concurrent.{Future, ExecutionContext}

class EndpointsImplAkka(endpoints: EndpointsDefinitions)(using ActorSystem, ExecutionContext):
  // converting an endpoint to a route (providing server-side logic);
  // extension method comes from imported packages
  lazy val helloWorldRoute: Route = AkkaHttpServerInterpreter().toRoute(
    endpoints.helloWorld.serverLogicSuccess(name => Future.successful(s"Hello, $name!"))
  )
  lazy val routes: Route = helloWorldRoute
