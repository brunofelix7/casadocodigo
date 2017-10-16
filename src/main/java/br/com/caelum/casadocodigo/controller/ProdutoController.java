package br.com.caelum.casadocodigo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.caelum.casadocodigo.dao.ProdutoDAO;
import br.com.caelum.casadocodigo.model.Produto;
import br.com.caelum.casadocodigo.model.TipoPreco;
import br.com.caelum.casadocodigo.validation.ProdutoValidation;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	/**
	 * O ModelAndView é uma classe do Spring que faz um relacionamento de um modelo (model) com uma visualização (view)
	 * Este além de poder disponibilizar um outro objeto qualquer para a view pode fazer outras operações, 
	 * como redirecionamento de páginas, entre outras.
	 */
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	/**
	 * Inicializa ou liga alguma coisa, no caso é responsável por vincular o validador com o controller.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidation());
	}
	
	/**
	 * O parâmetro Produto deve ser passsado porque o formulário foi configurado para guardar os 
	 * dados mesmo quando acontecer erros de validação, dessa forma, ele precisa de um objeto para 
	 * poder armazenar esses dados e para poder exibir o formulário, mesmo que vazio.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Produto produto){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return form(produto);
		}
		produtoDAO.save(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}

}
