package au.edu.rmit.cpt222.model.interfaces;

/**
 * Assignment interface for SADI representing the coin.
 * 
 * @author Mikhail Perepletchikov
 * 
 */
public interface Coin {

	/**
	 * enum type representing a coin face
	 */
	public enum Face {
		heads, tails
	}

	/**
	 * @return the "selected" face of this coin
	 */
	public Face getCurrentFace();

	/**
	 * @param currentFace
	 *            current face of the coin
	 */
	public void setCurrentFace(Face currentFace);

	/**
	 * Changes (swaps) the coin faces.
	 */
	public void swapFace();
}