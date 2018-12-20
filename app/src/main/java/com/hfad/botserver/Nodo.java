package com.hfad.botserver;

import java.io.OutputStream;
import java.io.PrintStream;

public class Nodo {

    private String name;
    private String sensorName;
    private String actuadorName;
    private PrintStream printStream;

    public Nodo(String name, String sensorName, String actuadorName, PrintStream printStream) {
        this.name = name;
        this.sensorName = sensorName;
        this.actuadorName = actuadorName;
        this.printStream = printStream;
    }

    public Nodo(String name, PrintStream printStream) {
        this.name = name;
        this.sensorName = "sensor";
        this.actuadorName = "actuador";
        this.printStream = printStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getActuadorName() {
        return actuadorName;
    }

    public void setActuadorName(String actuadorName) {
        this.actuadorName = actuadorName;
    }

    public void processData(String data)
    {
        if(data.equalsIgnoreCase("/sensor1\n"))
        {
            String msj;
            msj = this.name + " SENSOR 1 ON";
            System.out.println("ENVIAR ESTADO SENSOR");
            XMPPCliente.getInstance().sendMsj(msj);
        }
    }

    public void processDataRecibido(String from,String msj)
    {
        printStream.print(msj);
    }
}
