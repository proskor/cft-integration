package de.proskor.ea
import de.proskor.cft.model.Repository
import de.proskor.cft.model.Package
import de.proskor.cft.model.Element
import de.proskor.cft.test.CftTests
import org.scalatest.junit.JUnitRunner
import org.junit.runner.Description
import org.junit.runner.notification.Failure
import de.proskor.ea.ui.MergeDialog

class Main extends Extension with Adapter {
  def start() {}
  def stop() {}

  def test() {
    val repository = Repository("/")
    val pkg = Package(repository, "TEST")
    val subpkg = Package(pkg, "SUB")
  }

  def testRunner(clazz: Class[_]) = new org.scalatest.junit.JUnitRunner(clazz.asInstanceOf[Class[org.scalatest.Suite]])

  def testNotifier = new org.junit.runner.notification.RunNotifier() {
    override def fireTestFailure(failure: Failure) {
      write("---- TEST FAILED! " + failure.getDescription() + " ----")
      failure.getTrace.split("\n").map(_.trim).map(write)
      write("-" * 60)
    }
  }

  def runTests() {
    testRunner(classOf[de.proskor.cft.test.CftTests]).run(testNotifier)
    testRunner(classOf[de.proskor.cft.test.MergeTests]).run(testNotifier)
    write("---- ALL TESTS DONE ----")
  }

  def merge() {
    new MergeDialog(Repository("/"))
  }

  def allPackages(pkg: Package): Set[Package] = pkg.packages ++ pkg.packages.flatMap(allPackages)

  def fullName(element: Element): String = element.parent match {
    case None => element.name
    case Some(parent) => fullName(parent) + "/" + element.name
  }
}