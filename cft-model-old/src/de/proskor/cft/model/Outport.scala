package de.proskor.cft.model

trait Outport extends Port

object Outport {
  def apply(name: String): Outport = Factory.createOutport(name)
  def apply(parent: Component, name: String): Outport = Factory.createOutport(parent, name)
  def unapply(outport: Outport): Option[(String, Set[Source])] = Some(outport.name, outport.inputs)
}