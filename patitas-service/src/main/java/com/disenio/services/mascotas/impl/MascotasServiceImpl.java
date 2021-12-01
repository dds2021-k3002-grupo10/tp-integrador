package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.MascotaDAO;
import com.disenio.dto.mascota.AltaMascotaDTO;
import com.disenio.dto.mascota.CaracteristicaDetalleResumidoDTO;
import com.disenio.dto.mascota.CaracteristicaDetalleValorResumidoDTO;
import com.disenio.dto.mascota.MascotaDTO;
import com.disenio.model.faq.FaqRespuestaValor;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.model.personas.Persona;
import com.disenio.services.mascotas.*;
import com.disenio.services.personas.PersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class MascotasServiceImpl implements MascotasService {

    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    SexoMascotaService sexoMascotaService;
    @Autowired
    TipoMascotaService tipoMascotaService;
    @Autowired
    private MascotaDAO mascotaDAO;
    @Autowired
    private CaracteristicaDetalleService caracteristicaDetalleService;
    @Autowired
    private MascotaFotoService mascotaFotoService;
    @Autowired
    private PersonaService personaService;

    @Override
    public Optional<Mascota> getById(int id) {
        Optional<Mascota> mascota = mascotaDAO.findById(id);

        return mascota;
    }

    @Transactional
    @Override
    public AltaMascotaDTO alta(AltaMascotaDTO altaMascotaDTO) {

        Mascota mascota = null;
        AltaMascotaDTO rtaAltaMascotaDTO = new AltaMascotaDTO();
        try {
            mascota = setMascota(altaMascotaDTO);

            //AltaMascota
            mascotaDAO.save(mascota);

            //AltaFotos
            mascotaFotoService.alta(altaMascotaDTO.getValorFoto(), mascota);

            //AltaCaracteristicas de la mascota
            caracteristicaDetalleService.alta(altaMascotaDTO.getCaracteristicas(), mascota);


            //set datos a devolver//

            rtaAltaMascotaDTO.setIdMascota(mascota.getIdMascota());
            rtaAltaMascotaDTO.setNombre(mascota.getNombre());
            rtaAltaMascotaDTO.setApodo(mascota.getApodo());
            rtaAltaMascotaDTO.setUrl("https://patitas/mascota-perdida.html%22");
            rtaAltaMascotaDTO.setRespuesta("OK");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return rtaAltaMascotaDTO;
    }

    @Override
    public List<MascotaDTO> getMascotasAll() {

        List<Mascota> mascotas = mascotaDAO.findAll();


        List<MascotaDTO> mascotaDTO = new ArrayList<MascotaDTO>();
        if (!mascotas.isEmpty()) {
            mascotaDTO = Arrays.asList(modelMapper.map(mascotas, MascotaDTO[].class));
        }
        return mascotaDTO;
    }

    @Override
    public MascotaDTO getMascotaDTOById(Integer id) {
        Optional<Mascota> mascotas = mascotaDAO.findById(id);


        MascotaDTO mascotaDTO = null;
        if (mascotas.isPresent()) {
            mascotaDTO = new MascotaDTO();
            mascotaDTO = modelMapper.map(mascotas.get(), MascotaDTO.class);

            List<CaracteristicaDetalleResumidoDTO> caracteristicaDetalleValorResumidoDTO = new ArrayList<>();

            /*aca seteamos las caracteristicas de la mascota mas resumido*/
            for (CaracteristicaDetalle caracteristicaDetalle : mascotas.get().getCaracteristicaDetalles()) {

                CaracteristicaDetalleResumidoDTO caracteristicaDetalleResumidoDTO = new CaracteristicaDetalleResumidoDTO();

                caracteristicaDetalleResumidoDTO.setIdDetalle(caracteristicaDetalle.getIdDetalle());
                caracteristicaDetalleResumidoDTO.setDescripcionFaq(caracteristicaDetalle.getFaq().getDescripcionFaq());
                caracteristicaDetalleResumidoDTO.setIdFaq(caracteristicaDetalle.getFaq().getIdFaq());

                List<CaracteristicaDetalleValorResumidoDTO> caracteristicaDetalleValorResumidoDTOList = new ArrayList<>();
                for (FaqRespuestaValor caracteristicaDetalleValor : caracteristicaDetalle.getFaqRespuestaValor()) {
                    CaracteristicaDetalleValorResumidoDTO caracteristicaDetalleValor1 = new CaracteristicaDetalleValorResumidoDTO();

                    caracteristicaDetalleValor1.setIdDetalle(caracteristicaDetalle.getIdDetalle());
                    caracteristicaDetalleValor1.setDescripcion(caracteristicaDetalleValor.getDescripcion());
                    caracteristicaDetalleValor1.setIdRespuestaValor(caracteristicaDetalleValor.getIdRespuestaValor());
                    caracteristicaDetalleValorResumidoDTOList.add(caracteristicaDetalleValor1);
                }

                caracteristicaDetalleResumidoDTO.setCracteristicaDetalleValorResumidoDTO(caracteristicaDetalleValorResumidoDTOList);

                caracteristicaDetalleValorResumidoDTO.add(caracteristicaDetalleResumidoDTO);

            }

            mascotaDTO.setCaracteristicaDetalleValorResumidoDTO(caracteristicaDetalleValorResumidoDTO);
        }

        return mascotaDTO;
    }

    @Override
    public List<MascotaDTO> getMascotaByPersonasId(Integer idPersona) {
        List<Mascota> mascotas = mascotaDAO.MascotaByPersonasId(idPersona);

        List<MascotaDTO> mascotaDTO = new ArrayList<MascotaDTO>();
        if (!mascotas.isEmpty()) {
            mascotaDTO = Arrays.asList(modelMapper.map(mascotas, MascotaDTO[].class));
        }
        return mascotaDTO;
    }

    @Override
    public List<Mascota> getAllMascotasByIdPersona(Integer idPersona) {
        List<Mascota> mascotas = mascotaDAO.MascotasSegunID(idPersona).get();
        return mascotas;
    }

    private Mascota setMascota(AltaMascotaDTO altaMascotaDTO) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        /*fecha Nacimiento a DAte*/
        Date fechaNacimiento = formato.parse(altaMascotaDTO.getFechaNacimiento());
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);
        /*fechaActual*/
        Calendar fechaActualCalendar = Calendar.getInstance();
        Integer edad = 0;
        /*edad*/
        int año = fechaActualCalendar.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);
        int mes = fechaActualCalendar.get(Calendar.MONTH) - fechaNacimientoCal.get(Calendar.MONTH);
        int dia = fechaActualCalendar.get(Calendar.DATE) - fechaNacimientoCal.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }
        edad = año;

        Mascota mascota = new Mascota();
        mascota.setApodo(altaMascotaDTO.getApodo());
        mascota.setNombre(altaMascotaDTO.getNombre());
        mascota.setDescripcionFisica(altaMascotaDTO.getDescripcionFisica());
        mascota.setFechaNacimiento(fechaNacimientoCal);
        mascota.setEdad(edad);
        mascota.setFechaAlta(fechaActualCalendar);
        mascota.setFechaUltimaModificacion(fechaActualCalendar);
        mascota.setEstado('A');

        Optional<Persona> persona = personaService.getPersonasById(altaMascotaDTO.getIdPersona());
        mascota.setPersona(persona.get());

        SexoMascota sexoMascota = sexoMascotaService.getById(altaMascotaDTO.getIdSexo());
        mascota.setSexoMascota(sexoMascota);

        TipoMascota tipoMascota = tipoMascotaService.getById(altaMascotaDTO.getIdTipoMascota());
        mascota.setTipoMascota(tipoMascota);


        return mascota;
    }


    @Override
    public List<MascotaDTO> getMascotaByPersonasByCondicion(Integer idTipoDoc, Integer numero) {
        List<Mascota> mascotas = mascotaDAO.getMascotaByPersonasByCondicion(idTipoDoc, numero);

        List<MascotaDTO> mascotaDTO = new ArrayList<MascotaDTO>();
        if (!mascotas.isEmpty()) {
            mascotaDTO = Arrays.asList(modelMapper.map(mascotas, MascotaDTO[].class));
        }
        return mascotaDTO;
    }

}
