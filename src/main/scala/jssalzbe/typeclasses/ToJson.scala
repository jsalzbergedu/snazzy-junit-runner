package jssalzbe.typeclasses

import org.json4s.JsonAST.JValue

import simulacrum._
import scala.language.implicitConversions

@typeclass trait ToJson[A] {
  def toJson(a: A): JValue
}
