package clase2.demo.controller;


import clase2.demo.entity.Region;
import clase2.demo.entity.Territory;
import clase2.demo.repository.RegionRepository;
import clase2.demo.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/territories")
public class TerritoryController {

    @Autowired
    TerritoryRepository territoryRepository;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping(value={"","/lista"})
    public String listaTerritories(Model model){
        List<Territory> listaTerritories = territoryRepository.findAll();
        model.addAttribute("lista",listaTerritories);
        return "territory/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoTerritory(Model model){
        List<Region> listaRegiones = regionRepository.findAll();
        model.addAttribute("listaRegiones",listaRegiones);
        return"territory/formulario";
    }

    @GetMapping("/editar")
    public String editarTerritory(@RequestParam("id") String id, Model model){
        Optional<Territory> opt = territoryRepository.findById(id);
        List<Region> listaRegiones = regionRepository.findAll();
        if(opt.isPresent()){
            Territory territoryAEditar = opt.get();

            model.addAttribute("territory",territoryAEditar);
            model.addAttribute("listaRegiones",listaRegiones);
            return "territory/editar";
        }else{
            return "redirect:/territories/lista";
        }
    }

    @PostMapping("/guardar")
    public String guardarTerritory(Territory territory) {
        territoryRepository.save(territory);
        return "redirect:/territories/lista";
    }

}
