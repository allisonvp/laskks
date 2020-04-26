package clase2.demo.controller;

import clase2.demo.entity.Shipper;
import clase2.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository;


    @GetMapping(value = {"","/listar"})
    public String listaShippers(Model model){

        List<Shipper> listaShippers = shipperRepository.findAll();
        model.addAttribute("lista", listaShippers);
        return "shipper/lista";
    }

    @PostMapping(value = "buscarTransportista")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model){
        List<Shipper> listaTransportistas = shipperRepository.buscarTransportistasPorNombre(searchField);
        model.addAttribute("lista", listaTransportistas);
        return "shipper/lista";
    }

    @GetMapping(value = "/nuevo")
    public String nuevoTransportista(){
        return "shipper/crear";
    }

    @PostMapping(value="/guardar")
    public String guardarTransportista(Shipper shipper, RedirectAttributes attr){
        if(shipper.getShipperid()==0){
            attr.addFlashAttribute("msg","Transportista creado exitosamente");
        }else{
            attr.addFlashAttribute("msg","Transportista actualizado exitosamente");
        }
        shipperRepository.save(shipper);
        return "redirect:/shipper";
    }

    @GetMapping("/editar")
    public String editarShipper(@RequestParam("idDelShipper") int id,
                                Model model){
        Optional<Shipper> opt = shipperRepository.findById(id);
        if(opt.isPresent()){
            Shipper shipperAEditar = opt.get();
            model.addAttribute("shipperAEditar", shipperAEditar);
            return "shipper/editar";
        }else{
            return "redirect:/shipper";
        }

    }

    @GetMapping("/borrar")
    public String borrarShipper(@RequestParam("idDelShipper") int id){
        Optional<Shipper> opt = shipperRepository.findById(id);
        if (opt.isPresent()){
            shipperRepository.deleteById(id);
        }
        return "redirect:/shipper";

    }



}
