package ro.sci.tileshop;
/**
 * Abstract Class To model tiles and calculates the surface and  the price of triangular tiles.
 * @Raul
 */
abstract class AbstractTriangleTile implements Tile {
	
	
	private double price;
	private double legA;
	private double legB;
	private double legC;
	/**
	 * Method used to get parameters
	 * <p>
	 * @param price per unit of tile.
	 * @param legA in cm.
	 * @param legB in cm.
	 * @param legC in cm.
	 * </p>
	 * 
	 */
	public AbstractTriangleTile(double price, double legA, double legB, double legC) {
		this.legA=legA/100;
		this.legB=legB/100;
		this.legC=legC/100;	
		this.price=price;
}

	/**
	 * Method calculates the surface of any triangle
	 * <p>
	 * 
	 * @param price
	 *            per unit of tile.
	 * @param legA
	 *            in cm.
	 * @param legB
	 *            in cm.
	 * @param legC
	 *            in cm.
	 *            </p>
	 * 
	 */
	public double calculateTileSurface() {
		double p=(legA+legB+legC)/2;
						return Math.sqrt((p*(p-legA)*(p-legB)*(p-legC)));
			}
	/**
	 * Method calculates the price to cover a specific surface
	 * <p>
	 * @param surfaceToCover the surface to cover.
	 * </p>
	 */
	public double  calculatePrice(double surfaceToCover){
		return surfaceToCover/calculateTileSurface()* price;
		
	}
}