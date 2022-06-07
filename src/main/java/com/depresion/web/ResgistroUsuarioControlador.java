package com.depresion.web;

import com.depresion.dto.UsuarioDto;
import com.depresion.model.Usuario;
import com.depresion.servicio.MailService;
import com.depresion.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class ResgistroUsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private MailService mailService;

    @ModelAttribute("usuario")
    public UsuarioDto retornarNuevoUsuario() {
        return new UsuarioDto();
    }

    @GetMapping
    public String mostrarFormulario() {
        return "registro";
    }

    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioDto usuarioDto, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuarioUser = usuarioService.encontrarUsuario(usuarioDto.getUsuario());
        Usuario usuarioNumero = usuarioService.encontrarUsuarioPorNumero(usuarioDto.getNumeroDocumento());
        Usuario usuarioEmail = usuarioService.encontrarUsuarioPorEmail(usuarioDto.getEmail());
        if (usuarioUser != null) {
            model.addAttribute("usuario", usuarioDto.getUsuario());
            redirectAttributes.addFlashAttribute("mensaje", "El usuario");
            return "redirect:/registro?errorUsuario";
        } else if (usuarioNumero != null) {
            model.addAttribute("usuarioNumero", usuarioDto.getNumeroDocumento());
            return "redirect:/registro?errorNumero";
        } else if (usuarioEmail != null) {
            model.addAttribute("usuarioEmail", usuarioEmail);
            return "redirect:/registro?errorEmail";
        }
        else {
            Usuario usuario = usuarioService.guardarUsuario(usuarioDto);
            mailService.sendMail(usuario.getEmail(), "Registro exitoso", "Datos de la persona registrada: \n" + usuario.toString());
            return "redirect:/registro?exito";
        }
        
    }
    
    

}
