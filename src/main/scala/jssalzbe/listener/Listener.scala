package jssalzbe.listener

import jssalzbe.model.Test
import jssalzbe.typeclasses.ToJson
import jssalzbe.typeclasses.ToJson._
import jssalzbe.typeclasses.ToJson.ops._
import jssalzbe.typeclasses._

import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.engine.reporting.ReportEntry
import org.junit.platform.launcher.{ TestExecutionListener, TestIdentifier, TestPlan }
import rx.lang.scala.Observer


import scala.compat.java8.OptionConverters._

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

class Listener(plan: TestPlan) extends TestExecutionListener {

  override def dynamicTestRegistered(identifier: TestIdentifier): Unit = {
    val out: JValue = {
      ("type" -> "error") ~
      ("error" -> "not yet implemented")
    }
    println(compact(render(out)))
  }

  override def executionFinished(identifier: TestIdentifier,
    result: TestExecutionResult): Unit = {
    val out: JValue = {
      ("type" -> "executionFinished") ~
      ("identifier" -> identifier.toJson) ~
      ("result" -> result.toJson)
    }
    println(compact(render(out)))
  }

  override def executionSkipped(identifier: TestIdentifier, reason: String): Unit = {
    val out: JValue = {
      ("type" -> "error") ~
      ("error" -> "not yet implemented")
    }
    println(compact(render(out)))
  }

  override def executionStarted(identifier: TestIdentifier): Unit = {
    val out: JValue = {
      ("type" -> "executionStarted") ~
      ("identifier" -> identifier.toJson)
    }
    println(compact(render(out)))
  }

  override def reportingEntryPublished(identifier: TestIdentifier, entry: ReportEntry): Unit = {
    val out: JValue = {
      ("type" -> "error") ~
      ("error" -> "not yet implemented")
    }
    println(compact(render(out)))
  }

  override def testPlanExecutionFinished(plan: TestPlan): Unit = {
    val out: JValue = {
      ("type" -> "testPlanExecutionFinished") ~
      ("plan" -> plan.toJson)
    }
    println(compact(render(out)))
  }

  override def testPlanExecutionStarted(plan: TestPlan): Unit = {
    val out: JValue = {
      ("type" -> "testPlanExecutionStarted") ~
      ("plan" -> plan.toJson)
    }
    println(compact(render(out)))
  }
}
