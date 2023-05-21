package ru.geekbrains.lesson6.spr2;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToXML implements Save {
    private Order order;

    public SaveToXML(Order order) {
        this.order = order;
    }

    @Override
    public void saveTo() {
        String fileName = "order.xml";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("<Order>\n");
            writer.write("<clientName>"+ order.getClientName() + "</clientName>\n");
            writer.write("<product>"+order.getProduct()+"</product>n");
            writer.write("<qnt>"+order.getQnt()+"</qnt>\n");
            writer.write("<price>"+order.getPrice()+"</price>\n");
            writer.write("</Order>\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }        
    }
}
