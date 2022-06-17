package io.db.webproject.controller;

import io.db.webproject.entities.*;
import io.db.webproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.SpringCacheAnnotationParser;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;

@Controller
public class goodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CartRepository cartRepository;


    @RequestMapping(path = "/goods", method = RequestMethod.GET)
    public String HelloController(@RequestParam(required = false, defaultValue = "-1") Integer cat_id,@RequestParam(required = false) Integer manufactur_id,Model model){
        if (cat_id > 0 && manufactur_id != null) {
            model.addAttribute("goods", goodsRepository.findgoodsByCategory_idAndManufacturd_id(cat_id, manufactur_id));
              model.addAttribute("category", categoryRepository.findAll());
              model.addAttribute("manufacturer", manufacturerRepository.findByCategoryId(cat_id));

        } else if (cat_id > 0) {
            model.addAttribute("goods", goodsRepository.findGoodsByCategory_id(cat_id));
            model.addAttribute("category", categoryRepository.findAll());
            model.addAttribute("manufacturer", manufacturerRepository.findByCategoryId(cat_id));
        } else {
            model.addAttribute("goods", goodsRepository.findAll(Sort.by(Sort.Direction.ASC, "goodid")));
            model.addAttribute("category", categoryRepository.findAll());
            model.addAttribute("manufacturer", manufacturerRepository.findAll());
        }
        return "goods";
    }
    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public String CartController(Model model){
        int totalprice = 0;
        for (cart cartPrice : cartRepository.findAll()) {
            totalprice += cartPrice.getPrice() * cartPrice.getCount();
        }
        model.addAttribute("totalPrice", Integer.toString(totalprice));
        model.addAttribute("cart", cartRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
        return "cart";
    }

    @PostMapping(value = "cart/delete", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String DeleteFromCart(@RequestBody MultiValueMap<String, String> formData){
        if(!formData.isEmpty() && formData.get("id") != null){
            cartRepository.DeleteFromCart(Integer.parseInt(formData.get("id").get(0)));
            return "Good removed from Cart successful";
        }
        return "Good removed from Cart unsuccessful";
    }


    @PostMapping(value = "cart/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String AddToCart(@RequestBody MultiValueMap<String, String> formData){
    if(!formData.isEmpty() && formData.get("goodid") != null){
        cartRepository.addToCart(Integer.parseInt(formData.get("goodid").get(0)));
        return "Good added to Cart successful";
    }
    return "Good added to Cart unsuccessful";
    }
}
