/**
 * 
 */
package ro.sci.tileshop;

/**
 * * STile {@link AbstractRectTile} that has a special property
 * CalculateTileSurface that gives specific surcafe of 1 m.
 * 
 * @author Raul
 *
 */
public class STile extends AbstractRectTile {
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
	public STile(double price, double sTileLength, double sTileWIdth) {
		super(price, sTileLength, sTileWIdth);

	}

	/**
	 * Method gives the specific surface unit of this type.
	 * 
	 */
	@Override
	public double calculateTileSurface() {
		return 1;
	}

}
