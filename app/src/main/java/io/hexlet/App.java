package io.hexlet;

import io.hexlet.mindgames.Cli;

public class App {

	private final Cli cli = new Cli();

	private void start() {
		String user = cli.requestName();
		cli.greetUser(user);
	}

	public static void main(String[] args) {
		new App().start();
	}
}
