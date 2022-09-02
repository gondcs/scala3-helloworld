package com.example

import akka.http.scaladsl.Http
import akka.actor.ActorSystem

import scala.concurrent.ExecutionContext
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

import com.example.setup.{AppSetup, AppSettings}
import com.example.route.Routes 

object ApplicationServer extends AppSetup with AppSettings:

  @main def run: Unit =
    given ExecutionContext = actorSystem.dispatcher
    given ActorSystem = actorSystem

    // starting the server
    Http().newServerAt(httpInterface, httpPort)
      .bindFlow(Routes())
      .onComplete {
          case Success(_) =>
            logger.info(s"service=[${httpName}] Started...")
          case Failure(e) =>
            logger.error(s"Failed to start, error=[$e]", e)
            actorSystem.terminate().onComplete(_ => sys.error(s"Failed to start, error=[$e]"))
        }
