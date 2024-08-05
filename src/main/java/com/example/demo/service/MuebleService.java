package com.example.demo.service;

import com.example.demo.domain.Fabricante;
import com.example.demo.domain.Mueble;
import com.example.demo.dto.MuebleDTO;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.mapper.MuebleMapper;
import com.example.demo.repository.FabricanteRepository;
import com.example.demo.repository.MuebleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MuebleService {

    @Autowired
    private final MuebleRepository muebleRepository;

    @Autowired
    private final FabricanteRepository fabricanteRepository;

    // Obtener todos los muebles
    public List<MuebleDTO> getAllMuebles(){
        List<Mueble> lista = muebleRepository.findAll();
        return lista.stream()
                .map(MuebleMapper::toDTO)
                .toList();
    }

    // Obtener un mueble en particular por id
    public MuebleDTO getMuebleById(Long id) throws NotFoundException {
        Optional<Mueble> mueble = muebleRepository.findById(id);
        if (mueble.isEmpty()) {
            throw new NotFoundException("No se encontró el mueble deseado");
        } else {
            return MuebleMapper.toDTO(mueble.get());
        }
    }

    @Transactional
    // Subir a la base de datos un mueble nuevo
    public MuebleDTO create(MuebleDTO body) throws NotFoundException, BadRequestException{
        if (body.getCantDisponible() < 0) {
            throw new BadRequestException("El stock no puede ser menor a 0");
        }
        if (body.getNombre().isEmpty()) {
            throw new BadRequestException("El nombre del mueble no puede estar vacío");
        }
        if (body.getFabricanteId() == null) {
            throw new BadRequestException("Se debe ingresar fabricante del mueble");
        }


        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(body.getFabricanteId());
        if (fabricanteOptional.isEmpty()) {
            throw new NotFoundException("No se encontró el fabricante deseado");
        } else {
            Mueble album1 = muebleRepository.save(MuebleMapper.toEntity(body, fabricanteOptional.get()));
            return MuebleMapper.toDTO(album1);
        }
    }

}
