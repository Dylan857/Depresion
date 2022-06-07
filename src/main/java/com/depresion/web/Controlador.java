package com.depresion.web;

import com.depresion.dto.UsuarioDto;
import com.depresion.dto.UsuarioPsicologoDto;
import com.depresion.model.Cita;
import com.depresion.model.Usuario;
import com.depresion.model.UsuarioPsicologo;
import com.depresion.servicio.CitaService;
import com.depresion.servicio.MailService;
import com.depresion.servicio.UsuarioPsicologoService;
import com.depresion.servicio.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controlador {

    @Autowired
    private CitaService citaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioPsicologoService usuarioPsicologoService;

    @Autowired
    private MailService mailService;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita, RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("emailP") String emailP) {
        citaService.guardar(cita);
        mailService.sendMail(email, "Cita programada", cita.toString());
        mailService.sendMail(emailP, "Cita programada", cita.toString());
        redirectAttributes.addFlashAttribute("mensaje", "Cita generada exitosamente");
        return "redirect:/citas";
    }

    @GetMapping("/citas")
    public String listaCitas(Model model) {
        List<Cita> citas = citaService.listarCitas();
        model.addAttribute("citas", citas);
        return "citas";
    }

    @GetMapping("/editar/{idCita}")
    public String modificarCita(Model model, Cita cita) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        List<UsuarioPsicologo> usuariosPsicologos = usuarioPsicologoService.listarUsuarios();
        model.addAttribute("usuariosPsicologos", usuariosPsicologos);
        cita = citaService.citaFindById(cita);
        model.addAttribute("cita", cita);
        return "modificar";
    }

    @GetMapping("/eliminar/{idCita}")
    public String eliminarCita(Cita cita, RedirectAttributes redirectAttributes) {
        citaService.eliminar(cita);
        redirectAttributes
                .addFlashAttribute("mensaje", "Cita eliminada correctamente");
        return "redirect:/citas";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/generar")
    public String generar(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        List<UsuarioPsicologo> usuariosPsicologos = usuarioPsicologoService.listarUsuarios();
        model.addAttribute("usuariosPsicologos", usuariosPsicologos);
        return "generar";
    }

    @GetMapping("/solicitar")
    public String solicitar(@AuthenticationPrincipal User user, Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(user.getUsername());
        model.addAttribute("usuario", usuario);
        return "solicitar";
    }

    @PostMapping("/enviar")
    public String enviar(RedirectAttributes redirectAttributes, @RequestParam("numeroDocumento") String numeroDocumento, @RequestParam("email") String email, @RequestParam("asunto") String asunto, @RequestParam("mensaje") String mensaje) {
        String mensajeC = "De: " + email + "\n Numero de documento: " + numeroDocumento + "\n Asunto: " + asunto + "\n Mensaje: " + mensaje;
        mailService.sendMail("dylanvazquez0904@gmail.com", asunto, mensajeC);
        redirectAttributes.addFlashAttribute("mensaje", "Gracias por ponerse en contacto con nosotros, en breve le daremos respuesta");
        return "redirect:/solicitar";
    }

    @GetMapping("/perfil")
    public String perfil(Model model, Usuario usuario, @AuthenticationPrincipal User user, Cita cita) {
        usuario = usuarioService.encontrarUsuario(user.getUsername());
        cita = citaService.buscarCitaByUsuario(usuario);
        model.addAttribute("cita", cita);
        return "perfil";
    }

    @PostMapping("/registroAdmin")
    public String registrarUsuarioAdmin(@ModelAttribute("usuario") UsuarioDto usuarioDto, RedirectAttributes redirectAttributes) {
        Usuario usuarioUser = usuarioService.encontrarUsuario(usuarioDto.getUsuario());
        Usuario usuarioNumero = usuarioService.encontrarUsuarioPorNumero(usuarioDto.getNumeroDocumento());
        Usuario usuarioEmail = usuarioService.encontrarUsuarioPorEmail(usuarioDto.getEmail());
        if (usuarioUser != null) {
            redirectAttributes.addFlashAttribute("mensaje", "El usuario");
            return "redirect:/perfil?errorUsuario";
        } else if (usuarioNumero != null) {
            return "redirect:/perfil?errorNumero";
        } else if (usuarioEmail != null) {
            return "redirect:/perfil?errorEmail";
        } else {
            Usuario usuario = usuarioService.guardarUsuarioAdmin(usuarioDto);
            mailService.sendMail(usuario.getEmail(), "Registro exitoso", "Datos de la persona registrada: \n" + usuario.toString());
            redirectAttributes.addFlashAttribute("mensaje", "Usuario registrado con exito");
            return "redirect:/perfil";
        }

    }

    @PostMapping("/registroPsicologo")
    public String registrarUsuarioPsicologo(@ModelAttribute("usuarioPsicologo") UsuarioPsicologoDto usuarioPsicologoDto, RedirectAttributes redirectAttributes) {
        UsuarioPsicologo usuarioUser = usuarioPsicologoService.encontrarUsuario(usuarioPsicologoDto.getUsuario());
        UsuarioPsicologo usuarioNumero = usuarioPsicologoService.encontrarUsuarioPorNumero(usuarioPsicologoDto.getNumeroDocumento());
        UsuarioPsicologo usuarioEmail = usuarioPsicologoService.encontrarUsuarioPorNumero(usuarioPsicologoDto.getEmail());
        if (usuarioUser != null) {
            return "redirect:/perfil?errorUsuarioPsicologo";
        } else if (usuarioNumero != null) {
            return "redirect:/perfil?errorNumeroPsicologo";
        } else if (usuarioEmail != null) {
            return "redirect:/perfil?errorEmailPsicologo";
        } else {
            UsuarioPsicologo usuarioPsicologo = usuarioPsicologoService.guardarUsuario(usuarioPsicologoDto);
            mailService.sendMail(usuarioPsicologo.getEmail(), "Registro exitoso", "Datos de la persona registrada: \n" + usuarioPsicologo.toString());

            redirectAttributes.addFlashAttribute("mensaje", "Usuario registrado con exito");
            return "redirect:/perfil";
        }
    }

}
