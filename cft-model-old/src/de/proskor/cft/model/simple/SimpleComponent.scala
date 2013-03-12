package de.proskor.cft.model.simple

import de.proskor.cft.model._

private class SimpleComponent(initialName: String) extends SimpleContainer(initialName) with Component {
  def events: Set[Event] = elements.filter(_.isInstanceOf[Event]).asInstanceOf[Set[Event]]
  def inports: Set[Inport] = elements.filter(_.isInstanceOf[Inport]).asInstanceOf[Set[Inport]]
  def outports: Set[Outport] = elements.filter(_.isInstanceOf[Outport]).asInstanceOf[Set[Outport]]
  def gates: Set[Gate] = elements.filter(_.isInstanceOf[Gate]).asInstanceOf[Set[Gate]]
  def components: Set[Component] = elements.filter(_.isInstanceOf[Component]).asInstanceOf[Set[Component]]

  override def add(element: Element) {
    require(element.isInstanceOf[SimpleEvent] || element.isInstanceOf[SimpleGate] || element.isInstanceOf[SimplePort] || element.isInstanceOf[SimpleComponent])
    super.add(element)
  }
}