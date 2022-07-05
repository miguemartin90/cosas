package main;

import controlador.EquipoControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.EquipoModelImpl;
import vista.EquipoViewImpl;
import modelo.EquipoModel;
import vista.EquipoView;
import controlador.EquipoController;

public class Main {

    public static void main(String[] args) {

        EquipoModel model = new EquipoModelImpl();
        List<EquipoView> views = new ArrayList<EquipoView>();
        EquipoView view1 = new EquipoViewImpl();
        views.add(view1);

        EquipoController controller = new EquipoControllerImpl();

        controller.setup(model, views);
        controller.start();
    }

}
