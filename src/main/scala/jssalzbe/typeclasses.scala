package jssalzbe

import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.{ TestIdentifier, TestPlan }

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._
import org.json4s.JsonAST.JValue

import jssalzbe.typeclasses.ToJson
import jssalzbe.typeclasses.ToJson._
import jssalzbe.typeclasses.ToJson.ops._

import scala.language.implicitConversions

import scala.compat.java8.OptionConverters._
import scala.collection.JavaConverters._

package object typeclasses {
  implicit val toJsonTestId: ToJson[TestIdentifier] = new ToJson[TestIdentifier] {
    override def toJson(a: TestIdentifier): JValue = {
      val parent: Option[String] = a.getParentId().asScala
      ("type" -> "TestIdentifier") ~
      ("displayName" -> a.getDisplayName) ~
      ("parentId" -> parent) ~
      ("isContainer" -> a.isContainer) ~
      ("isTest" -> a.isTest)
    }
  }

  implicit val toJsonTestResultStatus: ToJson[TestExecutionResult.Status] =
    new ToJson[TestExecutionResult.Status] {
      override def toJson(a: TestExecutionResult.Status): JValue =
        a match {
          case TestExecutionResult.Status.ABORTED => {
            ("type" -> "TestExecutionResult") ~
            ("value" -> "ABORTED")
          }
          case TestExecutionResult.Status.FAILED => {
            ("type" -> "TestExecutionResult") ~
            ("value" -> "FAILED")
          }
          case TestExecutionResult.Status.SUCCESSFUL => {
            ("type" -> "TestExecutionResult") ~
            ("value" -> "SUCCESSFUL")
          }
          case _ => {
            throw new IllegalArgumentException()
          }
        }
    }

  implicit val toJsonStackTraceElement: ToJson[StackTraceElement] =
    new ToJson[StackTraceElement] {
      override def toJson(a: StackTraceElement): JValue = {
        ("type" -> "StackTraceElement") ~
        ("className" -> a.getClassName) ~
        ("fileName" -> a.getFileName) ~
        ("lineNumber" -> a.getLineNumber) ~
        ("methodName" -> a.getMethodName) ~
        ("isNativeMethod" -> a.isNativeMethod) ~
        ("string" -> a.toString)
      }
    }

  implicit val toJsonThrowable: ToJson[Throwable] = new ToJson[Throwable] {
    override def toJson(a: Throwable): JValue = {
      ("type" -> "Throwable") ~
      ("message" -> a.getMessage) ~
      ("stacktrace" -> a.getStackTrace.map(x => x.toJson).toList)
    }
  }

  implicit val toJsonTestExecutionResult: ToJson[TestExecutionResult] = new ToJson[TestExecutionResult] {
    override def toJson(a: TestExecutionResult): JValue = {
      val status = a.getStatus.toJson
      val throwable = a.getThrowable.asScala.map(x => x.toJson)
      ("type" -> "TestExecutionResult") ~
      ("status" -> status) ~
      ("throwable" -> throwable)
    }
  }

  implicit val toJsonTestPlan: ToJson[TestPlan] = new ToJson[TestPlan] {
    override def toJson(a: TestPlan): JValue = {
      val roots = a.getRoots.asScala.toList.map(x => x.toJson)
      ("type" -> "TestPlan") ~
      ("roots" -> roots)
    }
  }
}
