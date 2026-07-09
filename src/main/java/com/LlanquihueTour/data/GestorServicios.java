package com.LlanquihueTour.data;


import com.LlanquihueTour.model.ExcursionCultural;
import com.LlanquihueTour.model.PaseoLacustre;
import com.LlanquihueTour.model.RutaGastronomica;
import com.LlanquihueTour.model.ServicioTuristico;

import java.util.ArrayList;

public class GestorServicios {



    public ArrayList<ServicioTuristico> generarTuristicos() {

        ArrayList<ServicioTuristico> turisticos = new ArrayList<>();

        turisticos.add(new RutaGastronomica(3.5f, "Sabores del Sur", 5));
        turisticos.add(new RutaGastronomica(4.0f,"Ruta del Asado Patagónico", 3));

        turisticos.add(new PaseoLacustre(2.5f, "Travesía Lago Llanquihue", "Catamarán"));
        turisticos.add(new PaseoLacustre(1.5f, "Paseo en Kayak", "Kayak doble"));

        turisticos.add(new ExcursionCultural(2.0f, "Museo Colonial", "Fuerte San Antonio"));
        turisticos.add(new ExcursionCultural(3.0f, "Ciudad Patrimonial", "Iglesia de Piedra"));


        return turisticos;
    }

}
