package de.proskor.cft.impl;

import java.util.Collection;
import java.util.LinkedList;

import de.proskor.cft.Component;
import de.proskor.cft.Element;
import de.proskor.cft.Package;

public class PackageImpl implements Package {
	private final de.proskor.model.Package peer;

	public PackageImpl(de.proskor.model.Package peer) {
		if (peer == null)
			throw new IllegalArgumentException("peer is null");

		this.peer = peer;
	}

	@Override
	public Collection<Element> getElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.peer.getName();
	}

	@Override
	public void setName(String name) {
		this.peer.setName(name);
	}

	@Override
	public Package getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Package> getPackages() {
		final Collection<Package> packages = new LinkedList<Package>();
		for (final de.proskor.model.Package kid : this.peer.getPackages()) {
			packages.add(new PackageImpl(kid));
		}
		return packages;
	}

	@Override
	public Collection<Component> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component createComponent() {
		de.proskor.model.Element kid = this.peer.getElements().add("", de.proskor.model.Element.OBJECT);
		return new ComponentImpl(kid);
	}
}
