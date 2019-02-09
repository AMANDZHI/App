package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
	 Initializer initializer = new Initializer();
	 initializer.run();

    }
}