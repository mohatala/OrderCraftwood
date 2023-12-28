package craft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import craft.model.Commande;
import craft.service.I_Commande;
import craft.model.Article;
import craft.model.Client;
import craft.service.I_Article;
import craft.service.I_Client;

@Controller
@RequestMapping("/commande")
public class CommandeController {
	
	@Autowired
    private I_Commande cmdDao ;
	
	@Autowired
	private I_Article artDao;
	
	@Autowired
	private I_Client cliDao;
	
	@GetMapping("/")
	public String listcommandes(Model md) {
		System.out.println(cmdDao.afficherCommandes());
		md.addAttribute("datacmd",cmdDao.afficherCommandes());
		return "list_cmd";
	}
	
	@GetMapping("/Add")
	public String addcommande(Model md) {
		md.addAttribute("articles", artDao.afficherArticles());
		return "commande";
	}
	
	@GetMapping("/show")
	public String showcommande(Model md,@PathVariable int id) {
		md.addAttribute("datacmd", cmdDao.afficherInfosCommande(id));
		return  "Infos";
	}
	@GetMapping("/Delete/{id}")
	public String deletecommande(Model md,@PathVariable int id) {
		if(cmdDao.supprimeCommandes(id)) {
			md.addAttribute("datacmd", cmdDao.afficherCommandes());
			return "list_cmd";
		}
		return null;
	}
	
	@GetMapping("/cl")
	public void showclient(Model md,HttpServletResponse response) {
		String nomclient = md.getAttribute("nom").toString();
		
		if(nomclient != null){
			List<Client> ar= cliDao.afficherClients();
			List client = ar.stream().filter(i ->i.getNom().equals(nomclient)).collect(Collectors.toList());
			String toJson = new Gson().toJson(client);
			//System.out.print(toJson);
			response.setContentType("application/json");
			try {
				response.getWriter().write(toJson);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@GetMapping("/ar")
	public void showarticle(Model md,HttpServletResponse response) {
		String libelle = md.getAttribute("nom").toString();
		if(libelle != null){
			List<Article> ar= artDao.afficherArticles();
			List article = ar.stream().filter(i ->i.getLibelle().equals(libelle)).collect(Collectors.toList());
			String toJson = new Gson().toJson(article);
			//System.out.print(toJson);
			response.setContentType("application/json");
			try {
				response.getWriter().write(toJson);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
