package ro.sci.tileshop;

public class PTTile extends AbstractTriangleTile {

	private double leg;

	/**
	 * Method calculates the surface of any triangle
	 * <p>
	 * 
	 * @param price
	 *            per unit of tile.
	 * @param leg
	 *            in cm.
	 *            </p>
	 * 
	 */
	public PTTile(double price, double leg) {
		super(price, 0, 0, 0.0);
		this.leg = leg / 100;
	}

	/**
	 * Method override perent's method to calculate the special case that is a
	 * isosceles right triangle
	 * 
	 */
	@Override
	public double calculateTileSurface() {

		return (leg * leg) / 2;
	}

}
