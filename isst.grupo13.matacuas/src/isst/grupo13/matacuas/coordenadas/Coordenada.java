package isst.grupo13.matacuas.coordenadas;

public class Coordenada {
	
	private double lat;
	private double lng;
	
	
	public Coordenada(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	

}
