package cl.duoc.maullin.aves.controller;

import cl.duoc.maullin.aves.model.Ave;
import cl.duoc.maullin.aves.service.AveService;
import cl.duoc.maullin.aves.assembler.AveModelAssembler;

import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/aves")
public class AveController {
    //Creamos 2 instancias
    private final AveService service;
    private final AveModelAssembler assembler;

    public AveController(AveService service, AveModelAssembler assembler){
        this.service = service;
        this.assembler = assembler;
    }

    //Obtener
    @GetMapping
    public CollectionModel<EntityModel<Ave>> todasLasAves(){
        List<EntityModel<Ave>>  aves = service.listar().stream()
                .map(assembler::toModel).toList();

        return CollectionModel.of(aves,
                linkTo(methodOn(AveController.class).todasLasAves()).withSelfRel());
    }

    //Buscar
    @GetMapping("/{id}")
    public EntityModel<Ave> unaAve(@PathVariable Long id){
        return assembler.toModel(service.buscar(id));
    }
    //Guardar
    @PostMapping
    public EntityModel<Ave> crear(@RequestBody Ave ave){
        Ave guardada = service.guardar(ave);
        return assembler.toModel(guardada);
    }

    //Actualizar
    @PutMapping("/{id}")
    public EntityModel<Ave> actualizar (@PathVariable Long id,@RequestBody Ave nueva){
        Ave actualizada = service.actualizar(id,nueva);
        return assembler.toModel(actualizada);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
}
