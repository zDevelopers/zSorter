package fr.zcraft.zsorting.model;

import java.io.Serializable;

import org.bukkit.Location;

/**
 * The class {@code InputOutput} represents an input or an output of a bank.
 * @author Lucas
 *
 */
public abstract class InputOutput implements Serializable, Comparable<InputOutput>{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3179098898886096938L;

	/**
	 * The bank associated with the InputOutput.
	 */
	private Bank bank;
	
	/**
	 * Location of the InputOutput.
	 */
	private Location location;
	
	/**
	 * Priority of the InputOutput.
	 */
	private int priority;

	/**
	 * Constructor of an InputOutput object.
	 * @param bank - Bank the InputOutput is associated with.
	 * @param location - Location of the InputOutput.
	 * @param priority - Priority of the InputOutput.
	 */
	public InputOutput(Bank bank, Location location, Integer priority) {
		super();
		
		if(bank == null)
			throw new IllegalArgumentException("An InputOutput bank cannot be null");
		
		if(location == null)
			throw new IllegalArgumentException("An InputOutput location cannot be null");
		
		if(priority == null)
			throw new IllegalArgumentException("An InputOutput priority cannot be null");
		
		if(priority < 1)
			throw new IllegalArgumentException("An InputOutput priority cannot be less than 1");
		
		this.bank = bank;
		this.location = location;
		this.priority = priority;
	}

	/**
	 * Returns the bank of the InputOutput.
	 * @return Bank of the InputOutput.
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * Returns the priority of the InputOutput;
	 * @return Priority of the InputOutput
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority of the InputOutput.
	 * @param priority - Prority of the InputOutput.
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Returns the location of the InputOutput.
	 * @return Location of the InputOutput.
	 */
	public Location getLocation() {
		return location;
	}

	@Override
	public int compareTo(InputOutput io) {
		return this.priority - io.getPriority();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + priority;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputOutput other = (InputOutput) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}
}
