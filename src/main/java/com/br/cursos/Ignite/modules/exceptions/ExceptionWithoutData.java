package com.br.cursos.Ignite.modules.exceptions;



public class ExceptionWithoutData extends RuntimeException{

    public ExceptionWithoutData(String message) {
        super(message);
    }

    public static void getMessage(String s) {
    }
}
