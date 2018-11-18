package au.edu.rmit.cpt222.model;

import java.util.Random;

import au.edu.rmit.cpt222.model.interfaces.Coin;

public class CoinImpl implements Coin {
	
	private Face currentFace = null;
	private Face[] faces = { Face.heads, Face.tails };
	
	
	public CoinImpl() {
		int random = new Random().nextInt(this.faces.length);
		setCurrentFace(this.faces[random]);
	}

	@Override
	public Face getCurrentFace() {
		return currentFace;
	}

	@Override
	public void setCurrentFace(Face currentFace) {
		this.currentFace = currentFace;
	}

	@Override
	public void swapFace() {
		if (this.currentFace == Face.heads) {
			setCurrentFace(Face.tails);
		} else {
			setCurrentFace(Face.heads);
		}

	}

}
