package Load_Testing_Api

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Load_Testing extends Simulation {

  // protocol
  val httpProtocol = http.baseUrl("https://reqres.in/api")

  // scenario
  val getUser = scenario("GET API")
    .exec(
      http("Get User")
        .get("/users/2")
        .check(
          status.is(200),
          jsonPath("$.data.first_name").is("Janet")
        )
    )
    .pause(2)

  val createUser = scenario("POST API")
    .exec(
      http("Create User")
        .post("/users")
        .asJson
        .body(RawFileBody("data/user.json")).asJson
        .check(
          status.is(201),
          jsonPath("$.name").is("morpheus")
        )
    )
    .pause(2)

  val updateUser = scenario("PUT API")
    .exec(
      http("Update User")
        .put("/users/2")
        .body(RawFileBody("data/user.json")).asJson
        .check(
          status.is(200),
          jsonPath("$.name").is("morpheus")
        )
    )
    .pause(2)

  val deleteUser = scenario("DELETE API")
    .exec(
      http("Delete User")
        .delete("/users/2")
        .check(status.is(204))
    )


  // setup
  setUp(
    getUser.inject(atOnceUsers(10)),
    createUser.inject(atOnceUsers(10)),
    updateUser.inject(atOnceUsers(10)),
    deleteUser.inject(atOnceUsers(10))
  ).protocols(httpProtocol)

}
