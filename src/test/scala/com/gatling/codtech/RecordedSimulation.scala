package com.gatling.codtech

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://opensource-demo.orangehrmlive.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/web/index.php/auth/login")
			.resources(http("request_1")
			.get("/web/index.php/core/i18n/messages"),
				http("request_2")
			.get("/web/images/ohrm_branding.png?v=1721393199309"),
				http("request_3")
			.get("/web/dist/img/blob.svg")))
		.pause(14)
		.exec(http("request_4")
			.post("/web/index.php/auth/validate")
			.formParam("_token", "6fcee854c33935554.8KGdHSRsE5wVT7u7xt2pXfrj5yyJuAubazXBbMuH83g.wO3ydVBaXMVwP9D485_jaqCy0Bu53UPOA2XyC4HEtyGS4_Yqaz5R0XQX6g")
			.formParam("username", "Admin")
			.formParam("password", "admin123")
			.resources(http("request_5")
			.get("/web/index.php/core/i18n/messages"),
				http("request_6")
			.get("/web/images/orange.png?v=1721393199309"),
				http("request_7")
			.get("/web/images/orangehrm-logo.png?v=1721393199309"),
				http("request_8")
			.get("/web/index.php/pim/viewPhoto/empNumber/7"),
				http("request_9")
			.get("/web/index.php/api/v2/dashboard/employees/action-summary"),
				http("request_10")
			.get("/web/index.php/api/v2/dashboard/employees/time-at-work?timezoneOffset=5.5&currentDate=2025-04-24&currentTime=15:55"),
				http("request_11")
			.post("/web/index.php/events/push"),
				http("request_12")
			.get("/web/index.php/api/v2/dashboard/shortcuts"),
				http("request_13")
			.get("/web/index.php/api/v2/dashboard/employees/leaves?date=2025-04-24"),
				http("request_14")
			.get("/web/index.php/api/v2/dashboard/employees/subunit"),
				http("request_15")
			.get("/web/index.php/api/v2/buzz/feed?limit=5&offset=0&sortOrder=DESC&sortField=share.createdAtUtc"),
				http("request_16")
			.get("/web/index.php/api/v2/dashboard/employees/locations")))

	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}