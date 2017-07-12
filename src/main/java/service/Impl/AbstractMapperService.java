package service.Impl;

import dto.InitDTO;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import persistence.InitEntity;

/**
 * Created by BSyvuliak on 13.07.2017.
 */
public abstract class AbstractMapperService<E extends InitEntity, DTO extends InitDTO> {

    ModelMapper entityMapper = initiateModelMapper();
    ModelMapper dtoMapper = initiateModelMapper();

    public void initMap(ModelMapper entityMapper, ModelMapper dtoMapper){

        entityMapper.getConfiguration().setPropertyCondition(new Condition<E, DTO>() {
            @Override
            public boolean applies(MappingContext<E, DTO> context) {
                return context.getSource()!=null;
            }
        });

    }

    public ModelMapper initiateModelMapper() {
        return new ModelMapper();
    }

    protected DTO toDTO(E entity) {
        return entity != null ? dtoMapper.map(entity, getDTOClass()) : null;
    }

    protected E toEntity(DTO dto) {
        return dto != null ? entityMapper.map(dto, getEntityClass()) : null;
    }

    protected abstract Class<DTO> getDTOClass();

    protected abstract Class<E> getEntityClass();


}
