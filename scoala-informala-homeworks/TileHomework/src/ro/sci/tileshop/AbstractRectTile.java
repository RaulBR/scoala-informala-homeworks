package ro.sci.tileshop;

/**
 * Abstract Class To model tiles and calculates the surface and the price of
 * rectangular tiles.
 * 
 * @Raul
 */
public abstract class AbstractRectTile implements Tile {
	private double lenght;
	private double width;
	private double price;

	/**
	 * Method used to get parameters
	 * <p>
	 * 
	 * @param price
	 *            per unit of tile.
	 * @param length
	 *            in cm.
	 * @param width
	 *            in cm.
	 *            </p>
	 * 
	 */
	public AbstractRectTile(double price, double lenght, double width) {
		this.lenght = lenght;
		this.width = width;
		this.price = price;
	}

	/**
	 * Method Used to calculate the covering surface of a single tile in meters
	 * 
	 */
	public double calculateTileSurface() {
		return width / 100 * lenght / 100;
	}

	/**
	 * Method used to calculate the price to cofer a specific surface in meters.
	 * 
	 */
	public double calculatePrice(double survaceToCover) {
		return survaceToCover / calculateTileSurface() * price;

	}
}
