package jssalzbe

import jssalzbe.listener.Listener

import scala.collection.JavaConverters._

import java.io.PrintWriter
import org.junit.platform.launcher.core.{ LauncherDiscoveryRequestBuilder, LauncherFactory }

import org.junit.platform.engine.discovery.DiscoverySelectors._

object SnazzyJunit extends Greeting {
  def runOne(clazz: Option[Class[_]]): Unit = {
    val request = LauncherDiscoveryRequestBuilder
      .request
      .selectors(selectClass(clazz match {
        case Some(x) => x
        case _ => classOf[String]
      }))
      .build
    val launcher = LauncherFactory.create
    val testPlan = launcher.discover(request)
    val listener2 = new Listener(testPlan);
    launcher.registerTestExecutionListeners(listener2)
    launcher.execute(request)
  }

  def main(args: Array[String]): Unit = {
    val loader = this.getClass.getClassLoader

    var clazz: Option[Class[_]] = None

    try {
      clazz = Some(loader.loadClass("jssalzbe.ExampleClass"))
    } catch {
      case e: ClassNotFoundException => {
        println("""
{"type":"error","error":"unimplemented"}
""")
      }
    }

    SnazzyJunit.runOne(clazz)
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
