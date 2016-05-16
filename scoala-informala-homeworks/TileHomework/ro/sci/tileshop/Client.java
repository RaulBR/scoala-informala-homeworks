package ro.sci.tileshop;

public class Client {

	public Client() {
		double width = 50;
		double length = 50;
		double priceForStile = 50;
		double priceForPtile = 20;
		double priceForPTtile = 12;
		double surfaceToCover = 10;
		double proportion =0.5;

		double sTileCost = CalculateSTileConst(surfaceToCover, priceForStile, length, width);
		System.out.println("1. cost for covering with s tiles " + sTileCost);
		double pTileCost = CalculatePTileConst(surfaceToCover, priceForPtile, length, width);
		System.out.println("2. cost for covering with p tiles " + pTileCost);
		double splitCost = CalculateFfSandP(sTileCost, pTileCost,proportion);
		System.out.println("3. cost for covering with s and p tiles " + splitCost);

		double PTTileCost = CalculatePTTileConst(surfaceToCover, priceForPTtile, length);
		System.out.println("4. cost for covering with PT tiles " + PTTileCost);
	}

	private double CalculatePTTileConst(double surfaceToCover, double priceForPTtile, double leg) {
		Tile pTTypeTile = new PTTile(priceForPTtile, leg);
		double returnValue = pTTypeTile.calculatePrice(surfaceToCover);
		return returnValue;
	}

	private double CalculateFfSandP(double sTileCost, double pTileCost,double proportion) {

		return sTileCost * proportion + pTileCost * 1-proportion;
	}

	private double CalculateSTileConst(double survaceToCover, double priceForStile, double sTileLength, double sTileWIdth) {

		Tile sTypeTile = new STile(priceForStile, sTileLength, sTileWIdth);
		double returnValue = sTypeTile.calculatePrice(survaceToCover);

		return returnValue;
	}

	private double CalculatePTileConst(double survaceToCover, double priceForPtile, double sTileLength, double sTileWIdth) {

		Tile pTypeTile = new PTile(priceForPtile, sTileLength, sTileWIdth);
		double returnValue = pTypeTile.calculatePrice(survaceToCover);

		return returnValue;

	}
}
