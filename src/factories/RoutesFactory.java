package factories;

import java.util.ArrayList;
import java.util.List;

import routes.Route;
import routes.RouteAB;
import routes.RouteAD;
import routes.RouteAE;
import routes.RouteBC;
import routes.RouteCD;
import routes.RouteCE;
import routes.RouteDC;
import routes.RouteDE;
import routes.RouteEB;

public class RoutesFactory {

	private static List<Route> routesFromA;

	private static List<Route> routesFromB;

	private static List<Route> routesFromC;

	private static List<Route> routesFromD;

	private static List<Route> routesFromE;

	public static List<Route> createRoutesFromTheCity(final Character cityName) {

		switch (cityName) {
			case 'A':

				if (RoutesFactory.routesFromA == null) {

					RoutesFactory.routesFromA = new ArrayList<Route>();

					RoutesFactory.routesFromA.add(new RouteAB());
					RoutesFactory.routesFromA.add(new RouteAD());
					RoutesFactory.routesFromA.add(new RouteAE());

				}

				return RoutesFactory.routesFromA;

			case 'B':

				if (RoutesFactory.routesFromB == null) {

					RoutesFactory.routesFromB = new ArrayList<Route>();

					RoutesFactory.routesFromB.add(new RouteBC());

				}

				return RoutesFactory.routesFromB;

			case 'C':

				if (RoutesFactory.routesFromC == null) {

					RoutesFactory.routesFromC = new ArrayList<Route>();

					RoutesFactory.routesFromC.add(new RouteCD());
					RoutesFactory.routesFromC.add(new RouteCE());

				}

				return RoutesFactory.routesFromC;

			case 'D':

				if (RoutesFactory.routesFromD == null) {

					RoutesFactory.routesFromD = new ArrayList<Route>();

					RoutesFactory.routesFromD.add(new RouteDC());
					RoutesFactory.routesFromD.add(new RouteDE());

				}

				return RoutesFactory.routesFromD;

			case 'E':

				if (RoutesFactory.routesFromE == null) {

					RoutesFactory.routesFromE = new ArrayList<Route>();

					RoutesFactory.routesFromE.add(new RouteEB());

				}

				return RoutesFactory.routesFromE;

			default:
				return new ArrayList<Route>();

		}

	}

}
