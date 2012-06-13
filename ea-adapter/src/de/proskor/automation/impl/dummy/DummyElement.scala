package de.proskor.automation.impl.dummy

import de.proskor.automation.{Collection, Connector, Element, Package}

class DummyElement(parent: Element, val pkg: Package, var name: String) extends Element {
  val id: Int = IdGenerator.next
  var stereotype: String = ""

  lazy val connectors: Collection[Connector] = new DummyConnectorCollection(this)

  lazy val elements: Collection[Element] = new DummyCollection(this,
    (name: String, typ: String, parent: Element) => new DummyElement(parent, pkg, name))

  def parent: Option[Element] = Option(parent)
}