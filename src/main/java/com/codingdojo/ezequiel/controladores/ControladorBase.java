package com.codingdojo.ezequiel.controladores;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @ = anotacion
//Dictando es un cotrolador -> API REST, regresar literalmente el return de mi metodo
@RestController //Indica que este archivo es un controlador del tipo API REST
@RequestMapping("/usuarios") //Una base para todas las rutas que cree en este archivo
public class ControladorBase {
	@GetMapping("/") //Establecemos la ruta a mostrar, NO puede repetirse
	public String home() {
		return "<h1>¡Hola desde Spring!</h1>";
	}
	
	@GetMapping("/despliega") 
	public String despliegaUsuarios() {
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		String respuesta = "";
		
		for(int i = 0; i < usuarios.length; i++) {
			respuesta += "<h2>" + usuarios[i] + "</h2>";
		}
		return respuesta;
	}
	
	// usuarios/hola?nombre=Elena
	@GetMapping("/hola")
	public String hola(@RequestParam(value= "nombre", required=false) String name) {
		if(name == null) {
			return "<h1>¡Hola!</h1>";
		} 
		return "<h1>¡Hola " + name + "!</h1>";
	}
	
	@GetMapping("/saludos") // usuarios/saludos?nombre=Elena&apellido=De%20Troya
	public String saludos(@RequestParam(value="nombre") String name,
						  @RequestParam(value="apellido") String last_name) {
		return "<h1>Saludos cordiales, " + name + " " + last_name + "</h1>";
	}
	
	
	/*/hello/Elena */
	@GetMapping("/hello/{nombre}")
	public String hello(@PathVariable("nombre") String name) {
		return "<h2>Hello " + name + "</h2>";
	}
	
	
	@GetMapping("/hello/{nombre}/{apellido}")	/* /usuarios/hello/Elena/De Troya */
	public String hello(@PathVariable("nombre") String name,
						@PathVariable("apellido") String last_name) {
		return "<h2>Hello " + name + " " + last_name + "</h2>";
	}
	
	@GetMapping("/hello/{nombre}/{apellido}/{cantidad}") /* /usuarios/hello/Elena/De Troya/5 */
	public String hello(@PathVariable("nombre") String name,
			            @PathVariable("apellido") String last_name,
			            @PathVariable("cantidad") int cantidad) {
		String respuesta = "<ul>";
		for(int i = 0; i < cantidad; i++) {
			respuesta += "<li>" + name + " " + last_name + "</li>";
		}
		respuesta += "</ul>";
		return respuesta;
	}
	
}
