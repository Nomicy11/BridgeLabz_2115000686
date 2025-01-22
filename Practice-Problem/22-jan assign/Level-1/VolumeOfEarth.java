import java.lang.Math;
public class VolumeOfEarth{
	public static void main(String[] args){
		double radiusOfEarth = 6378;
		double volumeInKilometers = (4*3.14*(Math.pow(radiusOfEarth,3)))/3;
		double volumeInMiles =  volumeInKilometers * 1.6;
		System.out.println("The volume of earth in cubic kilometers is "+volumeInKilometers+" and cubic miles is "+volumeInMiles);

	}
}
