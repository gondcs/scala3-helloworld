package com.example.route

import sttp.tapir._
import sttp.tapir.endpoint

class EndpointsDefinitions:
	lazy val routes = helloWorld

	// the endpoint: single fixed path input ("hello"), single query parameter
	// corresponds to: GET /hello?name=...
	lazy val helloWorld: PublicEndpoint[String, Unit, String, Any] =
		endpoint.get.in("hello").in(query[String]("name")).out(stringBody)
