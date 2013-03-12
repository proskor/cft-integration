package de.proskor.cft.model

trait Repository extends Package

object Repository {
  def apply(name: String): Repository = Factory.createRepository(name)
  def unapply(repository: Repository): Option[(String, Set[Package])] = Some(repository.name, repository.packages)
}