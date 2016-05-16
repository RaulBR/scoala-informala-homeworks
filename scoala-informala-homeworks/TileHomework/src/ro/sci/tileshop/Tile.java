/**
 * 
 */
package ro.sci.tileshop;

/**
 * Interface for calculating the price/surface and surface of tiles
 * 
 * @author Raul
 *
 */
public interface Tile {

	double calculatePrice(double survaceToCover);

	double calculateTileSurface();

}
