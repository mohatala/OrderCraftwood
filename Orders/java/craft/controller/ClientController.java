package craft.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import craft.service.I_Client;
import craft.model.Client;
@Controller
@RequestMapping("/client")
public class ClientController {
	ModelAndView mv =new ModelAndView();
	//ClientDAO cliDao=new ClientDAO();
	
	@Autowired
    private I_Client cliDao;
	
	@GetMapping("/")
	public String listclients(Model md) {
		//System.out.println(cliDao.afficherClients());
		md.addAttribute("data",cliDao.afficherClients());
		return "list_cli";
	}
	@GetMapping("/Add")
	public String addclient(Model md) {
		return "Client";
	}
	
	@GetMapping("/Update/{id}")
	public String updateclient(Model md,@PathVariable int id) {
		md.addAttribute("mod", "mod");
		md.addAttribute("client",cliDao.afficherClientAvecId(id));
		return  "Client";
	}
	@GetMapping("/Delete/{id}")
	public ModelAndView deleteclient(HttpServletRequest req,HttpServletResponse res,@PathVariable int id) {
		mv.setViewName("../../ViewClient/list_cli");
		if(cliDao.supprimeClient(id)) {
			mv.addObject("data",cliDao.afficherClientAvecId(id));
		}
		return mv;
	}
	@PostMapping("/operation")
	public String postaddclient(HttpServletRequest req) {
		String op=req.getParameter("op");
		String id=req.getParameter("id");
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String tel=req.getParameter("tel");
		String adresse=req.getParameter("adresse");
		if(op != null) {
			if(op.equals("ajouter")) {
				Client cl=new Client.ClientBuilder().setNom(nom).setPrenom(prenom).setTel(tel).setAdresse(adresse).build();
				if(cliDao.ajouterClient(cl)!=null) {
					return "redirect:/client/";
				}else {
					System.out.println("Ajout client pas reussi");

				}
			}else if(op.equals("modifier")) {
				Client cl=new Client.ClientBuilder().setId_client(Integer.parseInt(id)).setNom(nom).setPrenom(prenom).setTel(tel).setAdresse(adresse).build();
				if(cliDao.modifierClient(cl)!=null) {
					return "redirect:/client/";
				}else {
					System.out.println("Modification client pas reussi");
				}
			}
		}
		
		return null;		
	}
	@PostMapping("/test")
	public ModelAndView postmodclient(HttpServletRequest req) {
		/*String id=req.getParameter("id");
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String tel=req.getParameter("tel");
		String adresse=req.getParameter("adresse");
		Client cl=new Client.ClientBuilder().setId_client(Integer.parseInt(id)).setNom(nom).setPrenom(prenom).setTel(tel).setAdresse(adresse).build();
		if(cliDao.modifierClient(cl)!=null) {
			return new ModelAndView("redirect:/client/");
		}else {
			System.out.println("Ajout client pas reussi");
		}*/
		return null;	
	}
}

