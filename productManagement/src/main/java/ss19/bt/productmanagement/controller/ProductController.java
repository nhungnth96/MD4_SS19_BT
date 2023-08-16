package ss19.bt.productmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ss19.bt.productmanagement.model.Product;
import ss19.bt.productmanagement.service.ProductService;


import java.util.List;

@Controller
@RequestMapping(value = {"/","/product"})
public class ProductController {
    private final ProductService productService = new ProductService();
    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @PostMapping("/save")
    public String save(Product product,RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "Added product successfully!");
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Updated product successfully!");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }







}
