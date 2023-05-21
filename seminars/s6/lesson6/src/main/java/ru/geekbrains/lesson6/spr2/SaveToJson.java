package ru.geekbrains.lesson6.spr2;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToJson implements Save {
    private Order order;

    public SaveToJson(Order order) {
        this.order = order;
    }

    @Override
    public void saveTo() {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+order.getProduct()+"\",\n");
            writer.write("\"qnt\":"+order.getQnt()+",\n");
            writer.write("\"price\":"+order.getPrice()+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
