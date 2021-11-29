package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.MascotaDAO;
import com.disenio.dto.mascota.MascotaDTO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import com.disenio.services.mascotas.MascotaFotoService;
import com.disenio.services.mascotas.MascotasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class MascotasServiceImpl implements MascotasService {

    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MascotaDAO mascotaDAO;
    @Autowired
    private CaracteristicaDetalleService caracteristicaDetalleService;
    @Autowired
    private MascotaFotoService mascotaFotoService;

    @Override
    public Optional<Mascota> getById(int id) {
        Optional<Mascota> mascota = mascotaDAO.findById(id);

        return mascota;
    }

    @Transactional
    @Override
    public void alta(List<Mascota> mascotas, Persona persona) {
        mascotas.forEach(mascota -> {
            mascota.setPersona(persona);
            //AltaMascota
            Mascota rtaMascota = mascotaDAO.save(mascota);

            mascotaFotoService.alta(mascota.getMascotaFotos(), rtaMascota);

            caracteristicaDetalleService.alta(mascota.getCaracteristicaDetalles(), rtaMascota);

        });

    }

    @Override
    public List<MascotaDTO> getMascotasAll() {

        List<Mascota> mascotas  =mascotaDAO.findAll();


        List<MascotaDTO> mascotaDTO = new ArrayList<MascotaDTO>();
        if (!mascotas.isEmpty()) {
            mascotaDTO = Arrays.asList(modelMapper.map(mascotas, MascotaDTO[].class));
        }
        return mascotaDTO;
    }

    @Override
    public MascotaDTO getMascotaDTOById(Integer id) {
        Optional<Mascota> mascotas  =mascotaDAO.findById(id);


        MascotaDTO mascotaDTO = null;
        if (mascotas.isPresent()) {
            mascotaDTO= new MascotaDTO();
            mascotaDTO = modelMapper.map(mascotas.get(), MascotaDTO.class);
        }
        return mascotaDTO;
    }

    @Override
    public MascotaDTO getMascotaByPersonasId(Integer idPersona) {
        Optional<Mascota> mascotas  =mascotaDAO.MascotaByPersonasId(idPersona);


        MascotaDTO mascotaDTO = null;
        if (mascotas.isPresent()) {
            mascotaDTO= new MascotaDTO();
            mascotaDTO = modelMapper.map(mascotas.get(), MascotaDTO.class);
        }
        return mascotaDTO;
    }

    @Override
    public List<Mascota> getAllMascotasByIdPersona(Integer idPersona) {
        List<Mascota> mascotas  =mascotaDAO.MascotasSegunID(idPersona).get();
        return mascotas;
    }

}
