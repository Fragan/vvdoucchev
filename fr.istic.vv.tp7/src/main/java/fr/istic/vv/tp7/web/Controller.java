package fr.istic.vv.tp7.web;

import fr.istic.vv.tp7.domain.Address;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/addresses")
@org.springframework.stereotype.Controller
@RooWebScaffold(path = "addresses", formBackingObject = Address.class)
public class Controller {
}
