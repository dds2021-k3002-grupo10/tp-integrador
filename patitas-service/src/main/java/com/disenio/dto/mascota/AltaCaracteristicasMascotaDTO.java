package com.disenio.dto.mascota;

import lombok.Data;

import java.util.List;

@Data
public class AltaCaracteristicasMascotaDTO {
    private Integer idFaq;
    private List<AltaValorMascotaDTO> altaValorMascotaDTOlist;
}
