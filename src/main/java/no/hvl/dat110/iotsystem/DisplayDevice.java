package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {

	private static final int COUNT = 10;

	public static void main (String[] args) {

		System.out.println("Display starting ...");

		// TODO - START
		// create a client object and use it to
		String topic = Common.TEMPTOPIC;
		Client display = new Client("display",Common.BROKERHOST,Common.BROKERPORT);
		display.connect();
		display.createTopic(topic);
		display.subscribe(topic);

		for (int i = 0; i < COUNT; i++) {
			Message msg = display.receive();
			if (msg instanceof PublishMsg) {
				String receivedTemp = ((PublishMsg) msg).getMessage();
				System.out.println("Received temperature: " + receivedTemp);
			}
		}
		display.unsubscribe(topic);
		display.disconnect();

		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker

		// TODO - END

		System.out.println("Display stopping ... ");

	}
}
