package de.proskor.automation

import de.proskor.automation.collections._
import cli.EA.IElement
import cli.EA.ICollection

class Element(peer: IElement) {
  def id: Int = peer.get_ElementID

  def name: String = peer.get_Name.asInstanceOf[String]
  def name_=(name: String): Unit = peer.set_Name(name)

  def stereotype: String = peer.get_Stereotype.asInstanceOf[String]
  def stereotype_=(stereotype: String): Unit = peer.set_Stereotype(stereotype)

  def elements: Collection[Element] = new ElementCollection(peer.get_Elements.asInstanceOf[ICollection])
  def connectors: Collection[Connector] = new ConnectorCollection(peer.get_Connectors.asInstanceOf[ICollection])

  def parent: Option[Element] =
    if (peer.get_ParentID > 0)
      Some(new Element(Repository.getElementById(peer.get_ParentID)))
    else
      None

  def pkg: Package = new Package(Repository.getPackageById(peer.get_PackageID))

  override def equals(that: Any): Boolean = that match {
    case element: Element => id == element.id
    case _ => false
  }

  override def hashCode: Int = id
}