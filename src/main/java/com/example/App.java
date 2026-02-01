package com.example;

import java.util.logging.Logger;

public class App {

    static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.valueOf(calc.calculate(10, 5, "add")));
        }

        UserService service = new UserService();
        service.findUser("admin");
    }
}

