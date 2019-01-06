package jssalzbe

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    SnazzyJunit.greeting shouldEqual "hello"
  }
}
