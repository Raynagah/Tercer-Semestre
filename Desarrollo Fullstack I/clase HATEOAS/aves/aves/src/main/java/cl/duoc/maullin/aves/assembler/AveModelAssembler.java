package cl.duoc.maullin.aves.assembler;

import cl.duoc.maullin.aves.controller.AveController;
import cl.duoc.maullin.aves.model.Ave;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class AveModelAssembler implements RepresentationModelAssembler <Ave, EntityModel<Ave>> {

    @Override
    public EntityModel<Ave> toModel(Ave ave){
        return EntityModel.of(ave,
                linkTo(methodOn(AveController.class).unaAve(ave.getId())).withSelfRel(),
                linkTo(methodOn(AveController.class).todasLasAves()).withRel("aves")
                );

    }


}
