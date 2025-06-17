package cl.duoc.maullin.aves.service;

import cl.duoc.maullin.aves.model.Ave;
import cl.duoc.maullin.aves.repository.AveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AveService {

    //Creación de instancia para trabajar
    private final AveRepository repo;

    public AveService(AveRepository repo){
        this.repo = repo;
    }

    //Metodo buscar o listar
    public List<Ave> listar(){
        return repo.findAll();
    }

    //Buscar un ave
    public Ave buscar(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("No se encontró un Ave."));
    }

    //Agregar un ave
    public Ave guardar(Ave ave){
        return repo.save(ave);
    }

    //Actualizar un ave
    public Ave actualizar (Long id, Ave nuevaAve){
        return repo.findById(id).map(ave->{
            ave.setNombre(nuevaAve.getNombre());
            ave.setEspecie(nuevaAve.getEspecie());
            ave.setUbicacion(nuevaAve.getUbicacion());
            return repo.save(ave);
        }).orElseThrow(()->new RuntimeException("Ave no encontrada para actualizar."));
    }

    //Eliminar un ave
    public void eliminar(Long id){
        repo.deleteById(id);
    }








}
