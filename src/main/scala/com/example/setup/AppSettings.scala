package com.example.setup

import com.typesafe.config.ConfigFactory

trait AppSettings:
	private val _config = ConfigFactory.load()

	// Define application specific configs here
	val httpName = _config.getString("http.name")
	val httpPort = _config.getInt("http.port")
	val httpInterface = _config.getString("http.interface")

	val someConfig = _config.getString("delete.me")
