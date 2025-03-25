package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		// create a client object and use it to
		Client sensor = new Client("sensor",Common.BROKERHOST,Common.BROKERPORT);
		sensor.connect();

		for (int i = 0; i < COUNT; i++) {
			sensor.publish(Common.TEMPTOPIC,String.valueOf(sn.read()));
		}
		sensor.disconnect();

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker

		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}
