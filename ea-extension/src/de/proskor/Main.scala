package de.proskor

import de.proskor.extension.AddInBridge
import de.proskor.automation.impl.RepositoryImpl
import cli.EA.IRepository

class Main extends AddInBridge {
  override def initialize(repository: IRepository) {
    RepositoryImpl.peer = repository
  }

  override protected def createExtension = new CftExtension
}