/* ================================================================
 * El archivo "HomeController"  fue creado para Y.P.F.B. Corporación, todos los Derechos reservados 
 * Desarrollador: Renato Apaza Tito (rapaza@ypfb.gob.bo)
 * Fecha: 4/7/20 15:43
 * ==============================================================
 */
package com.rapaza.kafka.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping("/home")
    String home(Model model){

        return "home"
    }
}
