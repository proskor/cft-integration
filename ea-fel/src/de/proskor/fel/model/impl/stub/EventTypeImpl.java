package de.proskor.fel.model.impl.stub;

import java.util.ArrayList;
import java.util.List;

import de.proskor.fel.model.container.EventTypeContainer;
import de.proskor.fel.model.event.EventInstance;
import de.proskor.fel.model.event.EventType;

public class EventTypeImpl extends EntityImpl implements EventType {
	private EventTypeContainer container;
	private List<EventInstance> instances = new ArrayList<EventInstance>();

	@Override
	public EventTypeContainer getContainer() {
		return this.container;
	}

	public void setContainer(EventTypeContainer container) {
		this.container = container;
	}

	@Override
	public List<EventInstance> getInstances() {
		return this.instances;
	}

	@Override
	public void addInstance(EventInstance eventInstance) {
		this.instances.add(eventInstance);
		eventInstance.setType(this);
	}
	
	@Override
	public String getQualifiedName() {
		return getContainer().getQualifiedName() + "." + getName();
	}
}
