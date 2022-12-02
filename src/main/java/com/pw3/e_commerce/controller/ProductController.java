package com.pw3.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pw3.e_commerce.domain.Product;
import com.pw3.e_commerce.service.ProductService;

@Controller
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Product product) {

        return "/produto/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Product product, RedirectAttributes attr) {
        System.out.println("teste");
        service.salvar(product);
        attr.addFlashAttribute("success", "Produto inserido com sucesso.");
        return "redirect:/produtos/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", service.buscarPorId(id));
        return "/produto/edicao";
    }

    @PostMapping("/editar")
    public String editar(Product product, RedirectAttributes attr) {
        service.editar(product);
        attr.addFlashAttribute("success", "Produto editado com sucesso.");
        return "redirect:/produtos/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("produtos", service.buscarTodos());
        System.out.println(service.buscarTodos());
        return "/produto/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        service.excluir(id);
        model.addAttribute("success", "Produto excluído com sucesso!!");
        return listar(model);
    }
}
