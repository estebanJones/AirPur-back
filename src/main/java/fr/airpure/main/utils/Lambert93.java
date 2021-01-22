package fr.airpure.main.utils;

import java.awt.geom.Point2D;

public class Lambert93 {
	 private final static double M_PI_2         = Math.PI / 2.0;
	   private final static double DEFAULT_EPS    = 1e-10;
	   private final static double E_WGS84        = 0.08181919106;
	   private final static double E2             = E_WGS84 / 2.0;
	   private final static double LON_MERID_IERS = 3.0 * Math.PI / 180.0;
	   private final static double N              = 0.7256077650;
	   private final static double C              = 11_754_255.426;
	   private final static double XS             =    700_000.000;
	   private final static double YS             = 12_655_612.050;

	   private static double latitudeFromLatitudeISO( final double latISo ) {
	      double phi0 = 2 * Math.atan( Math.exp( latISo ) ) - M_PI_2;
	      double phiI = 2
	         * Math.atan( Math.pow(( 1 + E_WGS84 * Math.sin( phi0 )) /
	                     ( 1 - E_WGS84 * Math.sin( phi0 )), E2) * Math.exp( latISo ) )
	         - M_PI_2;
	      double delta = Math.abs( phiI - phi0 );
	      while( delta > DEFAULT_EPS ){
	         phi0 = phiI;
	         phiI =
	            2 * Math.atan( Math.pow(
	                  ( 1 + E_WGS84 * Math.sin( phi0 ) ) /
	                  ( 1 - E_WGS84 * Math.sin( phi0 ) )  , E2)
	               * Math.exp( latISo ) ) - M_PI_2;
	         delta = Math.abs( phiI - phi0 );
	      }
	      return phiI;
	   }

	   public static double convertLongitudeLambertToWgs( double x, double y) {
		  final double dX     = x - XS;
	      final double dY     = y - YS;
	      final double R      = Math.sqrt( dX * dX + dY * dY );
	      final double gamma  = Math.atan( dX / -dY );
	      final double latIso = -1 / N * Math.log( Math.abs( R / C ) );
	    
	      return Math.toDegrees( LON_MERID_IERS + gamma / N );
	   }
	   
	   public static double convertLatitudeLambertToWgs( double x, double y) {
		  final double dX     = x - XS;
	      final double dY     = y - YS;
	      final double R      = Math.sqrt( dX * dX + dY * dY );
	      final double gamma  = Math.atan( dX / -dY );
	      final double latIso = -1 / N * Math.log( Math.abs( R / C ) );
	    
	      x = Math.toDegrees( LON_MERID_IERS + gamma / N );
	      return Math.toDegrees( latitudeFromLatitudeISO( latIso ));
		}
	   
	   
}
