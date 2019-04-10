package moz.outils.intranet.Banque.Tools;

import moz.outils.intranet.Banque.DTO.MesureDTO;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    public List<List<Object>> convertMesureDTOtoTab(List<MesureDTO> mesureDTOList) {
        List<List<Object>> matrice = new ArrayList<>();
        for (MesureDTO mesureDTO : mesureDTOList) {
            List<Object> list = new ArrayList<>();
            Long timestampMilli = Long.valueOf(mesureDTO.getTimestamp());
            list.add(timestampMilli * 1000);
            list.add(mesureDTO.getMontant());
            matrice.add(list);
        }
        return matrice;
    }
}
