package org.agile4j.architecture.cartmgr.web;

import org.agile4j.architecture.cartmgr.service.ICartService;
import org.agile4j.architecture.cartmgr.vo.CartModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LogManager.getLogger(CartController.class) ;
	
	private ICartService cartService ;
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public String toAdd() {
		return "cart/cartAdd" ;
	}
	
	/**
	 * 执行新增
	 * @param cm
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("cm")CartModel cm) {
		cartService.create(cm);
		return "success";
	}
	
	/**
	 * 跳转到删除页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toDelete/{uuid}")
	public String toDelete(@PathVariable("uuid")Integer uuid,Model model) {
		CartModel cm = this.cartService.getByUuid(uuid) ;
		model.addAttribute("cm", cm); 
		return "cart/cartDelete" ;
	}
	
	/**
	 * 执行删除
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("uuid") Integer uuid) {
		this.cartService.delete(uuid);
		return "success";
	}
	
	/**
	 * 跳转到更新页面
	 * @param uuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toUpdate/{uuid}", method=RequestMethod.POST)
	public String toUpdate(@PathVariable("uuid")Integer uuid, Model model){
		CartModel cm = this.cartService.getByUuid(uuid) ;
		model.addAttribute("cm", cm) ;
		return "cart/cartUpdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("cm") CartModel cm) {
		this.cartService.update(cm);
		return "success" ;
	}
	
}
