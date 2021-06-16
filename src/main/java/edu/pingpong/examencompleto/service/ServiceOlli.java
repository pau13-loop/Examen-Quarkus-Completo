package edu.pingpong.examencompleto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import edu.pingpong.examencompleto.domain.Item;
import edu.pingpong.examencompleto.domain.Usuaria;
import edu.pingpong.examencompleto.domain.Orden;

@ApplicationScoped
public class ServiceOlli {

    private static final Item itemNoExist = new Item("", 0, "");
    private static final Usuaria usuNoExist = new Usuaria("", 0);
    
    public ServiceOlli() {}

    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usu = Usuaria.find("nombre", nombre).firstResultOptional();
        // Usuaria usuNoExist = new Usuaria("", 0);


        return usu.isPresent()? usu.get() : usuNoExist;
    }

    public Item cargaItem(String nombre) {
        Optional<Item> item = Item.find("nombre", nombre).firstResultOptional();
        // Item itemNoExist = new Item("", 0, "");

        return item.isPresent()? item.get() : itemNoExist;
    }

    public List<Orden> cargaOrden(String nombre) {
        Stream<Orden> orden = Orden.streamAll();
        
        return orden.filter(o -> o.usuaria.nombre.equals(nombre)).collect(Collectors.toList());
    }

    public Orden comanda(String nombreUsu, String nombreItem) {
        Optional<Usuaria> usu = Usuaria.find("nombre", nombreUsu).firstResultOptional();
        Optional<Item> item = Item.find("nombre", nombreItem).firstResultOptional();

        if (usu.isPresent() && item.isPresent()) {
            Orden orden = new Orden(usu.get(), item.get());
            orden.persist();
            return orden;
        } else {
            return null;
        }
    }

}
