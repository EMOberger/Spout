package org.getspout.unchecked.server.entity.vehicles;

import org.bukkit.entity.Vehicle;
import org.getspout.api.protocol.Message;
import org.getspout.api.protocol.notch.msg.SpawnVehicleMessage;
import org.getspout.server.util.Position;
import org.getspout.unchecked.server.SpoutServer;
import org.getspout.unchecked.server.SpoutWorld;
import org.getspout.unchecked.server.entity.SpoutEntity;

public abstract class SpoutVehicle extends SpoutEntity implements Vehicle {
	private final int type;

	protected double maxSpeed;

	/**
	 * Creates an entity and adds it to the specified world.
	 *
	 * @param world The world.
	 */
	public SpoutVehicle(SpoutServer server, SpoutWorld world, int type) {
		super(server, world);
		this.type = type;
	}

	@Override
	public Message createSpawnMessage() {
		int x = Position.getIntX(location);
		int y = Position.getIntY(location);
		int z = Position.getIntZ(location);
		return new SpawnVehicleMessage(id, type, x, y, z);
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double speed) {
		maxSpeed = speed;
	}
}